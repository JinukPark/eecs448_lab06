import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Component;
import java.awt.GridLayout;

public class votingSystem {
	private JPanel panel;
	private JButton button;
	private JTextField firstName;
	private JTextField lastName;
	private JLabel label1;
	private JLabel label2;

	JRadioButton button1 = new JRadioButton("candidate1");
	JRadioButton button2 = new JRadioButton("candidate2");
	JRadioButton button3 = new JRadioButton("candidate3");
	JRadioButton button4 = new JRadioButton("candidate4");
	ButtonGroup group = new ButtonGroup();

	public votingSystem() {
		panel = new JPanel(new GridLayout(0, 1));
		button = new JButton("Submit");
		firstName = new JTextField(3);
		lastName = new JTextField(3);
		label1 = new JLabel("First Name : ");
		label2 = new JLabel("Last Name : ");

		button1.setActionCommand("candidate1");
		button2.setActionCommand("candidate2");
		button3.setActionCommand("candidate3");
		button4.setActionCommand("candidate4");

		group.add(button1);
		group.add(button2);
		group.add(button3);
		group.add(button4);

		// Load the listener
		button.addActionListener(buttonListener());

		// load the panel

		panel.add(label1);
		panel.add(firstName);
		panel.add(label2);
		panel.add(lastName);
		panel.add(button);
		// panel.add(label);

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
	}

	public Component getContent() {
		return (panel);
	}

	private ActionListener buttonListener() {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedWriter writer = null;

				String input1 = firstName.getText();
				String input2 = lastName.getText();
				if (!button1.isSelected() && !button2.isSelected() && !button3.isSelected() && !button4.isSelected()) {
					System.exit(0);
				}

				try {
					File myFile = new File(input1 + "_" + input2 + "_ballot.txt");

					writer = new BufferedWriter(new FileWriter(myFile));
					writer.write(group.getSelection().getActionCommand());
					writer.close();

					if (myFile.createNewFile()) {
					} else {
						System.exit(0);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		return listener;
	}
}