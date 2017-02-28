package View;

import java.awt.Color;
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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Interface.Observer;
import View.VueConnexion.ButtonListener;
import View.VueConnexion.FieldMouseListener;
import View.VueConnexion.focusListener;
import View.VueConnexion.keyListener;
import Controlers.Controlers;

public class VueNouvelUtilisateur extends JPanel implements Observer {

	private JTextField txtNomUtilisateur= new JTextField();
	private JPasswordField txtpassword = new JPasswordField();
	private JLabel lblUserPwd = new JLabel();
	private Controlers controler;
	private JButton btnCrer= new JButton(new ImageIcon("./images/creer.png"));
	private JButton back  = new JButton(new ImageIcon("./images/nouvelUtilisateur.png")); 	
	private BufferedImage image;
	public VueNouvelUtilisateur(Controlers c) {
		controler = c;
		
		setBounds(100, 100, 482, 329);
		this.setLayout(null);
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

		txtNomUtilisateur.setName("txtuser");
		txtNomUtilisateur.setText("Username");
		txtNomUtilisateur.setBounds(26, 31, 405, 30);
		txtNomUtilisateur.setColumns(10);
		txtNomUtilisateur.addMouseListener(new FieldMouseListener());
		txtNomUtilisateur.addFocusListener(new focusListener());
		txtNomUtilisateur.addKeyListener(new keyListener());
		this.add(txtNomUtilisateur);

		txtpassword.setName("txtpassword");
		txtpassword.setEchoChar((char)0);
		txtpassword.setText("Password");
		txtpassword.setBounds(26, 71, 405, 30);
		txtpassword.setColumns(10);
		txtpassword.addMouseListener(new FieldMouseListener());
		txtpassword.addFocusListener(new focusListener());
		txtpassword.addKeyListener(new keyListener());
		this.add(txtpassword);
		
		btnCrer.setName("btnCrer");
		btnCrer.setBounds(26, 126, 135, 36);
		btnCrer.addActionListener(new ButtonListener());
		this.add(btnCrer);

		back.setName("back");
		back.setBounds(279, 244, 160, 36);
		back.addActionListener(new ButtonListener());
		this.add(back);

		txtNomUtilisateur.setFocusable(false);
		txtpassword.setFocusable(false);
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
						btnCrer.doClick();
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
						((JPasswordField)e.getSource()).setEchoChar('•');
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
						((JPasswordField)e.getSource()).setEchoChar('•');
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
				case "btnCrer":
					String user = txtNomUtilisateur.getText();
					String pwd = new String(txtpassword.getPassword());
					lblUserPwd.setText("<html>");
					if(user.length() == 0 || pwd.length() == 0 || user.equals("Username") || pwd.equals("Password"))
					{
						if(user.length() == 0)
							lblUserPwd.setText(lblUserPwd.getText() + "The username must have at least one character<br></html>");
						if(pwd.length() == 0)
							lblUserPwd.setText(lblUserPwd.getText() + "The password must have at least one character<br>");
						if(user.equals("Username"))
							lblUserPwd.setText(lblUserPwd.getText() + "The username can't be \"Username\"<br>");
						if(pwd.equals("Password"))
							lblUserPwd.setText(lblUserPwd.getText() + "The password can't be \"Password\"<br>");
						lblUserPwd.setText(lblUserPwd.getText() + "</html>");
					}
					else
						controler.SaveUser(user, pwd);
					break;
				case "back":
					controler.SetConnexionWindow();
					break;
				default:
					break;
			}
		}
	  }
}
