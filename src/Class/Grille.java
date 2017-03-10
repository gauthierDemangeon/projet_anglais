package Class;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Grille {
	String[] mots;
	String[] indication;
	Boolean[] orientation;
	String[][] lettres;
	int width, height;
	public Grille(String[] mots, String[] indication, Boolean[] orientation, String[][] lettres) {
		this.mots = mots;
		this.indication = indication;
		this.orientation = orientation;
		this.lettres = lettres;
		this.height = lettres.length;
		this.width = lettres[0].length;
	}
	public boolean IsLetter(int r,int c)
	{
		if(lettres[r][c].isEmpty())
			return false;
		return true;
	}
	public String[] getMots() {
		return mots;
	}
	public Boolean[] getOrientation() {
		return orientation;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String[] getWordIndexes(String word,boolean orientation)
	{
		String[] indexes = new String[word.length()];
		if(orientation)
		{
			for(int i=0;i<lettres[0].length;i++)
			{
				for(int j=0;j<lettres.length;j++)
				{
					if(lettres[j][i].equals(String.valueOf(word.charAt(0))))
					{
						String motteste = "" + word.charAt(0);
						indexes[0] = String.valueOf(j) + "," + String.valueOf(i);
						for(int k=1;k<word.length();k++)
						{
							motteste += lettres[j][i+k];
							indexes[k] = String.valueOf(j) + "," + String.valueOf(i + k);
						}
						if(word.equals(motteste))
						{
							return indexes;
						}
					}
				}
			}
		}
		else
		{
			for(int j=0;j<lettres.length;j++)
			{
				for(int i=0;i<lettres[0].length;i++)
				{
					if(lettres[j][i].equals(String.valueOf(word.charAt(0))))
					{
						String motteste = "" + word.charAt(0);
						indexes[0] = String.valueOf(j) + "," + String.valueOf(i);
						for(int k=1;k<word.length();k++)
						{
							motteste += lettres[j + k][i];
							indexes[k] = String.valueOf(j+k) + "," + String.valueOf(i);
						}
						if(word.equals(motteste))
						{
							return indexes;
						}
					}
				}
			}
		}
		return null;
	}
}