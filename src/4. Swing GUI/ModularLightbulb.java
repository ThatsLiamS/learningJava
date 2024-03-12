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
public class ModularLightbulb
{
	boolean lightStatus = false;
	
	JFrame myWindow = new JFrame("My Modular Lightbulb!");
	JPanel myPanel = new JPanel(null);
	JLabel myBulb = new JLabel();
	JButton mySwitch = new JButton();
	
	/**
	 * This method sets the default window values & operations, and
	 * summons the creation of two elements and adds them to the panel.
	 */
	public void startGUI()
	{
		myWindow.setSize(375, 400);
		myWindow.setLocationRelativeTo(null);

		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setLayout(new GridLayout(1,1));
		
		createBulb();
		createSwitch();
		
		myWindow.add(myPanel);
		myWindow.setVisible(true);
	}

	/**
	 * This method will generate a JLabel with an
	 * image icon to act as the bulb.
	 */
	public void createBulb()
	{
		myBulb.setSize(150,150);
		myBulb.setLocation(100, 50);
		
		setBulb(lightStatus);
		myPanel.add(myBulb);
	}
	/**
	 * This method will set, and alternate the state of the image.
	 * Changing the bulb being on, and off.
	 */
	public void setBulb(boolean status) {
		try
		{
			ImageIcon myImage = new ImageIcon(status ? "Yellow.jpg" : "Black.jpg");
			myBulb.setIcon(myImage);
		}
		catch (Exception err)
		{
			System.err.println("Error loading image: " + err.getMessage());
			err.printStackTrace();
		}
	}


	/**
	 * This method will generate a Jbutton with an
	 * standard text to allow the user to change the
	 * status of the lightbulb.
	 */
	public void createSwitch()
	{
		mySwitch.setText("Turn Light " + (lightStatus ? "Off" : "On"));
		mySwitch.setSize(150, 40);
		mySwitch.setLocation(100, 250);

		myPanel.add(mySwitch);
		mySwitch.addActionListener(AL -> btnClicked());
	}
	/**
	 * When the switch is executed, this method will
	 * alternate the value of lightStatus, and call the
	 * function to flip the image.
	 */
	public void btnClicked()
	{
		lightStatus = !lightStatus;
		
		mySwitch.setText("Turn Light " + (lightStatus ? "Off" : "On"));
		setBulb(lightStatus);
	}


	/**
	 * This method acts as the gateway into the ModularLightBulb Class
	 */
	public static void main(String[] args)
	{
		ModularLightbulb myClass = new ModularLightbulb();
		myClass.startGUI();
	}
}
