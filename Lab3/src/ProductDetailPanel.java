import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailPanel extends JPanel {
    private Product product;
    private Image productImage;

    private Timer animationTimer;
    private float alpha = 1.0f;
    private int slideOffset = 0;

    public ProductDetailPanel(Product product) {
        this.product = product;
        this.productImage = ImageUtil.loadImage(product.getImageName());

        setPreferredSize(new Dimension(305, 600));
        setBackground(Color.WHITE);
    }

    public void setProduct(Product product) {
        this.product = product;
        this.productImage = ImageUtil.loadImage(product.getImageName());

        alpha = 0.0f;
        slideOffset = 20;

        if (animationTimer != null && animationTimer.isRunning()) {
            animationTimer.stop();
        }

        animationTimer = new Timer(16, e -> {
            alpha += 0.08f;
            slideOffset -= 2;

            if (alpha >= 1.0f) {
                alpha = 1.0f;
                slideOffset = 0;
                animationTimer.stop();
            }

            repaint();
        });

        animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (product == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        drawProductImage(g2);
        drawSeparator(g2);
        drawProductInfo(g2);

        g2.dispose();
    }

    private void drawProductImage(Graphics2D g2) {
        if (productImage == null) {
            return;
        }

        int maxWidth = 350;
        int maxHeight = 260;

        int imgWidth = productImage.getWidth(null);
        int imgHeight = productImage.getHeight(null);

        if (imgWidth <= 0 || imgHeight <= 0) {
            return;
        }

        double scale = Math.min((double) maxWidth / imgWidth, (double) maxHeight / imgHeight);

        int drawWidth = (int) Math.round(imgWidth * scale);
        int drawHeight = (int) Math.round(imgHeight * scale);

        int x = (getWidth() - drawWidth) / 2;
        int y = 45 + slideOffset;

        g2.drawImage(productImage, x, y, drawWidth, drawHeight, null);
    }

    private void drawSeparator(Graphics2D g2) {
        g2.setColor(new Color(190, 190, 190));
        g2.drawLine(15, 255, getWidth() - 15, 255);
    }

    private void drawProductInfo(Graphics2D g2) {
        int x = 15;
        int y = 292 + slideOffset;

        g2.setColor(new Color(80, 80, 80));
        g2.setFont(new Font("SansSerif", Font.BOLD, 20));
        g2.drawString(product.getName(), x, y);

        y += 32;
        g2.setFont(new Font("SansSerif", Font.BOLD, 20));
        g2.drawString(String.format("$%.2f", product.getPrice()), x, y);

        y += 26;
        g2.setFont(new Font("SansSerif", Font.PLAIN, 13));
        g2.setColor(new Color(80, 80, 80));
        g2.drawString(product.getBrand(), x, y);

        y += 30;
        g2.setFont(new Font("SansSerif", Font.BOLD, 14));
        g2.setColor(new Color(150, 150, 150));

        List<String> lines = wrapText(product.getDescription(), 35);

        for (String line : lines) {
            g2.drawString(line, x, y);
            y += 19;
        }
    }

    private List<String> wrapText(String text, int maxLength) {
        List<String> lines = new ArrayList<>();

        if (text == null || text.isBlank()) {
            return lines;
        }

        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (currentLine.length() + word.length() + 1 > maxLength) {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            } else {
                if (!currentLine.isEmpty()) {
                    currentLine.append(" ");
                }

                currentLine.append(word);
            }
        }

        if (!currentLine.isEmpty()) {
            lines.add(currentLine.toString());
        }

        return lines;
    }
}