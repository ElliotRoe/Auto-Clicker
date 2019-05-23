
import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Runner {

	private static Point clickLoc = null;

	private static int screenWidth, screenHeight;

	private static JLabel locationLabel = null;

	private static int intervalMillis = 1000;

	static Clicker robotClicker;

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
				locPicker.setVisible(false);
				locationLabel.setText("Click Location         ( " + clickLoc.getX() + " , " + clickLoc.getY() + " )");

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
		main.setLocation(screenWidth / 2 - 100, screenHeight / 2 - 100);

		main.getContentPane().addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Key Pressed");
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					robotClicker.end();

				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		JTextField interval = new JTextField();
		interval.setBounds(150, 10, 86, 20);

		JLabel intervalTitle = new JLabel("Click Interval (Sec)");
		intervalTitle.setBounds(10, 10, 150, 20);

		locationLabel = new JLabel("Click Location         ( -- , -- )");
		locationLabel.setBounds(10, 40, 300, 20);

		JButton settingButton = new JButton("Start");
		JButton endButton = new JButton("End");
		JButton choose = new JButton("");
		settingButton.setBounds(25, 90, 70, 30);
		endButton.setBounds(153, 90, 70, 30);
		choose.setBounds(93, 40, 20, 20);

		settingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(interval.getText());
				if (interval.getText().equals("") || locPicker.isVisible()) {

				} else {
					try {
						intervalMillis = Integer.parseInt(interval.getText()) * 1000;
						// main.setVisible(false);
						runClicker();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}

		});

		endButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				robotClicker.end();
				System.out.println("Ended");

			}

		});

		choose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				locationLabel.setText("Click Location         ( -- , -- )");
				clickLoc = null;
				locPicker.setVisible(true);

			}

		});

		main.getContentPane().add(interval);
		main.getContentPane().add(intervalTitle);
		main.getContentPane().add(locationLabel);
		main.getContentPane().add(settingButton);
		main.getContentPane().add(endButton);
		main.getContentPane().add(choose);

		main.setSize(265, 180);

		main.setVisible(true);

	}

	public static void runClicker() throws AWTException {

		robotClicker = new Clicker(intervalMillis, clickLoc);
		robotClicker.start();

	}

}
