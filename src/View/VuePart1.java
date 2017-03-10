package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Class.Grille;
import Controlers.Controlers;
import Interface.Observer;
import Model.Model;

public class VuePart1 extends ImagePanel implements Observer {

	Controlers controler;
	Grille g;
	Boolean clicked = false;
	String[] buttonIndexes;
	JPanel grille;
	public Grille getGrille() {
		return g;
	}
	public String[] getButtonIndexes() {
		return buttonIndexes;
	}
	public void setButtonIndexes(String[] buttonIndexes) {
		this.buttonIndexes = buttonIndexes;
	}
	public Boolean getClicked() {
		return clicked;
	}
	public void setClicked(Boolean clicked) {
		this.clicked = clicked;
	}
	public VuePart1(Controlers c)
	{
		super();
		controler = c;
		g  = c.GetGrille();
		JButton back = new JButton(new ImageIcon ("./images/boutonlogo.png"));
		grille=new JPanel(new GridLayout(g.getHeight(),g.getWidth()));
		for(int i = 0;i<g.getHeight();i++)
		{
			for(int j=0;j<g.getWidth();j++)
			{
				JButton but = new JButton();
				but.setEnabled(false);
				but.setName("button" + String.valueOf(i) + ',' + String.valueOf(j));
				if(g.IsLetter(i, j))
				{
					but.setBackground(Color.WHITE);
					but.setFont(new Font("Arial", Font.BOLD, 40));
					but.addKeyListener(new KeybuttonListener());
				}
				else
				{
					but.setOpaque(false);
					but.setBorderPainted(false);
					but.setContentAreaFilled(false);
				}
				grille.add(but); 
			}
		}
		grille.setOpaque(false);
		back.setName("backV1");
		back.setOpaque(false);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.addActionListener(new ButtonListener());
		JPanel pan = new JPanel(new BorderLayout());
		pan.setOpaque(false);
		pan.add(back,BorderLayout.AFTER_LINE_ENDS);
		add(pan,BorderLayout.SOUTH);
		JPanel pan2 = new JPanel(new GridLayout(g.getMots().length + 2, 1));
		pan2.setOpaque(true);
		pan2.add(new JLabel("Horizontal"));
		for(int i = 0;i<g.getMots().length;i++)
		{
			if(g.getOrientation()[i])
			{
				JLabel lab = new JLabel(g.getMots()[i]);
				lab.addMouseListener(new mouseListener(g.getOrientation()[i]));
				pan2.add(lab);
			}
		}
		pan2.add(new JLabel("Vertical"));
		for(int i = 0;i<g.getMots().length;i++)
		{
			if(!g.getOrientation()[i]){

				JLabel lab = new JLabel(g.getMots()[i]);
				lab.addMouseListener(new mouseListener(g.getOrientation()[i]));
				pan2.add(lab);
			}
		}
		add(pan2,BorderLayout.EAST);
		add(grille,BorderLayout.CENTER);
	}
	public void NextButtonFocus(String name)
	{
		for(int i=0;i<buttonIndexes.length;i++)
		{
			if(i != buttonIndexes.length - 1 && buttonIndexes[i].equals(name.replaceFirst("button", "")))
				for(int j=0;j<grille.getComponents().length;j++)
				{
					if(grille.getComponents()[j].getName().equals("button" + buttonIndexes[i+1]))
						((JButton)grille.getComponents()[j]).grabFocus();
				}
		}
	}
	public void update() {
		if(getClicked())
		{
			for(Component c : grille.getComponents())
			{
				if(c instanceof JButton && c.isOpaque())
				{
					((JButton)c).setEnabled(false);
					((JButton)c).setBackground(Color.WHITE);
					for(String index : buttonIndexes)
					{
						if(((JButton)c).getName().equals("button" + index))
						{
							((JButton)c).setEnabled(true);
							((JButton)c).setBackground(((JButton)c).getBackground() == Color.WHITE ? Color.BLUE : Color.WHITE);
							if(index.equals(buttonIndexes[0]))
								((JButton)c).grabFocus();
							break;
						}
					}
				}
			}
		}
		clicked = false;
		controler.GetMainWindow().setContentPane(this);
		controler.GetMainWindow().update();
	}
	
	public class KeybuttonListener implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if(!arg0.isActionKey())
			{
				((JButton)arg0.getSource()).setText(String.valueOf(arg0.getKeyChar()));
				NextButtonFocus(((JButton)arg0.getSource()).getName());
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(((JButton)e.getSource()).getName())
			{
				case "backV1":
					controler.BackAccueil();
					break;
				default:
					break;
			}
		}
	}

	public class mouseListener implements MouseListener
	{
		boolean orientation;
		public mouseListener(boolean orientation)
		{
			this.orientation = orientation;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			controler.ColorButton(((JLabel)e.getSource()).getText(), orientation);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
