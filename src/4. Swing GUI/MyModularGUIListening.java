import javax.swing.*;
import java.awt.GridLayout;

public class MyModularGUIListening {
    JFrame myWindow = new JFrame("Hello Modular Swing Type Stuff!");

    JPanel myPanelForStuff = new JPanel(null);

    JButton btnTest = new JButton("HERE");
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
        btnTest.setSize(100, 40);
        btnTest.setLocation(40, 40);
        myPanelForStuff.add(btnTest);

        btnTest.addActionListener( AL->btnTest_Click() );

        btnRealTest.setSize(150, 40);
        btnRealTest.setLocation(100,200);
        myPanelForStuff.add(btnRealTest);

        btnRealTest.addActionListener( AL->btnRealTest_Click() );
    };

    public void btnTest_Click() {
    	System.out.println("Test button pressed");
    };

    public void btnRealTest_Click() {
    	System.out.println("Real Test button pressed");
    };


    public static void main(String[] args) {
        MyModularGUIListening mmg = new MyModularGUIListening();
        mmg.buildMyModularGUI();
    };
};
