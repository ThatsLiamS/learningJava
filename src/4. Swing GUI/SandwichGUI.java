/* Import Required Modules & Packages */
import javax.swing.*;
import java.awt.*;

public class SandwichGUI {

    /* Declare Global Variables */
    JFrame myWindow = new JFrame("My Sandwich Shop!");
 
    JTabbedPane myTabs = new JTabbedPane();

    JPanel myPanelOne = new JPanel(null);
    JPanel myPanelTwo = new JPanel(null);

    /* Values for Panel Two */
    String breadSelected = "";
    String fillingSelected = "";
    String sauceSelected = "";
    String saladSelected = "";

    JLabel selectedOptions = new JLabel();

    JTextField loyaltyCard = new JTextField();
    JTextField creditCard = new JTextField();
    JTextField cvvNumber = new JTextField();

    /* Main Method => Run the buildGUI Function */
    public static void main(String[] args) {
        SandwichGUI myClass = new SandwichGUI();
        myClass.buildGUI();
    };

    /* Generate Window Components */
    public void buildGUI() { 

        /* Customize the Window */
        myWindow.setSize(500, 400);
        myWindow.setLocationRelativeTo(null); // Sets the Window central on the Screen
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setResizable(false);
        myWindow.setLayout(new GridLayout(1, 1));

        myPanelOne = createPanelOne();
        myPanelTwo = createPanelTwo();

        /* Add the Panels to a Tab */
        JTabbedPane myTabs = new JTabbedPane();
        myTabs.addTab("Create the Sandwich", myPanelOne);
        myTabs.addTab("Order Details", myPanelTwo);
        myWindow.add(myTabs);

        /* Set the Visibility to True */
        myWindow.setVisible(true);
    };



    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~Create Panels~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    **/

    public JPanel createPanelOne() {
        JPanel myPanel = new JPanel(null);

        /* Add the Tab Title */
        JLabel titleLabel = createLabel("Customise your Sandwich!", Color.black, 0, 0);
        titleLabel.setBounds(130, 20, 220, 35);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Aerial", Font.PLAIN, 18));
        myPanel.add(titleLabel);


        /* Add the Bread Options (ComboBox) */
        breadSelected = "Flatbread";
        JLabel breadLabel = createLabel("Select your Bread!", Color.blue, 25, 75);
        myPanel.add(breadLabel);

        String[] breadOptions = new String[] {"Flatbread", "Italian", "Jalapeno Cheese", "Wheat"};
        JComboBox<String> breadBox = createComboBox("bread", breadOptions, 25, 110);
        myPanel.add(breadBox);


        /* Add the Filling Options (ButtonGroup > RadioButton) */
        fillingSelected = "Ham";
        JLabel fillingLabel = createLabel("Select your Filling!", Color.blue, 25, 165);
        myPanel.add(fillingLabel);

        JRadioButton fillingOne = createRadioButton("Ham", 25, 195, true);
        JRadioButton fillingTwo = createRadioButton("Deli Meats", 25, 220, false);
        JRadioButton fillingThree = createRadioButton("Meatballs", 25, 245, false);
        JRadioButton fillingFour = createRadioButton("Chicken", 25, 270, false);

        ButtonGroup myButtonGroup = new ButtonGroup(); // Ensures only one option is selected
        myButtonGroup.add(fillingOne);
        myButtonGroup.add(fillingTwo);
        myButtonGroup.add(fillingThree);
        myButtonGroup.add(fillingFour);

        myPanel.add(fillingOne);
        myPanel.add(fillingTwo);
        myPanel.add(fillingThree);
        myPanel.add(fillingFour);


        /* Add the Salad Options (CheckBox) */
        saladSelected = "";
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
        sauceSelected = "None";
        JLabel sauceLabel = createLabel("Select your Sauce!", Color.blue, 250, 75);
        myPanel.add(sauceLabel);

        String[] sauceOptions = new String[] {"None", "Mayonnaise", "Mustard", "Ketchup", "Barbecue"};
        JComboBox<String> sauceBox = createComboBox("sauce", sauceOptions, 250, 110);
        myPanel.add(sauceBox);


        /* Export the Panel */
        return myPanel;
    };


