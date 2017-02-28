package Interface;

public interface Observable {
	  public void addObserver(Observer obs);
	  public void removeObserver();
	  public void notifyObserver(Observer obs);
	}