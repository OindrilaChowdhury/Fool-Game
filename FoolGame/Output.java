import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Output extends JFrame implements ActionListener {
	private JLabel title;
	private JButton buttonAgain, buttonExit;
	private Color backgroundColor;
	private JPanel panel;
	public Output(boolean fool) {
		super("Fool Game");
		
		this.setSize(550,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		Font fontTitle = new Font("Black", Font.BOLD, 30);
		
		String output;
		if (fool)
			output = "Yes,You are a Fool!";
		else
			output = "No,You are NOT a Fool!";
		
		title = new JLabel(output);
		title.setBounds(150,80,400,30);
		title.setBackground(Color.RED);
		title.setFont(fontTitle);
		panel.add(title);
		
		buttonAgain = new JButton("Again");
		buttonAgain.setBounds(200,150,80,40);
		buttonAgain.addActionListener(this);
		panel.add(buttonAgain);
		
		buttonExit = new JButton("Exit");
		buttonExit.setBounds(300,150,80,40);
		buttonExit.addActionListener(this);
		panel.add(buttonExit);
		
		this.add(panel);
	}
	
	public void  actionPerformed(ActionEvent ae) {
		String output = ae.getActionCommand();
		if (output.equals(buttonAgain.getText())) {	
			new Game().setVisible(true);
			this.setVisible(false);
		}
		else if (output.equals(buttonExit.getText())) {								
			System.exit(0);
		}
	}
}