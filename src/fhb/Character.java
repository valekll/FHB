package fhb;

import javafx.scene.image.Image;

public class Character {
	private int hp;
	private String name;
	private String dia;
	private Sprite sprite;
	
	public Character(int h, String n, String d, double x, double y, Image[] normal, Image[] build, Image[] death) {
		hp = h;
		name = n;
		dia = d;
		sprite = new Sprite(x, y, normal, build, death);
	} //Character()
	
	//TODO:
	public boolean decHp(int dmg) {
		if(true) {
			return true;
		} //if
		return false;
	} //decHp()
} //Character
