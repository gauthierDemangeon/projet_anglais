

public class Trace 
{
	
	private long timestamp;
	private String ssid;
	private int signal;
	private GPS gps;
	

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getSignal() {
		return signal;
	}

	public void setSignal(int signal) {
		this.signal = signal;
	}

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}
	
	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	
	public Trace(long timestamp, String ssid, int signal, GPS gps) 
	{
		this.timestamp = timestamp;
		this.ssid = ssid;
		this.signal = signal;
		this.gps = gps;
	}
	
	@Override
	public String toString() 
	{
		return "Trace [timestamp=" + timestamp + ", ssid=" + ssid + ", signal="
				+ signal + ", données GPS="+gps.toString() + "]";
	}
	
}
