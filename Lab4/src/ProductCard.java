import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

public class ProductCard extends JPanel {
    private final Product product;

    private boolean selected = false;
    private boolean hovered = false;

    private float hoverProgress = 0.0f;
    private Timer hoverTimer;

    private JPanel contentPanel;
    private JLabel titleLabel;
    private JLabel subTitleLabel;
    private JLabel imageLabel;
    private JLabel brandLabel;
    private JLabel priceLabel;

    public ProductCard(Product product, Consumer<Product> onClick) {
        this.product = product;

        setOpaque(false);
        setLayout(new BorderLayout());
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        initComponents();
        initEvents(onClick);
    }

    private void initComponents() {
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        contentPanel.setBorder(new EmptyBorder(18, 12, 14, 12));

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        titleLabel = new JLabel(shortText(product.getName(), 18));
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setForeground(new Color(70, 70, 70));

        subTitleLabel = new JLabel(shortText(product.getSubName(), 28));
        subTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        subTitleLabel.setForeground(new Color(160, 160, 160));

        topPanel.add(titleLabel);
        topPanel.add(Box.createVerticalStrut(8));
        topPanel.add(subTitleLabel);

        imageLabel = new JLabel(ImageUtil.loadIcon(product.getImageName(), 240, 155));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);

        brandLabel = new JLabel(product.getBrand());
        brandLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        brandLabel.setForeground(new Color(75, 75, 75));

        priceLabel = new JLabel(String.format("$%.2f", product.getPrice()));
        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        priceLabel.setForeground(new Color(75, 75, 75));

        bottomPanel.add(brandLabel, BorderLayout.WEST);
        bottomPanel.add(priceLabel, BorderLayout.EAST);

        contentPanel.add(topPanel, BorderLayout.NORTH);
        contentPanel.add(imageLabel, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(contentPanel, BorderLayout.CENTER);
    }

    private void initEvents(Consumer<Product> onClick) {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClick.accept(product);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                animateHover(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Point mousePoint = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(mousePoint, ProductCard.this);

                if (!contains(mousePoint)) {
                    hovered = false;
                    animateHover(false);
                }
            }
        };

        registerMouseListenerForAllComponents(this, adapter);
    }

    private void registerMouseListenerForAllComponents(Component component, MouseAdapter adapter) {
        component.addMouseListener(adapter);

        if (component instanceof Container container) {
            for (Component child : container.getComponents()) {
                registerMouseListenerForAllComponents(child, adapter);
            }
        }
    }

    private void animateHover(boolean toHover) {
        if (hoverTimer != null && hoverTimer.isRunning()) {
            hoverTimer.stop();
        }

        hoverTimer = new Timer(12, e -> {
            float target = toHover ? 1.0f : 0.0f;
            float speed = 0.12f;

            if (hoverProgress < target) {
                hoverProgress += speed;
                if (hoverProgress > 1.0f) {
                    hoverProgress = 1.0f;
                }
            } else {
                hoverProgress -= speed;
                if (hoverProgress < 0.0f) {
                    hoverProgress = 0.0f;
                }
            }

            int lift = Math.round(5 * hoverProgress);
            contentPanel.setBorder(new EmptyBorder(18 - lift, 12, 14 + lift, 12));

            repaint();

            if (hoverProgress == target) {
                hoverTimer.stop();
            }
        });

        hoverTimer.start();
    }

    public void setSelectedCard(boolean selected) {
        this.selected = selected;
        repaint();
    }

    public Product getProduct() {
        return product;
    }

    private String shortText(String text, int maxLength) {
        if (text == null) {
            return "";
        }

        if (text.length() <= maxLength) {
            return text;
        }

        return text.substring(0, maxLength) + "...";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int lift = Math.round(5 * hoverProgress);

        int x = 3;
        int y = 5 - lift;
        int w = getWidth() - 8;
        int h = getHeight() - 10;

        int shadowAlpha = selected ? 35 : Math.round(55 * hoverProgress);

        if (shadowAlpha > 0) {
            g2.setColor(new Color(0, 0, 0, shadowAlpha));
            g2.fillRoundRect(x + 4, y + 8, w, h, 14, 14);
        }

        if (selected) {
            g2.setColor(new Color(246, 249, 255));
        } else if (hovered) {
            g2.setColor(new Color(248, 248, 248));
        } else {
            g2.setColor(new Color(240, 240, 240));
        }

        g2.fillRoundRect(x, y, w, h, 14, 14);

        if (selected) {
            g2.setColor(new Color(90, 140, 255));
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(x + 1, y + 1, w - 2, h - 2, 14, 14);
        }

        g2.dispose();
    }
}