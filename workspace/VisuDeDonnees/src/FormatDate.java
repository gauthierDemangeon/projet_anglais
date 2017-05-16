import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FormatDate {
	private static int jour;
	private static int mois;
	private static int annee;
	private static String temps;
	private static Pattern[] pat = new Pattern[] {Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}"),Pattern.compile(".*[0-9]{2}.*[0-9]{4}.*[0-9]{2}:[0-9]{2}")};
	
	private static void SearchPattern(String pattern)
	{
		pattern = pattern.split(":")[1].trim();
		pattern = pattern.replaceAll("(  )|(,)|(\t)" , " ");
		Matcher[] mat = new Matcher[pat.length];
		for(int i=0;i<pat.length;i++)
		{
			mat[i] = pat[i].matcher(pattern);
			if(mat[i].find())
			{
				TraitementPattern(pattern.substring(mat[i].start(), mat[i].end()),i);
				return;
			}
		}
	}
	private static void TraitementPattern(String pattern, int i) {
		switch(i)
		{
			case 0:
				String[] tokens = pattern.split("/");
				jour = Integer.parseInt(tokens[0]);
				mois = Integer.parseInt(tokens[1]);
				annee = Integer.parseInt(tokens[2]);
				break;
			default:
				break;
		}
	}
	public static String toString(String pattern)
	{
		SearchPattern(pattern);
		return jour+"/"+mois+"/"+annee+" "+temps;
	}
}
