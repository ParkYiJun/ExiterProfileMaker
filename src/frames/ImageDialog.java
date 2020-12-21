package frames;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

import classes.Profile;

public class ImageDialog extends JDialog  {

	private Profile profile;
	public ImageDialog(JFrame frame,String str,Profile profile) {
		super(frame, str, true);
		setResizable(false);
		setSize(800, 450);
		setUndecorated(true);

		this.profile = profile;
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Save();
				Dispose();
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

		setDefaultLookAndFeelDecorated(false);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(profile.getBgColor());
		g.fillRect(0, 0, 800, 450);
		String statName[] = new String[] {"호러민감","문제해결","문제탐지","자기주장","아이템소지"};
		g.setColor(profile.getGhColor());
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		for(int i =0;i<5;i++) {
			g.drawString(statName[i],300,82+75*i);
			g.drawString(String.valueOf(profile.stats[i]),760,82+75*i);
			g.fillRect(420,60+75*i,32*profile.stats[i],30);
		}
		g.setFont(new Font(Font.DIALOG,Font.BOLD|Font.ITALIC,25));
		g.drawString("NAME   "+profile.getName(), 40, 360);
		try {
			Image image = ImageIO.read(FilePath());
			g.drawImage(image,30,60,240,240,this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void Dispose() { this.dispose();}

	File FilePath() {
		File dir = new File(".");
		File files[] = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File f) {
				return f.getName().endsWith("png");
			}

		});

		return files[0];
	}

	void Save() {
		BufferedImage image = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d= image.createGraphics();
		this.paint(g2d);
		try {
			ImageIO.write(image, "jpg", new File(profile.getName()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