    public JPanel createPanelTwo() {
        JPanel myPanel = new JPanel(null);

        /* Add the Tab Title */
        JLabel titleLabel = createLabel("Order Details!", Color.black, 0, 0);
        titleLabel.setBounds(182, 20, 400, 35);
        titleLabel.setFont(new Font("Aerial", Font.PLAIN, 18));
        myPanel.add(titleLabel);


        /* Add the Sandwich Selections */
        selectedOptions = new JLabel("", JLabel.CENTER);
        selectedOptions.setSize(350, 100);
        selectedOptions.setLocation(65, 60);
        selectedOptions.setFont(new Font("Aerial", Font.PLAIN, 15));
        selectedOptions.setForeground(Color.blue);

        myPanel.add(selectedOptions);
        formatSelectedOptions(); // Set the Default Values


        /* Add the Loyalty Card Entry */
        JLabel loyaltyLabel = createLabel("Loyalty Card:", Color.blue, 25, 160);
        myPanel.add(loyaltyLabel);

        loyaltyCard = createTextField("", 25, 190);
        myPanel.add(loyaltyCard);


        /* Add the Credit Card Entry */
        JLabel creditLabel = createLabel("Credit Card:", Color.blue, 190, 160);
        myPanel.add(creditLabel);

        creditCard = createTextField("", 190, 190);
        myPanel.add(creditCard);


        /* Add the Loyalty Card Entry */
        JLabel cvvLabel = createLabel("CVV Number:", Color.blue, 350, 160);
        myPanel.add(cvvLabel);

        cvvNumber = createTextField("", 350, 190);
        myPanel.add(cvvNumber);


        /* Add the Submit Button */
        JButton submitButton = createButton("Submit Order", 175, 250);
        submitButton.addActionListener( AL -> submitButtonClicked() );
        myPanel.add(submitButton);


        /* Export the Panel */
        return myPanel;
    };



    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~Create Components~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    **/

    public JLabel createLabel(String text, Color color, int xPos, int yPos) {
        JLabel myLabel = new JLabel(text);
        myLabel.setForeground(color);
        myLabel.setBounds(xPos, yPos, 115, 40);

        return myLabel;
    };

    public JComboBox<String> createComboBox(String type, String[] options, int xPos, int yPos) {
        JComboBox<String> myComboBox = new JComboBox<String> (options);
        myComboBox.setBounds(xPos, yPos, 120, 30);

        myComboBox.addActionListener( AL -> comboBoxClicked(type, myComboBox) );
        return myComboBox;
    }

    public JRadioButton createRadioButton(String text, int xPos, int yPos, boolean selected) {
        JRadioButton myRadioButton = new JRadioButton(text);
        myRadioButton.setBounds(xPos, yPos, 100, 25);
        myRadioButton.setSelected(selected);
        myRadioButton.addActionListener( AL -> radioButtonClicked(text) );

        return myRadioButton;
    };

    public JCheckBox createCheckBox(String text, int xPos, int yPos) {
        JCheckBox myCheckBox = new JCheckBox(text);
        myCheckBox.setBounds(xPos, yPos, 100, 25);
        myCheckBox.addActionListener( AL -> checkBoxClicked(text) );

        return myCheckBox;
    };

    public JButton createButton(String text, int xPos, int yPos) {
        JButton myButton = new JButton(text);
        myButton.setBounds(xPos, yPos, 125, 50);

        return myButton;
    };

    public JTextField createTextField(String text, int xPos, int yPos) {
        JTextField myTextField = new JTextField(text);
        myTextField.setEditable(true);
        myTextField.setBounds(xPos, yPos, 100, 30);

        return myTextField;
    };



    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~Action Events~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    **/

