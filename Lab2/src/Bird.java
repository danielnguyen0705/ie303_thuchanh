//Bài 2: Tạo lớp Bird để quản lý vị trí, hình ảnh và hành động của con chim trong trò chơi
import java.awt.*;
import javax.swing.*;

public class Bird {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image img;

    private int velocityY = 0; // Tốc độ rơi hiện tại
    private int gravity = 1; // Giá trị gia tốc

    public Bird(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.width = 44;
        this.height = 34;
        
        try {
            this.img = new ImageIcon(getClass().getResource("/assets/flappybird.png")).getImage();
        } catch (Exception e) {
            System.out.println("Lỗi load ảnh chim.");
        }
    }

    // Hành động bay lên
    public void jump() {
        this.velocityY = -9;
    }

    // Cập nhật vị trí mỗi khung hình
    public void update(int boardHeight) {
        velocityY += gravity;
        y += velocityY;

        // Giới hạn không bay quá trần
        y = Math.max(y, 0);

        // Tạm thời dừng ở đáy
        if (y > boardHeight) {
            y = boardHeight;
        }
    }

    // Tự vẽ chính nó
    public void draw(Graphics g) {
        if (img != null && img.getWidth(null) != -1) {
            g.drawImage(img, x, y, width, height, null);
        } else {
            g.setColor(Color.YELLOW);
            g.fillRect(x, y, width, height);
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    
    // Hàm reset vị trí khi chơi lại
    public void reset(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.velocityY = 0;
    }
}