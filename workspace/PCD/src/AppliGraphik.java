

import javax.swing.JButton;
import javax.swing.JFrame ;
import javax.swing.JLabel;

import java.awt.* ;

public class AppliGraphik extends JFrame{
	public AppliGraphik(){
	super("Ceci est le titre de la fenêtre") ;
	setPreferredSize(new Dimension(300, 200)) ;
	
	setLayout(new FlowLayout()) ;
	add(new JLabel ("Valeur ")) ;
	add(new JButton("+1")) ;
	
	pack() ;
	setVisible(true) ;
	}
	public static void main(String[] a){
	new AppliGraphik() ;
	}
}