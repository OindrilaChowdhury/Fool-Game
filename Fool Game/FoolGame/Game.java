import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game extends JFrame implements ActionListener, MouseListener {
	private JLabel title, background;
	private ImageIcon bgimg;
	private JButton buttonYes, buttonNo;
	private JPanel panel;
	private Color backgroundColor;
	private Font myFont;
	private Random r;
	public Game() {
		super("Fool Game");
		
		this.setSize(450, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		Font fontTitle = new Font("Black", Font.BOLD, 30);
		
		title = new JLabel("Are You a Fool?");
		title.setBounds(250,80,350,40);
		title.setForeground(Color.BLACK);
		title.setFont(fontTitle);
		
		panel.add(title);
		
		buttonYes = new JButton("Yes");
		buttonYes.setBounds(300,150,60,30);
		buttonYes.setBackground(Color.RED);
		buttonYes.addActionListener(this);
		buttonYes.addMouseListener(this);
		panel.add(buttonYes);
		
		buttonNo = new JButton("No");
		buttonNo.setBounds(400,150,60,30);
		buttonNo.setBackground(Color.GREEN);
		buttonNo.addMouseListener(this);
		buttonNo.addActionListener(this);
		panel.add(buttonNo);
		
		this.add(panel);
	}
	public void  actionPerformed(ActionEvent ae) {
		String output = ae.getActionCommand();
		if (output.equals(buttonYes.getText())) {
			new Output(true).setVisible(true);
			this.setVisible(false);
		}
		else if (output.equals(buttonNo.getText())) {
			new Output(false).setVisible(true);
			this.setVisible(false);
		}
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me) {
		if(me.getSource().equals(buttonNo))
		{
			r = new Random();
			buttonNo.setBounds(r.nextInt(500), r.nextInt(400), 60, 30);
			buttonNo.setBackground(Color.BLUE);
			buttonNo.setForeground(Color.WHITE);
		}
		else if(me.getSource().equals(buttonYes))
		{
			buttonYes.setBackground(Color.BLUE);
			buttonYes.setForeground(Color.WHITE);
		}
		else{}
	}
	public void mouseExited(MouseEvent me) {
		if(me.getSource().equals(buttonNo))
		{
			buttonNo.setBackground(Color.WHITE);
			buttonNo.setForeground(Color.BLUE);
		}
		else if(me.getSource().equals(buttonYes))
		{
			buttonYes.setBackground(Color.WHITE);
			buttonYes.setForeground(Color.BLUE);
		}
		else{}
	}
	
}