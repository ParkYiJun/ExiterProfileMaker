package classes;

import java.awt.Color;

public class Profile {
	String name;
	public int[] stats;
	Color bgColor;
	Color ghColor;

	public Profile() {
		stats = new int[5];
		bgColor = new Color(255,200,200);
		ghColor = new Color(0,0,0);
	}
	public void setName(String name) {
		this.name =name;
	}

	public String getName() {
		return name;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor =bgColor;
	}
	public Color getBgColor() {
		return bgColor;
	}

	public void setGhColor(Color ghColor) {
		this.ghColor = ghColor;
	}

	public Color getGhColor() {
		return ghColor;
	}

}
