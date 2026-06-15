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
        try (java.sql.Connection conn = DatabaseHelper.getConnection();
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery("SELECT name, sub_name, brand, price, description, image_name FROM product")) {
            while (rs.next()) {
                list.add(new Product(
                        rs.getString("name"),
                        rs.getString("sub_name"),
                        rs.getString("brand"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image_name")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}