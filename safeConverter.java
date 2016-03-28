import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class safeConverter {
	private JPanel panel;
	private JButton buttonF;
	private JButton buttonC;
	private JButton buttonK;
	private JTextField text;
	private JLabel labelF;
	private JLabel labelC;
	private JLabel labelK;
	private String nullError = "input in empty";
	private String numError = "input is not number";

	public safeConverter() {
		panel = new JPanel(new GridLayout(7, 1));
		buttonF = new JButton("Convert from F to C and K");
		buttonC = new JButton("Convert from C to F and K");
		buttonK = new JButton("Convert from K to F and C");
		text = new JTextField(3);// 3 cols, not 20 chars

		labelF = new JLabel("Enter a temperature in F or C or K    ");
		labelC = new JLabel("");
		labelK = new JLabel("");

		// Load the listener
		buttonF.addActionListener(buttonListenerF());
		buttonC.addActionListener(buttonListenerC());
		buttonK.addActionListener(buttonListenerK());

		// load the panel
		panel.add(text);
		panel.add(labelF);
		panel.add(buttonF);

		panel.add(labelC);
		panel.add(buttonC);

		panel.add(labelK);
		panel.add(buttonK);
	}

	public Component getContent() {
		return (panel);
	}

	private ActionListener buttonListenerF() {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = text.getText();
				if (input.equals("")) {
					labelF.setText(nullError);
					labelC.setText(nullError);
					labelK.setText(nullError);
				} else {
					try {
						double d = Double.parseDouble(input);
						double tempInF = Double.parseDouble(input);
						double tempInC = (tempInF - 32) * (5.0 / 9.0);
						double tempInK = ((5 / 9) * (tempInF - 32)) - 273.15;
						String newTextF = "Temp in F: " + String.format("%.2f", tempInF);
						String newTextC = "Temp in C: " + String.format("%.2f", tempInC);
						String newTextK = "Temp in K: " + String.format("%.2f", tempInK);
						labelF.setText(newTextF);
						labelC.setText(newTextC);
						labelK.setText(newTextK);
					} catch (NumberFormatException nfe) {
						labelF.setText(numError);
						labelC.setText(numError);
						labelK.setText(numError);
					}
				}

			}
		};
		return listener;
	}

	private ActionListener buttonListenerC() {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String input = text.getText();
				if (input.equals("")) {
					labelF.setText(nullError);
					labelC.setText(nullError);
					labelK.setText(nullError);
				} else {
					try {
						double tempInC = Double.parseDouble(input);
						double tempInF = (tempInC * 9 / 5) + 32;
						double tempInK = tempInC + 273.15;
						String newTextF = "Temp in F: " + String.format("%.2f", tempInF);
						String newTextC = "Temp in C: " + String.format("%.2f", tempInC);
						String newTextK = "Temp in K: " + String.format("%.2f", tempInK);
						labelF.setText(newTextF);
						labelC.setText(newTextC);
						labelK.setText(newTextK);
					} catch (NumberFormatException nfe) {
						labelF.setText(numError);
						labelC.setText(numError);
						labelK.setText(numError);
					}
				}
			}
		};
		return listener;
	}

	private ActionListener buttonListenerK() {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = text.getText();
				if (input.equals("")) {
					labelF.setText(nullError);
					labelC.setText(nullError);
					labelK.setText(nullError);
				} else {
					try {
						double tempInK = Double.parseDouble(input);
						double tempInC = tempInK - 273.15;
						double tempInF = (tempInK - 273.15) * 9 / 5 + 32;
						String newTextF = "Temp in F: " + String.format("%.2f", tempInF);
						String newTextC = "Temp in C: " + String.format("%.2f", tempInC);
						String newTextK = "Temp in K: " + String.format("%.2f", tempInK);
						labelF.setText(newTextF);
						labelC.setText(newTextC);
						labelK.setText(newTextK);
					} catch (NumberFormatException nfe) {
						labelF.setText(numError);
						labelC.setText(numError);
						labelK.setText(numError);
					}
				}
			}
		};
		return listener;
	}
}