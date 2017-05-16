import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args)
	{ 
		FileReader Fr;
		BufferedReader Buffer;
		String ligne = "";
		Fenetre f = new Fenetre();
		try 
		{
			Fr = new FileReader(f.getFile());
			Buffer = new BufferedReader(Fr);
			ArrayList<Mail> MailList = new ArrayList<Mail>();
			ArrayList<Personne> Pers = new ArrayList<Personne>();
			Mail m;
			Personne p;
			while (ligne != null) 
			{
				m = new Mail();
				p = new Personne();
				while(!ligne.startsWith("\n"))
				{
					ligne = Buffer.readLine();
					if(ligne == null)
						return;
					if(ligne.startsWith("From:"))
					{
						p.GetMailFromLine(ligne);
						m.setSender(p);
					}
					//if(ligne.startsWith("Date:"))
						//m.StringToDate(ligne.trim());
					if(ligne.startsWith("Lines:"))
						m.setLineCount(Integer.parseInt(ligne.split(":")[1].trim()));
				}
				for(int i=0;i<m.getLineCount();i++)
				{
					m.setMessage(m.getMessage() + Buffer.readLine() + "\n");
				}
				MailList.add(m);
				ligne = Buffer.readLine();
			}
			System.out.println("Fini"); 
			Buffer.close();
			System.out.println("Fini"); 
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("Erreur lors du chargement du fichier"); 
		}
		System.out.println("Fini"); 
	}
}
