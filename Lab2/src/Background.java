//Bài 1: Tạo lớp Background để vẽ nền cho trò chơi
import java.awt.*;
import javax.swing.*;

public class Background {
    private int width;
    private int height;
    private Image img;

    public Background(int width, int height) {
        this.width = width;
        this.height = height;
        
        try {
            this.img = new ImageIcon(getClass().getResource("/assets/flappybirdbg.png")).getImage();
        } catch (Exception e) {
            System.out.println("Lỗi load ảnh nền.");
        }
    }

    public void draw(Graphics g) {
        if (img != null && img.getWidth(null) != -1) {
            g.drawImage(img, 0, 0, width, height, null);
        } else {
            g.setColor(new Color(113, 197, 207));
            g.fillRect(0, 0, width, height);
        }
    }
}