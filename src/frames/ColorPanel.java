package frames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ColorPanel extends JPanel {
	JTextField colorCode;
	Color color;
	public ColorPanel(String name) {
		add(new JLabel(name));
		colorCode = new JTextField(5);
		colorCode.setEnabled(false);
		colorCode.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				color = JColorChooser.showDialog(colorCode, name, Color.white);
				colorCode.setBackground(color);
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
		add(colorCode);
	}
	public Color getColor() {
		return color;
	}

}
