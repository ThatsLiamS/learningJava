/* Import Required Modules & Packages */
import javax.swing.*;
import java.awt.*;

public class MyModularLightbulb {

    /* Declare Global Variables */
    boolean status = false;
    JFrame myWindow = new JFrame("My Modular Lightbulb");

    /* Main Method => Run the buildGUI Function */
    public static void main(String[] args) {
        MyModularLightbulb myClass = new MyModularLightbulb();
        myClass.buildGUI();
    };

    /* Generate Window Components */
    public void buildGUI() {
        MyModularLightbulb myClass = new MyModularLightbulb();

        /* Customize the Window Size */
        myWindow.setSize(330, 225);
        myWindow.setLocation(700, 375);
        myWindow.setLayout(null);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        myWindow.setResizable(false);

        /* Create a Label */
        JLabel myLabel = myClass.createLabel("The lightbulb is: OFF!", 95, 50);
        myWindow.add(myLabel);

        /* Create Buttons */
        JButton offButton = myClass.createButton("Off!", 15, 120);
        offButton.addActionListener(AL -> buttonWasClicked("offBtn", myLabel));
        myWindow.add(offButton);

        JButton onButton = myClass.createButton("On!", 200, 120);
        onButton.addActionListener(AL -> buttonWasClicked("onBtn", myLabel));
        myWindow.add(onButton);


        /* Make the window visible _last_ */
        myWindow.setVisible(true);
    };

    /* Dynamically generate JLabels */
    public JLabel createLabel(String text, int xPos, int yPos) {
        JLabel myLabel = new JLabel();
        myLabel.setText(text);
        myLabel.setSize(180, 15);
        myLabel.setLocation(xPos, yPos);
        myLabel.setForeground(Color.red);

        return myLabel;
    };

    /* Dynamically generate JButtons */
    public JButton createButton(String label, int xPos, int yPos) {
        JButton myButton = new JButton(label);
        myButton.setSize(100, 40);
        myButton.setLocation(xPos, yPos);

        return myButton;
    };

    /* Action On: Button Click */
    public void buttonWasClicked(String btnVersion, JLabel myLabel) {

        /* Determine the Button Pressed */
        status = (btnVersion.equalsIgnoreCase("onBtn") == true)
            ? true
            : false;

        /* Change the Values */
        myLabel.setText("The lightbulb is: " + (status == true ? "ON" : "OFF") + "!");
        myLabel.setForeground((status == true) ? Color.blue : Color.red);
    };
};
