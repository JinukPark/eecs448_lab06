import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Component;
import java.awt.GridLayout;

public class DiceProgram 
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	Random rand = new Random();
	
	public DiceProgram()
	{
		panel = new JPanel();
		button = new JButton("roll");
		text = new JTextField(3);
		label = new JLabel("Enter a number of sides for the Dice");
		
		//Load the listener
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(text);
		panel.add(button);
		panel.add(label);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				int numSides = Integer.parseInt(input);//convert String to int
				int ranNum = rand.nextInt((numSides - 1) + 1) + 1;
				
				String ranNumText = ranNum +  " came out on top";
											       
				label.setText(ranNumText);
				System.out.println(ranNumText);
			}
		};
		
		return listener;
	}	
}