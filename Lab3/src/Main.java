import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductStoreFrame frame = new ProductStoreFrame();
            frame.setVisible(true);
        });
    }
}