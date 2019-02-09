package fhb;

import javafx.scene.image.Image;

public class Mobile extends Character {
	private int att;
	
	public Mobile(int a, int h, String n, String d, double x, double y, Image[] normal, Image[] build, Image[] death) {
		super(h, n, d, x, y, normal, build, death);
		setAtt(a);
	} //Mobile()

	public int getAtt() {
		return att;
	} //getAtt()

	public void setAtt(int att) {
		this.att = att;
	} //setAtt()
} //Mobile
