package study.pattern.design.observer;

public interface Subject {
	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();

}
