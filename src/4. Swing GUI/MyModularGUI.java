import javax.swing.*;
import java.awt.GridLayout;

public class MyModularGUI {
    JFrame myWindow = new JFrame("Hello Modular Swing Type Stuff!");

    JPanel myPanelForStuff = new JPanel(null);

    JButton btnTest = new JButton("Test Here");
    JButton btnRealTest = new JButton("Real Test Here");


    public void buildMyModularGUI() {

        myWindow.setSize(500, 400);
        myWindow.setLocation(200, 200);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setVisible(true);
        myWindow.setLayout(new GridLayout(1,1));


        addSomeStuff();

        myWindow.add(myPanelForStuff);
    };


    public void addSomeStuff() {   
        btnTest.setSize(150, 40);
        btnTest.setLocation(40, 40);
        myPanelForStuff.add(btnTest);

        btnRealTest.setSize(150, 40);
        btnRealTest.setLocation(100,200);
        myPanelForStuff.add(btnRealTest);
    };

    public static void main(String[] args) {
        MyModularGUI mmg = new MyModularGUI();
        mmg.buildMyModularGUI();
    };
};
