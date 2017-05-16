import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NBA {
	ArrayList<Conference> Conferences = new ArrayList<Conference>();
	public static void main(String[] args)
	{
		NBA Ob = new NBA();
		FileReader Fr;
		BufferedReader Buffer;
		
			try {
				Fr = new FileReader("C:\\Users\\gauthier\\Desktop\\TELECOM\\2A\\VisualisationDonnees\\nba-no-hierarchy.txt");
				Buffer = new BufferedReader(Fr);
				String ligne;
				try {
					//Entete
					ligne = Buffer.readLine();
					
					ligne = Buffer.readLine();
					while(ligne!=null)
					{
						String[] items = ligne.split("\t");
						boolean exist = false;
						int index = -1;
						for(int i=0;i<Ob.Conferences.size();i++)
						{
							if(Ob.Conferences.name == items[1])
							{
								exist = true;
								index = i;
							}
						}
						if(exist)
						{
							for(Division d:Ob.CO)
						}
						else
						{
							
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Conference c : Ob.Conferences)
			{
				c.print();
			}
	}
}
class Conference
{
	String name;
	ArrayList<Division> Divisions;
	public Conference(String name)
	{
		this.name = name;
	}
	public String print()
	{
		return "";
	}
}
class Division
{
	String name;
	ArrayList<Team> Teams;
	public Division(String name)
	{
		this.name = name;
	}
}
class Team
{
	String name;
	ArrayList<Team> Players;
	public Team(String name)
	{
		this.name = name;
	}
}
class Player
{
	String name;
	int score;
	public Player(String name,int score)
	{
		this.name = name;
		this.score = score;
	}
}
