package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlers.ButtonMouseControler;
import Controlers.FieldMouseControler;
import Controlers.FocusControler;
import Model.Model;





public class VueConnexion extends JPanel implements Vue {
	private JButton btnNewButton = new JButton(new ImageIcon("./images/boutonconnexion.png"));
	private JButton btnNewUser  = new JButton(new ImageIcon("./images/nouvelUtilisateur.png")); 	
	private JTextField txtNomUtilisateur= new JTextField();
	private JPasswordField txtpassword = new JPasswordField();
	private BufferedImage image;
	Model m;
	
	public VueConnexion(Model m){
	this.m = m;	
	setBounds(100, 100, 482, 329);
	this.setBorder(new EmptyBorder(5, 5, 5, 5));
	try {
		image= ImageIO.read(new File("./images/fenetreConnexion.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	this.setLayout(null);
	
	btnNewButton.setBounds(26, 134, 135, 36);
	this.add(btnNewButton);
	 
	txtNomUtilisateur.setName("txtuser");
	txtNomUtilisateur.setText("Username");
	txtNomUtilisateur.setBounds(26, 31, 405, 30);
	txtNomUtilisateur.setColumns(10);
	txtNomUtilisateur.addMouseListener(new FieldMouseControler(m));
	txtNomUtilisateur.addFocusListener(new FocusControler(m));
	this.add(txtNomUtilisateur);

	txtpassword.setName("txtpassword");
	txtpassword.setEchoChar((char)0);
	txtpassword.setText("Password");
	txtpassword.setBounds(26, 71, 405, 30);
	txtpassword.setColumns(10);
	txtpassword.addFocusListener(new FocusControler(m));
	txtpassword.addMouseListener(new FieldMouseControler(m));
	this.add(txtpassword);
	/*btnNewButton.addActionListener(new ConnexionControler2(this.m,this));
	btnNewUser .addActionListener(new NouvelUtilisateurControler(this.m,this));*/
		
	btnNewUser .setBounds(279, 244, 160, 36);
	this.add(btnNewUser );
	/*txtNomUtilisateur.addMouseListener(new mouseListener(txtNomUtilisateur));
	txtNomUtilisateur.addKeyListener(new ConnexionControler2(m,this));*/
	
	
	
	}
	
	
	public JButton getbtnNewUser (){
		return this.btnNewUser ;
	}
	public JTextField gettxtNomUtilisateur(){
		return this.txtNomUtilisateur;
	}
	
	public void update() {
		revalidate();
	}
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, this);            
	}
}

