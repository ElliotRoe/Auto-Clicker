import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javafx.scene.input.KeyCode;

public class Clicker extends Thread {

	Point location;
	int interval;

	Robot robot = new Robot();
	private boolean stop = false;

	public Clicker(int inter, Point loc) throws AWTException {

		interval = inter;
		location = loc;

		robot.mouseMove((int) loc.getX(), (int) loc.getY());

	}

	@Override
	public void run() {

		for (; stop == false;) {

			leftClick();
			robot.delay(interval);
		}
	}

	private void leftClick() {
		robot.mousePress(InputEvent.BUTTON1_MASK);
		System.out.println("Mouse Down");
		robot.delay(200);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		System.out.println("Mouse Up");
		robot.delay(200);
	}

	public void end() {
		stop = true;
	}

}
