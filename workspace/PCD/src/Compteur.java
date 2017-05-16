

import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

class Compteur extends JFrame implements ActionListener{
	private int cpt ;
	private JButton jb ;
	private JLabel jlab ;
	private int val;
	private int nb_click=0;
	public Compteur (){
		super("increment 5x5") ;
		setPreferredSize(new Dimension(500, 500)) ;
		setLayout(new GridLayout(5,5)) ; // cree la grille différent de "setLayout(new FlowLayout()) ;" qui cree une fenetre basique
		for (int i=0;i<25;i++){
			int val = (int) (Math.random()*4) + 1; // On cree une valeur entiere random compris dans [1,4]
			this.val = val;
			String name = Integer.toString(val);
			jb = new JButton(name); this.add(jb);
			jb.addActionListener(this) ;
		}
		
		pack() ;
		setVisible(true);
	}
	
public void actionPerformed(ActionEvent e){
	this.increment((JButton)e.getSource()) ;
	//jlab.setText(""+cpt) ;
	System.out.println("Valeur boutton : "+((JButton)e.getSource()).getText()+" | Nombre de clicks : " + ++nb_click + "\n\n");
	//jb.setText(Integer.toString(++val));
}

public void increment(JButton sender){
	int cpt = Integer.parseInt(sender.getText());
	sender.setText(Integer.toString(++cpt)) ;
}

public static void main(String[] a){
		new Compteur() ;
}

}