package View;

import java.awt.*;

import javax.swing.*;

import Controlers.ButtonMouseControler;
import Model.Model;

public class VuePart1 extends ImagePanel implements Vue {

	Model model;
	public VuePart1(Model m)
	{
		super();
		model = m;
		JButton back = new JButton(new ImageIcon ("./images/boutonlogo.png"));
		back.setName("backV1");
		back.setOpaque(false);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.addMouseListener(new ButtonMouseControler(m));
		JPanel pan = new JPanel(new BorderLayout());
		pan.setOpaque(false);
		pan.add(back,BorderLayout.AFTER_LINE_ENDS);
		add(pan,BorderLayout.SOUTH);
	}
	public void update() {
		model.getF().setContentPane(this);
		model.getF().revalidate();
	}

}
