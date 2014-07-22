package study.pattern.design.observer;

/**
 * Keyboard/mouse/touchscreen
 * @author root
 *
 */
public interface Devices {
	
	public enum Keyboard{Press, Keyup, Enter};
	
	public enum Mouse{Over, RightClick, LeftClick};
	
	public enum Touch{Pinch, Swipe, Tap};

}
