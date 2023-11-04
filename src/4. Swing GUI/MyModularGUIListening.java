/* Import Required Modules & Packages */
import javax.swing.*;
import java.awt.GridLayout;

public class MyModularGUIListening {
    
    /* Declare Global Variables */
    JFrame myWindow = new JFrame("Hello Modular Swing Type Stuff!");

    JPanel myPanelForStuff = new JPanel(null);

    JButton btnTest = new JButton("HERE");
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
        btnTest.setSize(100, 40);
        btnTest.setLocation(40, 40);
        myPanelForStuff.add(btnTest);

        /* Add an Action Listener to the Test Button */
        btnTest.addActionListener( AL-> btnTest_Click() );

        btnRealTest.setSize(150, 40);
        btnRealTest.setLocation(100,200);
        myPanelForStuff.add(btnRealTest);

        /* Add an Action Listener to the Real Button */
        btnRealTest.addActionListener( AL-> btnRealTest_Click() );
    };

    /* What happens when the test-button is clicked */
    public void btnTest_Click() {
        System.out.println("Test button pressed");
    };
    /* What happens when the real-button is clicked */
    public void btnRealTest_Click() {
        System.out.println("Real Test button pressed");
    };


    /* Main Method => run the buildModularGui Func */
    public static void main(String[] args) {

        /* Method Call */
        MyModularGUIListening myClass = new MyModularGUIListening();
        myClass.buildMyModularGUI();
    };
};
