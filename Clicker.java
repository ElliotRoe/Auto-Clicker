import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javafx.scene.input.KeyCode;

public class Clicker extends Thread implements KeyListener {

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

		for (int i = 0; i < 10; i++) {
			leftClick();
			robot.delay(interval);
		}
	}

	private void leftClick() {
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(200);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(200);
	}

	private void end() {
		stop = true;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {

			end();
			System.out.println("Program Closed");
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
