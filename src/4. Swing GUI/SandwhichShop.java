import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class conforms to the regulations set forth within the
 * "Java Swing GUI" EBook.
 * 
 * @author Liam Skinner
 * 
 * Credit: Winstanley College
 *         for the creation of this task.
**/
public class SandwhichShop
{
	JFrame myWindow = new JFrame("Sandwich Shop");
	JTabbedPane myTabs = new JTabbedPane();
	
	String breadSelected;
	String fillingSelected;
	String saladSelected;
	String sauceSelected;

	/**
	 * 
	 */
	public void startGUI()
	{
		myWindow.setSize(500, 400);
		myWindow.setLocationRelativeTo(null);
		myWindow.setResizable(false);

		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setLayout(new GridLayout(1,1));
		
		createMenuPanel();
		createPaymentPanel();
		
		myWindow.add(myTabs);
		myWindow.setVisible(true);
	}
	
	
	/**
	 * This method generates the MenuPanel, with four key aspects.
	 * The Bread. The Filling. The Salad. The Sauce. 
	 */
	public void createMenuPanel()
	{
		JPanel myPanel = new JPanel(null);

		JLabel titleLabel = new JLabel("Customise your Sandwich!");
		titleLabel.setBounds(140, 10, 220, 35);
		titleLabel.setFont(new Font("Aerial", Font.PLAIN, 18));
		titleLabel.setForeground(Color.black);
		myPanel.add(titleLabel);
		
		createBread(myPanel);
		createFilling(myPanel);
		createSalad(myPanel);
		createSauce(myPanel);
		
		myTabs.add("Menu", myPanel);
	}
	
	
	/**
	 * This method is responsbile to create the Bread Selection area with PanelOne.
	 * Users can only select a single type from the ComboBox.
	 * 
	 * @param   myPanel    The JPanel in which to add the components.
	 */
	public void createBread(JPanel myPanel)
	{ 
		breadSelected = "Flatbread";
		JLabel breadLabel = new JLabel("Select your Bread!");
		breadLabel.setBounds(25, 75, 115, 40);
		breadLabel.setForeground(Color.blue);
		myPanel.add(breadLabel);

		String[] breadOptions = new String[] {"Flatbread", "Italian", "Jalapeno Cheese", "Wheat"};
		JComboBox<String> breadBox = new JComboBox<String> (breadOptions);
		breadBox.setBounds(25, 110, 120, 30);
		breadBox.addActionListener(AL -> comboBoxPressed("bread", breadBox));
		myPanel.add(breadBox);
	}

	/**
	 * This method is responsbile to create the Filling Selection area with PanelOne.
	 * Users can only select a single type from the Radio Buttons.
	 * 
	 * @param   myPanel    The JPanel in which to add the components.
	 */
	public void createFilling(JPanel myPanel)
	{ 
		fillingSelected = "Ham";
		JLabel fillingLabel = new JLabel("Select your Filling!");
		fillingLabel.setBounds(25, 165, 115, 40);
		fillingLabel.setForeground(Color.blue);
		myPanel.add(fillingLabel);
		
		ButtonGroup myButtonGroup = new ButtonGroup();

		JRadioButton fillingOne = new JRadioButton("Ham");
		fillingOne.setBounds(25, 195, 100, 25);
		fillingOne.setSelected(true);
		fillingOne.addActionListener(AL -> radioButtonPressed("Ham"));
		
		myButtonGroup.add(fillingOne);
		myPanel.add(fillingOne);
	
		JRadioButton fillingTwo = new JRadioButton("Deli Meats");
		fillingTwo.setBounds(25, 220, 100, 25);
		fillingTwo.setSelected(false);
		fillingTwo.addActionListener(AL -> radioButtonPressed("Deli Meats"));
		
		myButtonGroup.add(fillingTwo);
		myPanel.add(fillingTwo);

		JRadioButton fillingThree = new JRadioButton("Meatballs");
		fillingThree.setBounds(25, 245, 100, 25);
		fillingThree.setSelected(false);
		fillingThree.addActionListener(AL -> radioButtonPressed("Meatballs"));
		
		myButtonGroup.add(fillingThree);
		myPanel.add(fillingThree);

		JRadioButton fillingFour = new JRadioButton("Chicken");
		fillingFour.setBounds(25, 270, 100, 25);
		fillingFour.setSelected(false);
		fillingFour.addActionListener(AL -> radioButtonPressed("Chicken"));
		
		myButtonGroup.add(fillingFour);
		myPanel.add(fillingFour);
	}

