import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class grille_button implements ActionListener {
	
	int x;
	int y;
	button[][] M;
	
	public grille_button(int x,int y){
		this.x = x;
		this.y = y;
		this.M = new button[x][y];
		for (int i=0;i<x;i++){
			for (int j=0;j<y;j++){
				button boutton = new button((int) (Math.random()*4) + 1,i,j);
				M[i][j]= boutton;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		button b = (button)e.getSource();
		int x2 = b.x;
		int y2 = b.y;
		b.setVal(b.getVal()+1);
		b.setText(String.valueOf(b.getVal()));
		if(x2 == 0)
		{
			if(y2 == 0)
			{
				M[x2+1][y2].setVal(0);
				M[x2+1][y2].setText("0");
				M[x2][y2+1].setVal(0);
				M[x2][y2+1].setText("0");
			}
			else
			{
				if(y2 == this.y-1)
				{
					M[x2+1][y2].setVal(0);
					M[x2+1][y2].setText("0");
					M[x2][y2-1].setVal(0);
					M[x2][y2-1].setText("0");
				}
				else
				{
					M[x2+1][y2].setVal(0);
					M[x2+1][y2].setText("0");
					M[x2][y2-1].setVal(0);
					M[x2][y2-1].setText("0");
					M[x2][y2+1].setVal(0);
					M[x2][y2+1].setText("0");
				}
			}
		}
		else
		{
			if(x2 == this.x-1)
			{
				if(y2 == 0)
				{
					M[x2-1][y2].setVal(0);
					M[x2-1][y2].setText("0");
					M[x2][y2+1].setVal(0);
					M[x2][y2+1].setText("0");
				}
				else
				{
					if(y2 == this.y-1)
					{
						M[x2-1][y2].setVal(0);
						M[x2-1][y2].setText("0");
						M[x2][y2-1].setVal(0);
						M[x2][y2-1].setText("0");
					}
					else
					{
						M[x2-1][y2].setVal(0);
						M[x2-1][y2].setText("0");
						M[x2][y2-1].setVal(0);
						M[x2][y2-1].setText("0");
						M[x2][y2+1].setVal(0);
						M[x2][y2+1].setText("0");
					}
				}
			}
			else
			{
				if(y2 == 0)
				{
					M[x2-1][y2].setVal(0);
					M[x2-1][y2].setText("0");
					M[x2+1][y2].setVal(0);
					M[x2+1][y2].setText("0");
					M[x2][y2+1].setVal(0);
					M[x2][y2+1].setText("0");
				}
				else
				{
					if(y2 == this.y-1)
					{
						M[x2-1][y2].setVal(0);
						M[x2-1][y2].setText("0");
						
						M[x2+1][y2].setVal(0);
						M[x2+1][y2].setText("0");
						
						M[x2][y2-1].setVal(0);
						M[x2][y2-1].setText("0");
					}
					else
					{
						M[x2-1][y2].setVal(0);
						M[x2-1][y2].setText("0");
						
						M[x2+1][y2].setVal(0);
						M[x2+1][y2].setText("0");
						
						M[x2][y2-1].setVal(0);
						M[x2][y2-1].setText("0");
						
						M[x2][y2+1].setVal(0);
						M[x2][y2+1].setText("0");
					}
				}
			}
		}
	}
}
