
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Runner {

	private static Point clickLoc = null;

	private static int screenWidth, screenHeight;

	public static void main(String[] args) {

		JFrame main = new JFrame("Auto-Clicker Settings");
		JFrame locPicker = new JFrame();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = (int) screenSize.getWidth();
		screenHeight = (int) screenSize.getHeight();

		locPicker.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				clickLoc = arg0.getLocationOnScreen();
				System.out.println(clickLoc);
				locPicker.dispose();

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		locPicker.setSize(screenWidth, screenHeight);

		locPicker.setUndecorated(true);
		main.setAlwaysOnTop(true);

		locPicker.setBackground(new Color(0, 0, 0, 10));

		locPicker.setVisible(true);

		main.getContentPane().setLayout(null);

		JTextField interval = new JTextField();
		interval.setBounds(150, 10, 86, 20);

		JLabel intervalTitle = new JLabel("Click Interval (Sec)");
		intervalTitle.setBounds(10, 10, 150, 20);

		JLabel locationLabel = new JLabel("Click Location");
		locationLabel.setBounds(10, 40, 150, 20);

		main.getContentPane().add(interval);
		main.getContentPane().add(intervalTitle);
		main.getContentPane().add(locationLabel);

		main.setSize(730, 489);

		main.setVisible(true);

	}

}
