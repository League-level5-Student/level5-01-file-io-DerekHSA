package _06_Pixel_Art_Save_State;

import java.awt.Color;
import java.io.Serializable;

public class Pixel implements Serializable{
	private static final long serialVersionUID = 1405732790065926670L;
	public int x;
	public int y;
	public Color color;
	
	public Pixel(int x, int y) {
		this.x = x;
		this.y = y;
		color = Color.WHITE;
	}
}
