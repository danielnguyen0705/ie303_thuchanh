import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private int boardWidth;
    private int boardHeight;

    private Background background;
    private Bird bird;
    private ArrayList<Pipe> pipes; //Tạo một ArrayList để lưu trữ các ống, tự động xóa khi chúng ra khỏi màn hình
    
    private Image topPipeImg;
    private Image bottomPipeImg;
    private Timer placePipeTimer;
    private Timer gameLoop;

    private boolean gameOver = false;
    private double score = 0; // Dùng double vì mỗi lần qua 1 cặp ống sẽ cộng 0.5 + 0.5 = 1

    //Bài 3: Xử lý game loop và đặt ống mới sau một khoảng thời gian nhất định
    public GamePanel(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;

        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setFocusable(true);
        addKeyListener(this);

        try {
            topPipeImg = new ImageIcon(getClass().getResource("/assets/toppipe.png")).getImage();
            bottomPipeImg = new ImageIcon(getClass().getResource("/assets/bottompipe.png")).getImage();
        } catch (Exception e) {
            System.out.println("Lỗi load ảnh ống.");
        }

        background = new Background(this.boardWidth, this.boardHeight);
        bird = new Bird(this.boardWidth / 8, this.boardHeight / 2);
        pipes = new ArrayList<Pipe>();

        placePipeTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });
        placePipeTimer.start();

        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
    }

    // Bài 3: Hàm đặt ống mới vào màn hình với vị trí ngẫu nhiên và khoảng cách cố định giữa ống trên và ống dưới
    public void placePipes() {
        int pipeX = boardWidth;
        int pipeY = 0;
        int pipeWidth = 64;
        int pipeHeight = 512;

        int randomPipeY = (int) (pipeY - pipeHeight / 4 - Math.random() * (pipeHeight / 2));
        int openingSpace = boardHeight / 4;

        Pipe topPipe = new Pipe(pipeX, randomPipeY, pipeWidth, pipeHeight, topPipeImg);
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(pipeX, randomPipeY + pipeHeight + openingSpace, pipeWidth, pipeHeight, bottomPipeImg);
        pipes.add(bottomPipe);
    }

    // Bài 4: Hàm xét va chạm giữa chim và ống
    public boolean collision(Bird a, Pipe b) {
        return a.getX() < b.getX() + b.getWidth() &&
               a.getX() + a.getWidth() > b.getX() &&
               a.getY() < b.getY() + b.getHeight() &&
               a.getY() + a.getHeight() > b.getY();
    }

    @Override
    // Bài 4: Hàm vẽ điểm số và thông báo Game Over
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);
        background.draw(g);
        bird.draw(g);
        
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.draw(g);
        }

        // Vẽ điểm số
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 32));
        if (gameOver) {
            g.drawString("Game Over: " + (int) score, 10, 35);
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            g.drawString("Press Space to Restart", 10, 70);
        } else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }
    }

    @Override
    //Sau thời gian gameLoop, hàm này được gọi để cập nhật lại vị trí của con chim và các ống, đồng thời kiểm tra va chạm và cập nhật điểm số.
    public void actionPerformed(ActionEvent e) {
        if (gameOver) {
            return; // Nếu thua thì dừng cập nhật
        }

        bird.update(boardHeight); //Cập nhật chiều cao của con chim
        
        for (int i = 0; i < pipes.size(); i++) { //Cập nhật vị trí của các ống
            Pipe pipe = pipes.get(i);
            pipe.update();

            // Bài 4: Kiểm tra xem nếu chim bay qua khỏi ống
            if (!pipe.isPassed() && bird.getX() > pipe.getX() + pipe.getWidth()) {
                pipe.setPassed(true);
                score += 0.5; // mỗi ống 0.5 điểm, qua 2 ống là 1 điểm
            }

            // Bài 4: Kiểm tra va chạm với ống
            if (collision(bird, pipe)) {
                gameOver = true;
            }
        }

        // Bài 4: Nếu chim chạm đất thì false
        if (bird.getY() >= boardHeight) {
            gameOver = true;
        }
        
        repaint();

        if (gameOver) {  // Bài 4: Dừng Timer nếu Game Over
            placePipeTimer.stop();
            gameLoop.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Bài 2: Xử lý nhấn phím Space hoặc Enter để chim bay lên 
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (gameOver) {
                // Bài 4: Xử lý Restart Game
                bird.reset(boardWidth / 8, boardHeight / 2);
                pipes.clear();
                score = 0;
                gameOver = false;
                gameLoop.start();
                placePipeTimer.start();
            } else {
                bird.jump();
            }
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}