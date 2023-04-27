import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        mainForm formaPrincipal = new mainForm();

        formaPrincipal.setContentPane(formaPrincipal.getMainPanel());
        formaPrincipal.setBounds(100,100,500,500);
        formaPrincipal.setVisible(true);
        formaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}