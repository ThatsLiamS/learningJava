/* Import Required Modules & Packages */
import javax.swing.*;
import java.awt.*;

public class SandwichGUI {

    /* Declare Global Variables */
    JFrame myWindow = new JFrame("My Sandwich Shop!");

    JTabbedPane myTabs = new JTabbedPane();

    JPanel myPanelOne = new JPanel(null);
    JPanel myPanelTwo = new JPanel(null);
    
    /* Main Method => Run the buildGUI Function */
    public static void main(String[] args) {
        SandwichGUI myClass = new SandwichGUI();
        myClass.buildGUI();
    };

    /* Generate Window Components */
    public void buildGUI() { 

        /* Customize the Window */
        myWindow.setSize(500, 400);
        myWindow.setLocation(500, 200);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setLayout(new GridLayout(1, 1));

        JPanel myPanelOne = createPanelOne();
        JPanel myPanelTwo = createPanelTwo();

        /* Add the Panels to a Tab */
        myTabs.addTab("Create the Sandwich", myPanelOne);
        myTabs.addTab("Order Details", myPanelTwo);
        myWindow.add(myTabs);

        /* Set the Visibility to True */
        myWindow.setVisible(true);
    };


    public JPanel createPanelOne() {
        JPanel myPanel = new JPanel(null);

        /* Add the Tab Title */
        JLabel titleLabel = createLabel("Customise your Sandwich!", Color.blue, 0, 0);
        titleLabel.setBounds(140, 10, 220, 35);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        myPanel.add(titleLabel);

        /* Add the Bread Options (ComboBox) */
        JLabel breadLabel = createLabel("Select your Bread!", Color.blue, 25, 75);
        myPanel.add(breadLabel);

        String[] breadOptions = new String[] {"Flatbread", "Italian", "Jalapeno Cheese", "Wheat"};
        JComboBox<String> breadBox = createComboBox(breadOptions, 25, 110);
        myPanel.add(breadBox);

        /* Add the Filling Options (ButtonGroup > RadioButton) */
        JLabel fillingLabel = createLabel("Select your Filling!", Color.blue, 25, 165);
        myPanel.add(fillingLabel);

        JRadioButton fillingOne = createRadioButton("Ham", 25, 195);
        JRadioButton fillingTwo = createRadioButton("Deli Meats", 25, 220);
        JRadioButton fillingThree = createRadioButton("Meatballs", 25, 245);
        JRadioButton fillingFour = createRadioButton("Chicken", 25, 270);

        ButtonGroup myButtonGroup = new ButtonGroup();
        myButtonGroup.add(fillingOne);
        myButtonGroup.add(fillingTwo);
        myButtonGroup.add(fillingThree);
        myButtonGroup.add(fillingFour);

        myPanel.add(fillingOne);
        myPanel.add(fillingTwo);
        myPanel.add(fillingThree);
        myPanel.add(fillingFour);

        /* Add the Salad Options (CheckBox) */
        JLabel saladLabel = createLabel("Select your Salad!", Color.blue, 250, 165);
        myPanel.add(saladLabel);

        JCheckBox saladOne = createCheckBox("Lettuce", 250, 195);
        JCheckBox saladTwo = createCheckBox("Tomatoes", 250, 220);
        JCheckBox saladThree = createCheckBox("Onions", 250, 245);
        JCheckBox saladFour = createCheckBox("Jalapenos", 250, 270);

        myPanel.add(saladOne);
        myPanel.add(saladTwo);
        myPanel.add(saladThree);
        myPanel.add(saladFour);

        /* Add the Sauce Options (ComboBox) */
        JLabel sauceLabel = createLabel("Select your Sauce!", Color.blue, 250, 75);
        myPanel.add(sauceLabel);

        String[] sauceOptions = new String[] {"None", "Mayonnaise", "Mustard", "Ketchup"};
        JComboBox<String> sauceBox = createComboBox(sauceOptions, 250, 110);
        myPanel.add(sauceBox);


        /* Export the Panel */
        return myPanel;
    };

    public JPanel createPanelTwo() {
        JPanel myPanel = new JPanel(null);

        /* Add the Tab Title */
        JLabel titleLabel = createLabel("Order Details!", Color.blue, 0, 0);
        titleLabel.setBounds(185, 10, 220, 35);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        myPanel.add(titleLabel);

        /* Add the Loyalty Card Entry */
        JLabel loyaltyLabel = createLabel("Loyalty Card:", Color.blue, 25, 160);
        myPanel.add(loyaltyLabel);

        JTextField loyaltyCard = createTextField("", 25, 190);
        myPanel.add(loyaltyCard);


        /* Add the Credit Card Entry */
        JLabel creditLabel = createLabel("Credit Card:", Color.blue, 190, 160);
        myPanel.add(creditLabel);

        JTextField creditCard = createTextField("", 190, 190);
        myPanel.add(creditCard);


        /* Add the Loyalty Card Entry */
        JLabel cvvLabel = createLabel("CVV Number:", Color.blue, 350, 160);
        myPanel.add(cvvLabel);

        JTextField cvvNumber = createTextField("", 350, 190);
        myPanel.add(cvvNumber);


        /* Add the Submit Button */
        JButton submitButton = createButton("Submit Order", 175, 250);
        myPanel.add(submitButton);

        /* Export the Panel */
        return myPanel;
    };


    public JLabel createLabel(String text, Color color, int xPos, int yPos) {
        JLabel myLabel = new JLabel(text);
        myLabel.setForeground(color);
        myLabel.setBounds(xPos, yPos, 115, 40);

        return myLabel;
    };

    public JComboBox<String> createComboBox(String[] options, int xPos, int yPos) {
        JComboBox<String> myComboBox = new JComboBox<String> (options);
        myComboBox.setBounds(xPos, yPos, 120, 30);

        return myComboBox;
    }
    
    public JRadioButton createRadioButton (String text, int xPos, int yPos) {
        JRadioButton myRadioButton = new JRadioButton(text);
        myRadioButton.setBounds(xPos, yPos, 100, 25);

        return myRadioButton;
    };

    public JCheckBox createCheckBox(String text, int xPos, int yPos) {
        JCheckBox myCheckBox = new JCheckBox(text);
        myCheckBox.setBounds(xPos, yPos, 100, 25);

        return myCheckBox;
    };

    public JButton createButton(String text, int xPos, int yPos) {
        JButton myButton = new JButton(text);
        myButton.setBounds(xPos, yPos, 125, 50);

        return myButton;
    };

    public JTextField createTextField(String text, int xPos, int yPos) {
        JTextField myTextField = new JTextField(text);
        myTextField.setBounds(xPos, yPos, 90, 30);

        return myTextField;
    };
};
