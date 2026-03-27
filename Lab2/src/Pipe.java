//Bài 3: Tạo lớp Pipe để vẽ các ống cản đường chim và xử lý chuyển động của chúng
import java.awt.*;

public class Pipe {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image img;
    
    // Tốc độ di chuyển sang trái
    private int velocityX = -4;

    // Biến kiểm tra xem chim đã bay qua ống chưa để cộng điểm
    private boolean passed = false;

    public Pipe(int x, int y, int width, int height, Image img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
    }

    public void update() {
        x += velocityX;
    }

    public void draw(Graphics g) {
        if (img != null) {
            g.drawImage(img, x, y, width, height, null);
        } else {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, width, height);
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public boolean isPassed() { return passed; }
    public void setPassed(boolean passed) { this.passed = passed; }
}