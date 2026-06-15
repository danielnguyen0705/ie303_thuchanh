import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class ImageUtil {
    public static Image loadImage(String fileName) {
        try {
            URL url = ImageUtil.class.getResource("/assets/" + fileName);

            if (url != null) {
                return new ImageIcon(url).getImage();
            }

            File file = new File("src/assets/" + fileName);

            if (file.exists()) {
                return new ImageIcon(file.getAbsolutePath()).getImage();
            }

            File file2 = new File("src/assets/" + fileName);

            if (file2.exists()) {
                return new ImageIcon(file2.getAbsolutePath()).getImage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return createPlaceholder(fileName, 180, 110);
    }

    public static ImageIcon loadIcon(String fileName, int maxWidth, int maxHeight) {
        Image image = loadImage(fileName);

        ImageIcon originalIcon = new ImageIcon(image);
        int originalWidth = originalIcon.getIconWidth();
        int originalHeight = originalIcon.getIconHeight();

        if (originalWidth <= 0 || originalHeight <= 0) {
            return new ImageIcon(createPlaceholder(fileName, maxWidth, maxHeight));
        }

        double scale = Math.min(
                (double) maxWidth / originalWidth,
                (double) maxHeight / originalHeight
        );

        int newWidth = (int) Math.round(originalWidth * scale);
        int newHeight = (int) Math.round(originalHeight * scale);

        BufferedImage resizedImage = new BufferedImage(
                newWidth,
                newHeight,
                BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g2 = resizedImage.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(image, 0, 0, newWidth, newHeight, null);
        g2.dispose();

        return new ImageIcon(resizedImage);
    }

    private static Image createPlaceholder(String text, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();

        g2.setColor(new Color(235, 235, 235));
        g2.fillRoundRect(0, 0, width, height, 18, 18);

        g2.setColor(Color.GRAY);
        g2.setFont(new Font("SansSerif", Font.BOLD, 14));

        FontMetrics fm = g2.getFontMetrics();

        int x = (width - fm.stringWidth(text)) / 2;
        int y = height / 2;

        g2.drawString(text, x, y);
        g2.dispose();

        return image;
    }
}