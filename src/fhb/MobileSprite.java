package fhb;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MobileSprite extends Sprite {
	protected int dir; //direction
	protected int nmlStart;
	protected int nmlEnd;
	
	public MobileSprite(double x, double y, Image[] normal, Image[] build, Image[] death) {
		super(x, y, normal, build, death);
		dir = 0;
		nmlStart = 0;
		nmlFrames = nmlFrames / 4;
		nmlEnd = nmlStart + nmlFrames;
	} //MobileSprite()

	public MobileSprite(double x, double y, ImageView[] normal, ImageView[] build, ImageView[] death) {
		super(x, y, normal, build, death);
		dir = 0;
		nmlStart = 0;
		nmlFrames = nmlFrames / 4;
		nmlEnd = nmlStart + nmlFrames;
	} //MobileSprite()
	
	/**
	 * Cycles to next ImageView sprite
	 * @return the next ImageView
	 */
	public ImageView cycle(int d) {
		pps++;
		if(pps == 10) { //once every 10 frames
			pps = 0; //reset pps
			boolean check = !chDir(d);
			if(check) { //check for changes in direction
				nmlct++;
				if(nmlct >= nmlEnd) {
					nmlct = nmlStart;
				} //if
			} //if
			move(check);
			/*if((nmlct + 1) % (nmlFrames) == 0) {
				chDir();
			} //if
			 */
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
	private boolean move(boolean mv) {
		if(mv) {
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
		} //if
		return mv;
	} //move()
	
	/**
	 * Gives directions for a clockwise circuit
	 * @param d current direction
	 * @return new direction
	 */
	public static int rdlu(int d) {
		if(d == 0) { //down
			d = 1;
		} //if
		else if(d == 1) { //left
			d = 3;
		} //else if
		else if(d == 2) { //right
			d = 0;
		} //else if
		else if(d == 3) { //up
			d = 2;
		} //else if
		return d;
	} //rdlu
	
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
	
	/**
	 * Changes direction of movement
	 */
	public boolean chDir(int d) {
		if(dir <=3 && dir >= 0 && dir != d) {
			dir = d;
			if(dir == 0) { //down
				nmlStart = 0;
			} //if
			else if(dir == 1) { //left
				nmlStart = nmlFrames;
			} //else if
			else if(dir == 2) { //right
				nmlStart = nmlFrames * 2;
			} //else if
			else if(dir == 3) { //up
				nmlStart = nmlFrames * 3;
			} //else if
			nmlEnd = nmlStart + nmlFrames;
			nmlct = nmlStart;
			return true;
		} //if
		return false;
	} //chDir()
	
	public int getDir() {
		return dir;
	} //getDir()
} //MobileSprite
