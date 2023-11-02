import java.awt.*;
import javax.swing.*;

public class MyBasicFrame {

    public static void main(String[] args) {

        /* Create the JFrame Window */
        JFrame myWindow = new JFrame();
        myWindow.setTitle("My Basic Frame!");
        myWindow.setSize(800, 800);
        myWindow.setLocation(10, 10);
        myWindow.setLayout(null);

        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        //myWindow.setVisible(true);
        myWindow.setResizable(false);


        /* Create a JButton */
        JButton myButton = new JButton("Button!");
        myButton.setSize(100, 100);
        myButton.setLocation(25, 5);
        myWindow.add(myButton);


        /* Create a JLabel */
        JLabel myLabel = new JLabel("I am a Label!");
        myLabel.setForeground(Color.red);
        myLabel.setSize(75, 85);
        myLabel.setLocation(325, 10);
        myWindow.add(myLabel);


        /* Create a JTextField */
        JTextField myTextField = new JTextField();
        myTextField.setText("Text Field: Enter data...");
        myTextField.setSize(150, 45);
        myTextField.setLocation(25, 200);
        myTextField.setForeground(Color.blue);
        myWindow.add(myTextField);


        /* Create a JComboBox */
        String[] options = new String[] {"OptionOne", "OptionTwo", "OptionThree"};
        JComboBox<String> myComboBox = new JComboBox<String> (options);
        myComboBox.setSize(105, 45);
        myComboBox.setLocation(315, 200);
        myWindow.add(myComboBox);


        /* Create a JRadioButton */
        ButtonGroup myButtonGroup = new ButtonGroup();

        JRadioButton myRadioButtonOne = new JRadioButton("Option One");
        myRadioButtonOne.setBounds(500, 10, 110, 25);
        JRadioButton myRadioButtonTwo = new JRadioButton("Option Two");
        myRadioButtonTwo.setBounds(500, 40, 110, 25);
        JRadioButton myRadioButtonThree = new JRadioButton("Option Three");
        myRadioButtonThree.setBounds(500, 70, 110, 25);
        JRadioButton myRadioButtonFour = new JRadioButton("Option Four");
        myRadioButtonFour.setBounds(500, 100, 110, 25);

        myButtonGroup.add(myRadioButtonOne);
        myButtonGroup.add(myRadioButtonTwo);
        myButtonGroup.add(myRadioButtonThree);
        myButtonGroup.add(myRadioButtonFour);

        myWindow.add(myRadioButtonOne);
        myWindow.add(myRadioButtonTwo);
        myWindow.add(myRadioButtonThree);
        myWindow.add(myRadioButtonFour);


        /* Create a JCheckBox */
        JCheckBox myCheckBoxOne = new JCheckBox("Option One");
        myCheckBoxOne.setBounds(10, 350, 120, 25);
        JCheckBox myCheckBoxTwo = new JCheckBox("Option Two");
        myCheckBoxTwo.setBounds(10, 380, 120, 25);
        JCheckBox myCheckBoxThree = new JCheckBox("Option Three");
        myCheckBoxThree.setBounds(10, 410, 120, 25);

        myWindow.add(myCheckBoxOne);
        myWindow.add(myCheckBoxTwo);
        myWindow.add(myCheckBoxThree);


        /* Set the window to visible last! */
        myWindow.setVisible(true);
    };
};
