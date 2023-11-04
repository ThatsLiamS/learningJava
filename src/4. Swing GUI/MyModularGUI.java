/* Import Required Modules & Packages */
import javax.swing.*;
import java.awt.GridLayout;

public class MyModularGUI {
    
    /* Declare Global Variables */
    JFrame myWindow = new JFrame("Hello Modular Swing Type Stuff!");

    JPanel myPanelForStuff = new JPanel(null);

    JButton btnTest = new JButton("Test Here");
    JButton btnRealTest = new JButton("Real Test Here");


    public void buildMyModularGUI() {

        /* Customize up the Window */
        myWindow.setSize(500, 400);
        myWindow.setLocation(200, 200);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setLayout(new GridLayout(1,1));

        /* Method Call => Add Components to the Window */
        addSomeStuff();

        /* Add the JPanel to the Window */
        myWindow.add(myPanelForStuff);
        myWindow.setVisible(true);
    };

    /* Method Declaration => Creates 2 Buttons*/
    public void addSomeStuff() {   
        btnTest.setSize(150, 40);
        btnTest.setLocation(40, 40);
        myPanelForStuff.add(btnTest);

        btnRealTest.setSize(150, 40);
        btnRealTest.setLocation(100,200);
        myPanelForStuff.add(btnRealTest);
    };

    /* Main Method => run the buildModularGui Func */
    public static void main(String[] args) {
        
        /* Method Call */
        MyModularGUI myClass = new MyModularGUI();
        myClass.buildMyModularGUI();
    };
};
