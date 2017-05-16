package Controlers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Main.Window;
import Model.Model;
import View.*;

public class Controlers {

	Model model;
	public Controlers(Model m)
	{
		model = m;
	}
	public Window GetMainWindow()
	{
		return model.getF();
	}
}
