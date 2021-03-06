package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlers.Controlers;
import Interface.Observer;
import Model.Model;


public class VueConnexion extends JPanel implements Observer {
	private JButton co = new JButton(new ImageIcon("./images/boutonconnexion.png"));
	private JButton btnNewUser  = new JButton(new ImageIcon("./images/nouvelUtilisateur.png")); 	
	private JTextField txtNomUtilisateur= new JTextField();
	private JPasswordField txtpassword = new JPasswordField();
	private JLabel lblUserPwd = new JLabel();
	private BufferedImage image;
	private Controlers controler;
	
	public VueConnexion(Controlers c){
	controler = c;	
	setBounds(100, 100, 482, 329);
	this.setBorder(new EmptyBorder(5, 5, 5, 5));
	try {
		image= ImageIO.read(new File("./images/fenetreConnexion.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	this.setLayout(null);

	lblUserPwd.setForeground(Color.red);
	lblUserPwd.setFont(new Font(Font.SERIF,Font.BOLD,15));
	lblUserPwd.setBounds(28, 180, 405, 60);
	this.add(lblUserPwd);
	
	co.setName("co");
	co.setBounds(26, 126, 135, 36);
	co.addActionListener(new ButtonListener());
	this.add(co);
	 
	txtNomUtilisateur.setName("txtuser");
	txtNomUtilisateur.setText("Username");
	txtNomUtilisateur.setBounds(26, 31, 405, 30);
	txtNomUtilisateur.setColumns(10);
	txtNomUtilisateur.addMouseListener(new FieldMouseListener());
	txtNomUtilisateur.addFocusListener(new focusListener());
	txtNomUtilisateur.addKeyListener(new keyListener());
	txtNomUtilisateur.setFocusable(false);
	this.add(txtNomUtilisateur);

	txtpassword.setName("txtpassword");
	txtpassword.setEchoChar((char)0);
	txtpassword.setText("Password");
	txtpassword.setBounds(26, 71, 405, 30);
	txtpassword.setColumns(10);
	txtpassword.addMouseListener(new FieldMouseListener());
	txtpassword.addFocusListener(new focusListener());
	txtpassword.addKeyListener(new keyListener());
	txtpassword.setFocusable(false);
	this.add(txtpassword);

	btnNewUser.setName("btnNewUser");
	btnNewUser .setBounds(279, 244, 160, 36);
	btnNewUser.requestFocusInWindow();
	btnNewUser.addActionListener(new ButtonListener());
	this.add(btnNewUser );
	
	}
	public void update() {
		controler.GetConnexionWindow().setContentPane(this);
		controler.GetConnexionWindow().update();
	}
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, this);            
	}
	public class keyListener implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				txtNomUtilisateur.setFocusable(true);
				txtpassword.setFocusable(true);
				String name = null;
				if(e.getSource() instanceof JPasswordField)
					name = ((JPasswordField)e.getSource()).getName();
				else
					name = ((JTextField)e.getSource()).getName();
				switch(name)
				{
					case "txtuser":
						txtpassword.grabFocus();
						break;
					case "txtpassword":
						co.doClick();
						break;
					default:
						break;
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public class focusListener implements FocusListener {
		
		@Override
		public void focusGained(FocusEvent e) {
			String name = null;
			if(e.getSource() instanceof JPasswordField)
				name = ((JPasswordField)e.getSource()).getName();
			else
				name = ((JTextField)e.getSource()).getName();
			switch(name)
			{
				case "txtuser":
					if(((JTextField)e.getSource()).getText().equals("Username"))
						((JTextField)e.getSource()).setText(null);
					break;
				case "txtpassword":
					String text = new String(((JPasswordField)e.getSource()).getPassword());
					if(text.equals("Password"))
					{
						((JPasswordField)e.getSource()).setText(null);
						((JPasswordField)e.getSource()).setEchoChar('�');
					}
					break;
				default:
					break;
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			String name = null;
			if(e.getSource() instanceof JPasswordField)
				name = ((JPasswordField)e.getSource()).getName();
			else
				name = ((JTextField)e.getSource()).getName();
			switch(name)
			{
				case "txtuser":
					if(((JTextField)e.getSource()).getText().length() == 0)
						((JTextField)e.getSource()).setText("Username");
					break;
				case "txtpassword":
					if(((JPasswordField)e.getSource()).getPassword().length == 0)
					{
						((JPasswordField)e.getSource()).setText("Password");
						((JPasswordField)e.getSource()).setEchoChar((char)0);
					}
					break;
				default:
					break;
			}
		}

	}
	public class FieldMouseListener implements MouseListener
	{
		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent e) 
		{
			String name = null;
			txtNomUtilisateur.setFocusable(true);
			txtpassword.setFocusable(true);
			if(e.getSource() instanceof JPasswordField)
				name = ((JPasswordField)e.getSource()).getName();
			else
				name = ((JTextField)e.getSource()).getName();
			switch(name)
			{
				case "txtuser":
					txtNomUtilisateur.grabFocus();
					if(((JTextField)e.getSource()).getText().equals("Username"))
						((JTextField)e.getSource()).setText(null);
					break;
				case "txtpassword":
					txtpassword.grabFocus();
					String text = new String(((JPasswordField)e.getSource()).getPassword());
					if(text.equals("Password"))
					{
						((JPasswordField)e.getSource()).setText(null);
						((JPasswordField)e.getSource()).setEchoChar('�');
					}
					break;
				default:
					break;
			}
		}
	  }
	public class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(((JButton)e.getSource()).getName())
			{
				case "co":
					if(controler.UserExistant(txtNomUtilisateur.getText(), new String(txtpassword.getPassword())))
						controler.Connexion();
					else
						lblUserPwd.setText("<html>Your username is unknown or password is false.<br>If you don't have an account yet, please click on the Register button</html>");
					break;
				case "btnNewUser":
					controler.SetNewUserView();
					break;
				default:
					break;
			}
		}
	  }
}

