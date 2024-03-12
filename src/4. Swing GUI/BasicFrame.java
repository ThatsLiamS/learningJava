import java.awt.*;
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
public class BasicFrame
{
	
	JFrame myWindow = new JFrame();
	
	public static void main(String[] args)
	{
		BasicFrame myClass = new BasicFrame();
		myClass.startGUI();
	}
	
	/**
	 * This method access as the gateway into the class, and generates
	 * the standard empty frame and then generate some compoments
	 * to insert into the frame.
	 */
	public void startGUI()
	{
		myWindow.setTitle("My Basic Frame");
		myWindow.setSize(800, 800);
		myWindow.setLocation(0,0);
		myWindow.setLayout(null);
		
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		myWindow.setResizable(false);
	
		addButton();
		addJLabel();
		addJTextField();
		
		myWindow.setVisible(true);
	}
	
	/**
	 * This method will generate a button from the
	 * swing library, and adds it to the frame.
	 */
	public void addButton()
	{
		JButton myButton = new JButton("Button!");
		myButton.setSize(100, 100);
		myButton.setLocation(25, 5);
		myWindow.add(myButton);
	}
	
	/**
	 * This method will generate a label from the
	 * swing library, and adds it to the frame.
	 */
	public void addJLabel()
	{
		JLabel myLabel = new JLabel("I am a Label!");
		myLabel.setForeground(Color.red);

		myLabel.setSize(75, 85);
		myLabel.setLocation(325, 10);

		myWindow.add(myLabel);
	}
	
	/**
	 * This method will generate a text field from
	 * the swing library, and adds it to the frame.
	 */
	public void addJTextField()
	{
		JTextField myTextField = new JTextField("Text Field: Enter data...");
		myTextField.setForeground(Color.blue);

		myTextField.setSize(150, 45);
		myTextField.setLocation(25, 200);
		myTextField.setForeground(Color.blue);

		myWindow.add(myTextField);
	}
	
}
