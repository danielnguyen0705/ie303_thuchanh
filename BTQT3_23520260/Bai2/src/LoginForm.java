import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPassword;

    public LoginForm() {
        setTitle("Đăng nhập hệ thống");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel(" Tên đăng nhập:"));
        txtUser = new JTextField();
        add(txtUser);

        add(new JLabel(" Mật khẩu:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        JButton btnLogin = new JButton("Đăng nhập");
        JButton btnExit = new JButton("Thoát");

        add(btnLogin);
        add(btnExit);

        // Gán xử lý sự kiện
        LoginListener listener = new LoginListener(txtUser, txtPassword);
        btnLogin.addActionListener(listener);
        btnExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}