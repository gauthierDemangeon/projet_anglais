import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Personne {

	String mail;
	public Personne()
	{
	}
	public Personne(String ad)
	{
		mail = ad;
	}
	public void GetMailFromLine(String line)
	{
		Pattern p = Pattern.compile("<.+@.+>");
		Matcher m = p.matcher(line);
		if(m.find())
			mail = line.substring(m.start()+1, m.end()-1);
	}
}
