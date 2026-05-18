import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProductStoreFrame extends JFrame {
    private final List<Product> products;
    private final List<ProductCard> productCards;

    private ProductDetailPanel detailPanel;
    private JPanel gridPanel;

    public ProductStoreFrame() {
        products = createProducts();
        productCards = new ArrayList<>();

        initFrame();
        initLayout();
        selectProduct(products.get(0));
    }

    private void initFrame() {
        setTitle("Adidas Product Store");
        setSize(1180, 600);
        setMinimumSize(new Dimension(1180, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void initLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        detailPanel = new ProductDetailPanel(products.get(0));
        mainPanel.add(detailPanel, BorderLayout.WEST);

        JPanel rightWrapper = new JPanel(new BorderLayout());
        rightWrapper.setBackground(Color.WHITE);

        // Giảm khoảng trắng phía trên, bỏ scroll
        rightWrapper.setBorder(BorderFactory.createEmptyBorder(22, 16, 18, 24));

        gridPanel = new JPanel(new GridLayout(2, 4, 12, 12));
        gridPanel.setBackground(Color.WHITE);

        for (Product product : products) {
            ProductCard card = new ProductCard(product, this::selectProduct);
            productCards.add(card);
            gridPanel.add(card);
        }

        rightWrapper.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(rightWrapper, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    private void selectProduct(Product selectedProduct) {
        detailPanel.setProduct(selectedProduct);

        for (ProductCard card : productCards) {
            card.setSelectedCard(card.getProduct() == selectedProduct);
        }
    }

    private List<Product> createProducts() {
        List<Product> list = new ArrayList<>();

        String discountText = "This product is excluded from all promotional discounts and offers.";

        list.add(new Product(
                "4DFWD PULSE SHOES",
                discountText,
                "Adidas",
                160.00,
                discountText,
                "img1.png"
        ));

        list.add(new Product(
                "FORUM MID SHOES",
                discountText,
                "Adidas",
                100.00,
                discountText,
                "img2.png"
        ));

        list.add(new Product(
                "SUPERNOVA SHOES",
                "NMD City Stock 2",
                "Adidas",
                150.00,
                "A comfortable running shoe designed for daily training and modern street style.",
                "img3.png"
        ));

        list.add(new Product(
                "Adidas",
                "NMD City Stock 2",
                "Adidas",
                160.00,
                "A lightweight sneaker with a clean look and comfortable support for everyday use.",
                "img4.png"
        ));

        list.add(new Product(
                "Adidas",
                "NMD City Stock 2",
                "Adidas",
                120.00,
                "A dark sport shoe with a soft sole and flexible design for casual movement.",
                "img5.png"
        ));

        list.add(new Product(
                "4DFWD PULSE SHOES",
                discountText,
                "Adidas",
                160.00,
                discountText,
                "img6.png"
        ));

        list.add(new Product(
                "4DFWD PULSE SHOES",
                discountText,
                "Adidas",
                160.00,
                discountText,
                "img1.png"
        ));

        list.add(new Product(
                "FORUM MID SHOES",
                discountText,
                "Adidas",
                100.00,
                discountText,
                "img2.png"
        ));

        return list;
    }
}