	/**
	 * This method is responsbile to create the Salad Selection area with PanelOne.
	 * Users can only select up to four options from the Check boxes.
	 * 
	 * @param   myPanel    The JPanel in which to add the components.
	 */
	public void createSalad(JPanel myPanel)
	{ 
		saladSelected = "";
		JLabel saladLabel = new JLabel("Select your Salad!");
		saladLabel.setForeground(Color.blue);
		saladLabel.setBounds(250, 165, 115, 40);
		myPanel.add(saladLabel);

		JCheckBox saladOne = new JCheckBox("Lettuce");
		saladOne.setBounds(250, 195, 100, 25);
		saladOne.addActionListener(AL -> checkBoxPressed("Lettuce"));
		myPanel.add(saladOne);
		
		JCheckBox saladTwo = new JCheckBox("Tomatoes");
		saladTwo.setBounds(250, 220, 100, 25);
		saladTwo.addActionListener(AL -> checkBoxPressed("Tomatoes"));
		myPanel.add(saladTwo);
		
		JCheckBox saladThree = new JCheckBox("Onions");
		saladThree.setBounds(250, 245, 100, 25);
		saladThree.addActionListener(AL -> checkBoxPressed("Onions"));
		myPanel.add(saladThree);
		
		JCheckBox saladFour = new JCheckBox("Jalapenos");
		saladFour.setBounds(250, 270, 100, 25);
		saladFour.addActionListener(AL -> checkBoxPressed("Jalapenos"));
		myPanel.add(saladFour);
	}

	/**
	 * This method is responsbile to create the Sauce Selection area with PanelOne.
	 * Users can only select a single type from the ComboBox.
	 * 
	 * @param   myPanel    The JPanel in which to add the components.
	 */
	public void createSauce(JPanel myPanel)
	{
		sauceSelected = "None";
		JLabel sauceLabel = new JLabel("Select your Sauce!");
		sauceLabel.setBounds(250, 75, 115, 40);
		sauceLabel.setForeground(Color.blue);
		myPanel.add(sauceLabel);

		String[] sauceOptions = new String[] {"None", "Mayonnaise", "Mustard", "Ketchup", "Barbecue"};
		JComboBox<String> sauceBox = new JComboBox<String> (sauceOptions);
		sauceBox.setBounds(250, 110, 120, 30);
		sauceBox.addActionListener(AL -> comboBoxPressed("sauce", sauceBox));
		myPanel.add(sauceBox);
	}



	/**
	 * Event Listener
	 * Executed when a ComboBox is pressed
	 * 
	 * This can either be a Sauce or Bread option.
	 */
	public void comboBoxPressed(String type, JComboBox<String> myComboBox)
	{
		if (type.equalsIgnoreCase("bread"))
		{
			breadSelected = String.valueOf(myComboBox.getSelectedItem());
		}
		else
		{
			sauceSelected = String.valueOf(myComboBox.getSelectedItem());
		}
		//# FUNCTION: Format Selected Options
	}
	/**
	 * Event Listener
	 * Executed when a CheckBox is pressed
	 * 
	 * This will be a Salad option.
	 */
	public void checkBoxPressed(String option)
	{
		// Locate Position of "option" within "saladSelected"
		int indexPoint = -1;
		String[] saladArray = saladSelected.split("[|]");
		for (int index = 0; index < saladArray.length; index++)
		{
			if (saladArray[index].equals(option))
			{
				indexPoint = index;
			}
		}

		if (indexPoint == -1)
		{
			// If Index is NotFound => SELECTED
			saladSelected = saladSelected + (saladSelected.length() == 0 ? "" : "|") + option;
		}
		else
		{
			// If the Element Does Exist => UNSELECTED
			saladSelected = "";
			for (int index = 0; index < saladArray.length; index++)
			{
				if (saladArray[index].equals(option) == false)
				{   // Skips the unselected option
					saladSelected = saladSelected + (saladSelected.length() == 0 ? "" : "|") + saladArray[index];
				}
			}
		}
		//# FUNCTION: Format Selected Options
	}
	/**
	 * Event Listener
	 * Executed when a Radio Button is pressed
	 * 
	 * This will be a Filling option.
	 */
	public void radioButtonPressed(String selectedOption)
	{
		fillingSelected = selectedOption;
		//# FUNCTION: Format Selected Options
	}
	

	/**
	 * 
	 */
	public void createPaymentPanel()
	{
		JPanel myPanel = new JPanel(null);
		myTabs.add("Payment", myPanel);
	}
	

	/**
	 * This method acts as the gateway into the SandwhichShop Class
	 */
	public static void main(String[] args)
	{
		SandwhichShop myClass = new SandwhichShop();
		myClass.startGUI();
	}
}
