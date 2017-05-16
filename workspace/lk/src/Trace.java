import java.io.IOException;


public class Trace {
	
	private String timestamp;
	private String ssid;
	private int signal;
	
	public Trace(String timestamp, String ssid, int signal) {
		this.timestamp = timestamp;
		this.ssid = ssid;
		this.signal = signal;
	}

	@Override
	public String toString() {
		return "Trace [timestamp=" + timestamp + ", ssid=" + ssid + ", signal="
				+ signal + "]";
	}
	
}
