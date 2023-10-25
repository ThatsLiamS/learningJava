import java.awt.*;
import javax.swing.*;

public class MyFirstGUI {
    JFrame nameOfFrame = new JFrame();
    JPanel myPanel = new JPanel(null);
    JButton btnLogin = new JButton();

    public void startGUI() {
        JOptionPane.showMessageDialog(null,"Get off my code, you thief"); 
        JOptionPane.showMessageDialog(null,"No, seriously, Write your own and comment it. I know this code.");
        JOptionPane.showMessageDialog(null,"Cheers. Winstanley Comp Sci");

        nameOfFrame.setLayout(new GridLayout(1,1));
        nameOfFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        createMyPanel();
        nameOfFrame.add(myPanel);

        nameOfFrame.setTitle("HOME");
        nameOfFrame.setSize(700,400);
        nameOfFrame.setVisible(true);
        nameOfFrame.setResizable(true);
    };

    public void createMyPanel() {
        btnLogin.setLocation(105,221);
        btnLogin.setSize(100,50);
        btnLogin.setText("Login");
        myPanel.add(btnLogin);
    };
    
    public static void main(String[] args ) {
        MyFirstGUI myClass = new MyFirstGUI();
        myClass.startGUI();
    };
};
