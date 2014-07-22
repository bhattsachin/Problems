package study.pattern.design.observer;

/**
 * event abstraction
 * @author root
 *
 */
public interface Event extends Subject{
	public void trigger();
}
