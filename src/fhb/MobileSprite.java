package fhb;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MobileSprite extends Sprite {
	protected int dir; //direction
	
	public MobileSprite(double x, double y, Image[] normal, Image[] build, Image[] death) {
		super(x, y, normal, build, death);
		dir = 0;
		nmlFrames = nmlFrames / 4;
	} //MobileSprite()

	public MobileSprite(double x, double y, ImageView[] normal, ImageView[] build, ImageView[] death) {
		super(x, y, normal, build, death);
		dir = 0;
		nmlFrames = nmlFrames / 4;
	} //MobileSprite()
	
	/**
	 * Cycles to next ImageView sprite
	 * @return the next ImageView
	 */
	@Override
	public ImageView cycle() {
		pps++;
		if(pps == 10) {
			pps = 0;
			nmlct++;
			move();
			if((nmlct + 1) % (nmlFrames) == 0) {
				chDir();
			} //if
			if(nmlct >= nmlFrames * 4) {
				nmlct = 0;
			} //if
			//System.out.println(nmlv[nmlct]);
		} //if
		ImageView img = nmlv[nmlct];
		img.setX(xax);
		img.setY(yax);
		if(img == null) {
			System.out.println("returning nothing");
			System.out.println("Count: " + nmlct + " Frames: " + nmlv.length);
			System.out.println(nmlv[nmlct]);
		}
		return img;
	} //cycle()
	
	/**
	 * Move 10 pixels in a set direction
	 */
	private void move() {
		if(dir == 0) { //down
			yax += 10.0;
		} //if
		else if(dir == 1) { //left
			xax -= 10.0;
		} //else if
		else if(dir == 2) { //right
			xax += 10.0;
		} //else if
		else if(dir == 3) { //up
			yax -= 10.0;
		} //else if
	} //move()
	
	 /**
	  * Changes direction of movement
	  */
	private void chDir() {
		if(dir == 3) {
			dir = 0;
		} //if
		else {
			dir++;
		} //else
	} //chDir()
} //MobileSprite
