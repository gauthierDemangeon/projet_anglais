package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Class.Grille;
import Controlers.Controlers;
import Interface.Observer;
import Model.Model;

public class VueJeu extends ImagePanel implements Observer {

	Controlers controler;
	Grille g;
	Boolean clicked = false;
	String[] buttonIndexes;
	JPanel grille;
	private BufferedImage image;
	private int level;
	public int getlevel() {
		return level;
	}
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
	public VueJeu(Controlers c,int level)
	{
		super("./images/JeuEnPlace.jpg");
		controler = c;
		this.level = level;
		g  = c.GetGrille(level);
		JButton back = new JButton(new ImageIcon ("./images/boutonlogo.png"));
		
		JButton Correction = new JButton(new ImageIcon ("./images/historique.png"));
		
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
					but.setFont(new Font("Ubuntu Light", Font.BOLD, 40));
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
		
		Correction.setName("Correc");
		Correction.setOpaque(false);
		Correction.setBorderPainted(false);
		Correction.setContentAreaFilled(false);
		Correction.addActionListener(new ButtonListener());
		
		back.setName("backV1");
		back.setOpaque(false);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.addActionListener(new ButtonListener());
		
		JPanel pan = new JPanel(new BorderLayout());
		pan.setOpaque(false);
		pan.add(back,BorderLayout.AFTER_LINE_ENDS);
	
		pan.add(Correction,BorderLayout.BEFORE_FIRST_LINE);
		
		add(pan,BorderLayout.SOUTH);
		JPanel pan2 = new JPanel(new GridLayout(g.getHint().length + 2, 1));
		pan2.setOpaque(false);
		JLabel hor = new JLabel("<HTML><U>Horizontal</U></HTML>");
		hor.setFont(new Font(hor.getFont().getName(),Font.BOLD,hor.getFont().getSize() + 5));
		hor.setForeground(Color.GREEN);
		hor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		pan2.add(hor);
		for(int i = 0;i<g.getHint().length;i++)
		{
			if(g.getOrientation()[i])
			{
				JLabel lab = new JLabel(g.getHint()[i]);
				lab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lab.setFont(new Font(lab.getFont().getName(),Font.BOLD,lab.getFont().getSize()));
				lab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				lab.addMouseListener(new mouseListener(g.getOrientation()[i]));
				pan2.add(lab);
			}
		}
		JLabel ver = new JLabel("<HTML><U>Vertical</U></HTML>");
		ver.setFont(new Font(ver.getFont().getName(),Font.BOLD,ver.getFont().getSize() + 5));
		ver.setForeground(Color.GREEN);
		ver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		pan2.add(ver);
		for(int i = 0;i<g.getHint().length;i++)
		{
			if(!g.getOrientation()[i]){

				JLabel lab = new JLabel(g.getHint()[i]);
				lab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lab.setFont(new Font(lab.getFont().getName(),Font.BOLD,lab.getFont().getSize()));
				lab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				lab.addMouseListener(new mouseListener(g.getOrientation()[i]));
				pan2.add(lab);
			}
		}
		//pan2.setBorder(BorderFactory.createLineBorder(Color.white,2));
		JScrollPane span = new JScrollPane(pan2);
		span.getViewport().setOpaque(false);
		span.setOpaque(false);
		span.getVerticalScrollBar().setUnitIncrement(20);
		add(span,BorderLayout.EAST);
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
	
	public void AfficheCorrection(){
		for(Component c : grille.getComponents())
		{
			if(c instanceof JButton && c.isOpaque())
			{
				//((JButton)c).setEnabled(false);
				String texte = c.getName().substring(6,c.getName().length());
				int i,j;
				i=0;j=0;
				// On récupere les coordonnées du boutton dans la grille 
				if(texte.charAt(1)==','){
					i = Integer.parseInt(texte.substring(0,1));
					j = Integer.parseInt(texte.substring(2,texte.length()));
				}
				if(texte.charAt(2)==','){
					i = Integer.parseInt(texte.substring(0,2));
					j = Integer.parseInt(texte.substring(3,texte.length()));
				}
				
				String a = ((JButton)c).getText();
				String b = g.getLettres()[i][j];
				
				if (a.equals(b)){
					((JButton)c).setBackground(Color.decode("#7ce1ae"));
				}
				else{
					((JButton)c).setBackground(Color.decode("#f14242"));
					((JButton)c).setText(g.getLettres()[i][j]);
				}
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
							((JButton)c).setBackground(((JButton)c).getBackground() == Color.WHITE ? Color.decode("#7ce1ae") : Color.WHITE);
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
				case "Correc":
					/*
					 * On affiche la correction avec les couleurs adapté vert/rouge  en fonction des bonnes/mauvaises réponses
					 *
					 */
					AfficheCorrection();
					((JButton)e.getSource()).setVisible(false);
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
			controler.ColorButton(((JLabel)e.getSource()).getText(), orientation,level);
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
