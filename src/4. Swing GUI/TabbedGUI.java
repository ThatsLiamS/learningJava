import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class conforms to the regulations set forth within the
 * "Java Swing GUI" EBook.
 * 
 * @author Liam Skinner
 * 
 * Credit: Winstanley College
 *         for the creation of this task.
**/
public class TabbedGUI
{
	JFrame myWindow = new JFrame("Tabbed Program");
	
	JPanel myFirstPanel = new JPanel(null);
	JPanel mySecondPanel = new JPanel(null);
	JPanel myThirdPanel = new JPanel(null);
	JPanel myFourthPanel = new JPanel(null);
	JPanel myFifthPanel = new JPanel(null);
	
	JLabel lblForPanelOne = new JLabel ("Welcome to Panel One");
	JLabel lblForPanelTwo = new JLabel ("Welcome to Panel Two");
	JLabel lblForPanelThree = new JLabel ("Welcome to Panel Three");
	JLabel lblForPanelFour = new JLabel ("Welcome to Panel Four");
	JLabel lblForPanelFive = new JLabel ("Welcome to Panel Four");
	
	JTabbedPane myTabs = new JTabbedPane();
	
	/**
	 * This method sets the default window values & operations, and
	 * summons the creation of several panels and adds them onto the
	 * tabbed pane on the window.
	 */
	public void buildMyTabbedGUI()
	{
		
		myWindow.setSize(500, 400);
		myWindow.setLocation(200, 200);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Grid Layouton the window
		myWindow.setLayout(new GridLayout(1,1));
		
		createPanelOne();
		myTabs.addTab("Panel One", myFirstPanel); //# Adds Panel to the Tab
		createPanelTwo();
		myTabs.addTab("Panel Two", mySecondPanel); //# Adds Panel to the Tab
	
		createPanelThree();
		myTabs.addTab("Panel Three", myThirdPanel); //# Adds Panel to the Tab
		createPanelFour();
		myTabs.addTab("Panel Four", myFourthPanel); //# Adds Panel to the Tab
		
		createPanelFive();
		myTabs.addTab("Liam's Panel", myFifthPanel); //# Adds Panel to the Tab
		
		myWindow.add(myTabs); //# Adds the Tab to the Window
		myWindow.setVisible(true);
	}
	
	
	/**
	 * This method creates a standard panel,
	 * with a welcome label
	 */
	public void createPanelOne()
	{   
		lblForPanelOne.setSize(200, 40);
		lblForPanelOne.setLocation(5, 0);
		myFirstPanel.add(lblForPanelOne);
		
	}
	
	/**
	 * This method creates a standard panel,
	 * with a welcome label
	 */
	public void createPanelTwo()
	{   
		lblForPanelTwo.setSize(200, 40);
		lblForPanelTwo.setLocation(5, 0);
		mySecondPanel.add(lblForPanelTwo);
		
	}
	
	/**
	 * This method creates a standard panel,
	 * with a welcome label
	 */
	public void createPanelThree()
	{   
		lblForPanelThree.setSize(200, 40);
		lblForPanelThree.setLocation(5, 0);
		myThirdPanel.add(lblForPanelThree);
		
	}
	
	/**
	 * This method creates a standard panel,
	 * with a welcome label
	 */
	public void createPanelFour()
	{   
		lblForPanelFour.setSize(200, 40);
		lblForPanelFour.setLocation(5, 0);
		myFourthPanel.add(lblForPanelFour);
		
	}
	
	
	/**
	 * This method creates a standard panel,
	 * with a welcome label
	 */
	public void createPanelFive()
	{   
		lblForPanelFive.setSize(200, 40);
		lblForPanelFive.setLocation(5, 0);
		myFifthPanel.add(lblForPanelFive);
		
	}
	
	
	/**
	 * This method acts as the gateway into the Task5 Class
	 */
	public static void main(String[] args) 
	{
		TabbedGUI myClass = new TabbedGUI();
		myClass.buildMyTabbedGUI();
	}
}
