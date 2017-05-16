import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class Mail {
	private Personne sender;
	private String message = "";
	private int lineCount = 0;
	public Personne getSender() {
		return sender;
	}

	public void setSender(Personne sender) {
		this.sender = sender;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}
	
	public String StringToDate(String text) {
		String dateBrut;
		String[] tokens;
		int date;
		int year;
		int hourOfDay;
		int minute;
		int second;
		int month=0;
		int switcher = 0;
		FormatDate.toString(text);
		return "0";
		/*try
		{
			if(text.contains(","))
			{
				dateBrut = text.split(",")[1].trim();
				tokens = dateBrut.split(" ");
				date = Integer.parseInt(tokens[0].trim().substring(0, 1));
				year = Integer.parseInt(tokens[2].trim().substring(0, 3));
				hourOfDay = Integer.parseInt(tokens[3].split(":")[0]);
				minute = Integer.parseInt(tokens[3].split(":")[1]);
				second = Integer.parseInt(tokens[3].split(":")[2]);
				switcher = 1;
			}
			else
			{
				dateBrut = text.substring(10);
				dateBrut = dateBrut.replaceAll("  ", " ");
				tokens = dateBrut.split(" ");
				date = Integer.parseInt(tokens[1].trim().substring(0, 1));
				year = Integer.parseInt(tokens[3].trim().substring(0, 3));
				hourOfDay = Integer.parseInt(tokens[2].split(":")[0]);
				minute = Integer.parseInt(tokens[2].split(":")[1]);
				second = Integer.parseInt(tokens[2].split(":")[2]);
				month=0;
			}
			switch(tokens[switcher].trim())
			{
				case "Jan":
					month=1;
					break;
				case "Feb":
					month = 2;
					break;
				case "Mar":
					month = 3;
					break;
				case "Apr":
					month = 4;
					break;
				case "Mai":
					month = 5;
					break;
				case "Jun":
					month = 6;
					break;
				case "Jul":
					month = 7;
					break;
				case "Aug":
					month = 8;
					break;
				case "Sep":
					month = 9;
					break;
				case "Oct":
					month = 10;
					break;
				case "Nov":
					month = 11;
					break;
				case "Dec":
					month = 12;
					break;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return date+"/"+month+"/"+year+" "+hourOfDay+":"+minute+":"+second;*/
	}
}
