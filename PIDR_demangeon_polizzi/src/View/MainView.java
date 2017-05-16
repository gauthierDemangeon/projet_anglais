package View;

import Controlers.*;
import Interface.Observer;
import Main.SpringUtilities;
import Model.Model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class MainView extends ImagePanel implements Observer{

	/**
	 * Create the frame.
	 */
	JLabel titleSign = new JLabel("Clinical Signs",JLabel.CENTER);
	
	JPanel north = new JPanel();
	JPanel center = new JPanel(new GridLayout(1,3));
	
	JScrollPane JSsign;
	
	JPanel GJPsign = new JPanel(new GridLayout(5,1));
	JPanel BJPsign = new JPanel(new BorderLayout());
	
	JButton search  = new JButton();
	Controlers controler;
	
	ArrayList<JTextField> signs = new ArrayList<JTextField>();
	
	int cpt = 0;
	
	public MainView(Controlers c) {
		super("./images/Présentation.jpg");
		controler = c;
		
		search.setText("Search");
		search.setPreferredSize(new Dimension(200,50));
		search.addActionListener(new ButtonListener());
		
		titleSign.setFont(new Font(titleSign.getFont().getName(),titleSign.getFont().getStyle(),30));
		titleSign.setBorder(BorderFactory.createLineBorder(Color.BLACK));		

		GJPsign.add(new CustomPanel(0));
		BJPsign.add(titleSign,BorderLayout.NORTH);
		BJPsign.add(GJPsign,BorderLayout.CENTER);
		
		JSsign = new JScrollPane(BJPsign);
		JSsign.getVerticalScrollBar().setUnitIncrement(15);
		center.add(JSsign);
		
		north.add(search);
		
		add(center,BorderLayout.CENTER);
		add(north,BorderLayout.NORTH);
	}
	class CustomPanel extends JPanel
	{
		int contenttype;
		JTextField tf = new JTextField();
		JButton add = new JButton(new ImageIcon ("./Images/Add-64.png"));
		public CustomPanel(int contenttype)
		{
			JPanel Panel= new JPanel(new BorderLayout());
			this.contenttype = contenttype;
			signs.add(tf);
			tf.setPreferredSize(new Dimension(500, 45));
			
			add.setOpaque(false);
			add.setBorder(null);
			add.setBorderPainted(false);
			add.setContentAreaFilled(false);
			add.addActionListener(new AddListener());
			add.setPreferredSize(new Dimension(53, 45));
			
			Panel.add(add,BorderLayout.EAST);
			Panel.setPreferredSize(new Dimension(53,45));;
			
			add(tf);
			add(Panel);
		   
		}
	}
	 
	public void update() 
	{
		controler.GetMainWindow().setContentPane(this);
		controler.GetMainWindow().update();
	}
	class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
		}
	}
	class AddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
		}
	}
}
