import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:products_db.db";

    public static Connection getConnection() throws Exception {
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS product (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "sub_name TEXT, " +
                "brand TEXT, " +
                "price REAL, " +
                "description TEXT, " +
                "image_name TEXT" +
                ");";

        String countSQL = "SELECT COUNT(*) FROM product;";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(createTableSQL);
            
            ResultSet rs = stmt.executeQuery(countSQL);
            if (rs.next() && rs.getInt(1) == 0) {
                String insertSQL = "INSERT INTO product (name, sub_name, brand, price, description, image_name) VALUES (?, ?, ?, ?, ?, ?);";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    String discountText = "This product is excluded from all promotional discounts and offers.";
                    
                    pstmt.setString(1, "4DFWD PULSE SHOES");
                    pstmt.setString(2, discountText);
                    pstmt.setString(3, "Adidas");
                    pstmt.setDouble(4, 160.00);
                    pstmt.setString(5, discountText);
                    pstmt.setString(6, "img1.png");
                    pstmt.executeUpdate();

                    pstmt.setString(1, "FORUM MID SHOES");
                    pstmt.setString(2, discountText);
                    pstmt.setString(3, "Adidas");
                    pstmt.setDouble(4, 100.00);
                    pstmt.setString(5, discountText);
                    pstmt.setString(6, "img2.png");
                    pstmt.executeUpdate();

                    pstmt.setString(1, "SUPERNOVA SHOES");
                    pstmt.setString(2, "NMD City Stock 2");
                    pstmt.setString(3, "Adidas");
                    pstmt.setDouble(4, 150.00);
                    pstmt.setString(5, "A comfortable running shoe designed for daily training and modern street style.");
                    pstmt.setString(6, "img3.png");
                    pstmt.executeUpdate();

                    pstmt.setString(1, "Adidas");
                    pstmt.setString(2, "NMD City Stock 2");
                    pstmt.setString(3, "Adidas");
                    pstmt.setDouble(4, 160.00);
                    pstmt.setString(5, "A lightweight sneaker with a clean look and comfortable support for everyday use.");
                    pstmt.setString(6, "img4.png");
                    pstmt.executeUpdate();

                    pstmt.setString(1, "Adidas");
                    pstmt.setString(2, "NMD City Stock 2");
                    pstmt.setString(3, "Adidas");
                    pstmt.setDouble(4, 120.00);
                    pstmt.setString(5, "A dark sport shoe with a soft sole and flexible design for casual movement.");
                    pstmt.setString(6, "img5.png");
                    pstmt.executeUpdate();

                    pstmt.setString(1, "4DFWD PULSE SHOES");
                    pstmt.setString(2, discountText);
                    pstmt.setString(3, "Adidas");
                    pstmt.setDouble(4, 160.00);
                    pstmt.setString(5, discountText);
                    pstmt.setString(6, "img6.png");
                    pstmt.executeUpdate();

                    pstmt.setString(1, "4DFWD PULSE SHOES");
                    pstmt.setString(2, discountText);
                    pstmt.setString(3, "Adidas");
                    pstmt.setDouble(4, 160.00);
                    pstmt.setString(5, discountText);
                    pstmt.setString(6, "img1.png");
                    pstmt.executeUpdate();

                    pstmt.setString(1, "FORUM MID SHOES");
                    pstmt.setString(2, discountText);
                    pstmt.setString(3, "Adidas");
                    pstmt.setDouble(4, 100.00);
                    pstmt.setString(5, discountText);
                    pstmt.setString(6, "img2.png");
                    pstmt.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
