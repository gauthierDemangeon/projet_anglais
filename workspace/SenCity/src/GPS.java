
public class GPS {
	private double latitude;
	private double longitude;
	
	public GPS() {
		this(0,0);
	}
	public GPS(double l,double L) {
		latitude=l;
		longitude=L;
	}
	public void setLatitude(double l) {
		latitude = l;
	}
	public void setLongitude(double l) {
		longitude = l;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public String toString() {
		return latitude+","+longitude;
	}
}
