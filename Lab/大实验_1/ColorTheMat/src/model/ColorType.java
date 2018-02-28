package model;

import java.awt.Color;

public enum ColorType {
	A(0, 0, 255), B(0, 255, 0), C(255, 0, 0), D(0, 255, 255), E(255, 0, 255), F(255, 255, 0);
	
	public Color rgb;
	
	ColorType(int r, int g, int b) {
		this.rgb = new Color(r, g, b);
	}
}
