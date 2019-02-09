package fhb;

import javafx.scene.image.Image;

public class Character {
	private int hp;
	private int hpc;
	private String name;
	private String dia;
	private Sprite sprite;
	
	public Character(int h, String n, String d, double x, double y, Image[] normal, Image[] build, Image[] death) {
		hp = h;
		hpc = hp;
		name = n;
		dia = d;
		sprite = new Sprite(x, y, normal, build, death);
	} //Character()
	
	public void resetHp() {
		hpc = hp;
	} //resetHp()
	
	/**
	 * @param dmg damage to deal
	 * @return 
	 */
	public boolean decHp(int dmg) {
		if(dmg > 0) {
			hpc -= dmg;
			return true;
		} //if
		return false;
	} //decHp()
	
	/**
	 * Checks for death and runs the death sequence.
	 * @return false if alive, true if dead
	 */
	public boolean checkDead() {
		if(hpc > 0) {
			return false;
		} //if
		/*
		 * Run death sequence here
		 */
		return true;
	} //checkDead()
} //Character
