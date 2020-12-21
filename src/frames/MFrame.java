package frames;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Profile;

public class MFrame extends JFrame{
	Profile profile;
	private JTextField tnick;
	private StatusPanel[] status;
	private JButton trans;

	public MFrame() {
		super("Status Maker");

		profile = new Profile();
		JPanel before = new JPanel();
		before.add(new JLabel("Status Maker"));

		JPanel nickzone = new JPanel();
		nickzone.add(new JLabel("�̸�"));
		tnick = new JTextField(15);
		nickzone.add(tnick);
		before.add(nickzone);

		status = new StatusPanel[]
				{new StatusPanel("ȣ���ΰ�"),new StatusPanel("�����ذ�"),new StatusPanel("����Ž��"),new StatusPanel("�ڱ�����"),new StatusPanel("�����ۼ���")};

		for(StatusPanel p:status) {
			before.add(p);
		}

		ColorPanel bgColor = new ColorPanel("����");
		ColorPanel ghColor = new ColorPanel("���ڻ�");
		before.add(bgColor);
		before.add(ghColor);


		trans = new JButton("��ȯ");
		trans.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				profile.setName(tnick.getText());

				for(int i=0;i<5;i++) {
					profile.stats[i] =status[i].StatValue();
				}
				profile.setBgColor(bgColor.getColor());
				profile.setGhColor(ghColor.getColor());

				MakeD();
			}
		});
		before.add(trans,BorderLayout.CENTER);

		add(before);


		setSize(300,350);
		setResizable(true);
		setVisible(true);
	}

	public void MakeD() {
		ImageDialog d = new ImageDialog(this, "picture",profile);
	}

}
