package Controlers;

import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

import Main.FenetreConnexion;
import Model.Model;
import View.VueAccueil;
import View.VuePart1;

public class FieldMouseControler implements MouseListener{
	Model model;
	public FieldMouseControler(Model m)
	{
		model = m;
	}
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


	public void mouseReleased(MouseEvent e) {
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
				System.out.println(((JPasswordField)e.getSource()).getPassword().toString());
				if(Arrays.equals(((JPasswordField)e.getSource()).getPassword(),"Password".toCharArray()))
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
