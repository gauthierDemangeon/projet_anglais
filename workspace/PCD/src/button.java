

import javax.swing.JButton;
import javax.swing.JLabel;

public class button extends JButton{
	
	int val;
	int x;
	int y;
	
	public button(button Bouton){
		super(String.valueOf(Bouton.val));
		this.val = Bouton.getVal();
		this.x = Bouton.getX();
		this.y = Bouton.getY();
	}
	
	public button(int val, int x, int y) {
		super(String.valueOf(val));
		this.val = val;
		this.x = x;
		this.y = y;
	}
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
