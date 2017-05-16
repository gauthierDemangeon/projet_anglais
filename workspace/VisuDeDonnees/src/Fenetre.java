import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Fenetre extends JFrame implements ActionListener{

    final JFileChooser fc = new JFileChooser();
    JButton but = new JButton();
    String File;
	public String getFile() {
		return File;
	}

	public Fenetre()
	{
		// Fenetre
		this.setTitle("Youtube copycat");
	    this.setSize(1280, 740);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    Panel p = new Panel();
	    p.add(but);
	    but.addActionListener(this);
	    this.setContentPane(p);
	    this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	        int returnVal = fc.showOpenDialog(this);
	}
}
