import javax.swing.*;
import java.awt.event.*;

public class CalcListener implements ActionListener {
    private JTextField display;
    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    public CalcListener(JTextField display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("C")) {
            display.setText("0");
            start = true;
            return;
        }

        if ("0123456789".contains(cmd)) {
            if (start) {
                display.setText(cmd);
            } else {
                display.setText(display.getText() + cmd);
            }
            start = false;
        } else if (cmd.equals("=")) {
            double num2 = Double.parseDouble(display.getText());
            calculate(num2);
            operator = "";
            start = true;
        } else {
            num1 = Double.parseDouble(display.getText());
            operator = cmd;
            start = true;
        }
    }

    private void calculate(double num2) {
        switch (operator) {
            case "+": num1 += num2; break;
            case "-": num1 -= num2; break;
            case "*": num1 *= num2; break;
            case "/": num1 /= num2; break;
        }
        display.setText(String.valueOf(num1));
    }
}