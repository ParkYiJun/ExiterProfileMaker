package frames;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StatusPanel extends JPanel {
	private JLabel value;
	private JSlider slider;

	public StatusPanel(String name) {
		add(new JLabel(name));

		this.value = new JLabel("0");
		add(value);

		this.slider = new JSlider(0,10);
		this.slider.setValue(0);
		this.slider.setPaintTrack(true);
		add(slider);

		this.slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				value.setText(String.valueOf(slider.getValue()));
			}

		});
	}

	public int StatValue() {
		return slider.getValue();
	}

}
