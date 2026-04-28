import javax.swing.*;
import java.awt.event.*;

public class LoginListener implements ActionListener {
    private JTextField user;
    private JPasswordField pass;

    public LoginListener(JTextField user, JPasswordField pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = user.getText();
        String password = new String(pass.getPassword());

        if (username.equals("admin") && password.equals("123")) {
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Thông tin không chính xác!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}