    public void formatSelectedOptions() {

        String fillingFormatted = "<B>%s</B>".formatted(fillingSelected); // "*filling*"
        String sauceFormatted = ((sauceSelected.equals("None")) ? "with <B>no sauce</B>" : "and " + ("<B>" + sauceSelected + "</B> sauce")); // "with no sauce" or "*sauce*"
        String breadFormatted = breadSelected + ((breadSelected.equals("Flatbread")) ? "" : " Bread"); // Adds "Bread" on the end

        /* Creates an "Grammatical List" of Salad Options */ 
        String[] saladArray = saladSelected.split("[|]");
        String saladFormatted = "";
        if (saladArray.length >= 2) {
            for (int index = 0; index < saladArray.length; index++) {
                if (index == (saladArray.length - 1)) { saladFormatted += "and " + saladArray[index]; } // Join last element with "and *salad*"
                else { saladFormatted += saladArray[index] + ", "; }; // Add each element (<= -2 index) with "*salad*, "
            };
        }
        else { /* Either *One or No Items* of salad Selected */
            saladFormatted = (saladArray[0].isEmpty() == true) ? "no salad" : saladArray[0];
        };

        /* Compile formatted options into a Single String */
        String formattedString = "You have selected: %s %s on %s with %s.".formatted(
            fillingFormatted,
            sauceFormatted,
            "<B>" + breadFormatted + "</B>",
            "<B>" + saladFormatted + "</B>"
        );

        /* HTML Tabs allows for automatic text wrapping */
        selectedOptions.setText("<html>" + formattedString + "</html>");
    };

    public void comboBoxClicked(String type, JComboBox<String> myComboBox) {
        if (type.equalsIgnoreCase("bread")) {
            breadSelected = String.valueOf(myComboBox.getSelectedItem());
        } else {
            sauceSelected = String.valueOf(myComboBox.getSelectedItem());
        };
        formatSelectedOptions();
    };

    public void radioButtonClicked(String optionSelected) {
        fillingSelected = optionSelected;
        formatSelectedOptions();
    };

    public void checkBoxClicked(String option) {

        /* Locate Position of "option" Within "saladSelected" */
        int indexPoint = -1;
        String[] saladArray = saladSelected.split("[|]");
        for (int index = 0; index < saladArray.length; index++) {
            if (saladArray[index].equals(option)) { indexPoint = index; };
        };

        if (indexPoint == -1) {
            /* If Index is NotFound => SELECTED */
            saladSelected = saladSelected + (saladSelected.length() == 0 ? "" : "|") + option;
        } else {
            /* If the Element Does Exist => UNSELECTED */
            saladSelected = "";
            for (int index = 0; index < saladArray.length; index++) {
                if (saladArray[index].equals(option) == false) { // Skips the unselected option
                    saladSelected = saladSelected + (saladSelected.length() == 0 ? "" : "|") + saladArray[index];
                };
            };
        };

        /* Format the New Selected Options */
        formatSelectedOptions();
    };

    public void submitButtonClicked() {

        /* Presence Check on the JTextFields */
        String[] myTextFields = new String[] { loyaltyCard.getText().trim(), creditCard.getText().trim(), cvvNumber.getText().trim() };
        String [] regexValidation = new String[] {"[A-Z]{1}\\d{6}", "\\d{4}( ?\\d{4})*", "\\d{3}" };
        String[] contextHelp = new String [] {"The LoyaltyCard should look like: A123456", "The CreditCard should look like: 1234 1234 1234 1234", "The CVV should look like: 123" };

        /* Loop through each TextField, compare the Regular Expression, and display the Warning Message */
        for (int index = 0; index < myTextFields.length; index++) {
            if (myTextFields[index].matches(regexValidation[index]) == false) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(myWindow, "Woah. Enter all the details before submitting.\n" + contextHelp[index]);
                return;
            };
        };

        /* Show The User That the Order was Successful */
        JOptionPane.showMessageDialog(myWindow, "Order has been successful.", "Success!", JOptionPane.INFORMATION_MESSAGE);

        /* Reset the Window */
        myWindow.getContentPane().removeAll();
        myWindow.repaint();
        buildGUI();
    };
};
