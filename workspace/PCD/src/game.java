

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class game extends JFrame implements ActionListener {
	
	public game(grille_button plateau){
		super("game") ;
		int x = plateau.x;
		int y = plateau.y;
		setPreferredSize(new Dimension(500, 500)) ;
		JPanel pan = new JPanel(new GridLayout(x,y)) ; // cree la grille différent de "setLayout(new FlowLayout()) ;" qui cree une fenetre basique
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				button boutton = plateau.M[i][j];
				boutton.addActionListener(plateau);
				pan.add(boutton);
			}
		}
		pack() ;
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(pan);
		setVisible(true);
		pan.repaint();
		this.repaint();
	}
	
	public static void main(String[] a){
		grille_button plateau = new grille_button(5,5);
		game Mygame = new game(plateau);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
