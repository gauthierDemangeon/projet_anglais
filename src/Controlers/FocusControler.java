package Controlers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.Model;

public class FocusControler implements FocusListener {
	
	Model model;
	
	public FocusControler(Model m)
	{
		model = m;
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub

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
