package fhb;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sprite {
	private int dir; //direction
	private int pps; //pace per second
	private double xax; //x and y axis
	private double yax;
	private Image[] nml; //normal
	private ImageView[] nmlv;
	private int nmlct;
	private Image[] bd; //build
	private ImageView[] bdv;
	private int bdct;
	private Image[] dth; //death
	private ImageView[] dthv;
	private int dthct;
	
	public Sprite(double x, double y, Image[] normal, Image[] build, Image[] death) {
		dir = 0;
		pps = 0;
		xax = x;
		yax = y;
		nml = normal;
		if(normal.length == 0 || build.length == 0 || death.length == 0) {
			System.out.println("Constructor error");
		}
		nmlv = imageToImageViewArr(nml);
		bd = build;
		bdv = imageToImageViewArr(bd);
		dth = death;
		dthv = imageToImageViewArr(dth);
	} //Sprite()
	
	public Sprite(double x, double y, ImageView[] normal, ImageView[] build, ImageView[] death) {
		xax = x;
		yax = y;
		if(normal.length == 0 || build.length == 0 || death.length == 0) {
			System.out.println("Constructor error");
		}
		nmlv = normal;
		bdv = build;
		dthv = death;
	} //Sprite()
	
	/**
	 * Change arr of Image to ImageView
	 * @param img the Image array
	 * @return ImageView Array
	 */
	public static ImageView[] imageToImageViewArr(Image ... img) {
		ImageView[] imgv = new ImageView[img.length];
		for(int i = 0; i < img.length; i++) {
			imgv[i] = new ImageView(img[i]);
			System.out.println("Adding Sprite Image: " + img[i]);
		} //for
		return imgv;
	} //imageToImageViewArr()
	
	/**
	 * Cycles to next ImageView sprite
	 * @return the next ImageView
	 */
	public ImageView cycle() {
		pps++;
		if(pps == 10) {
			pps = 0;
			nmlct++;
			move();
			if((nmlct + 1) % 3 == 0) {
				chDir();
			} //if
			if(nmlct >= nmlv.length) {
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
	
	/**
	 * @return number of frames
	 */
	public int getCycleLength() {
		return nmlv.length;
	} //getCycleLength()
	
	/**
	 * Build animation
	 * @return the next ImageView for build
	 */
	public ImageView build() {
		bdct++;
		if(bdct >= bdv.length) {
			bdct = 0;
		} //if
		ImageView img = bdv[bdct];
		return img;
	} //build()
	
	/**
	 * @return number of frames
	 */
	public int getBuildLength() {
		return bdv.length;
	} //getBuildLength()
	
	/**
	 * Death animation
	 * @return the next ImageView for death
	 */
	public ImageView death() {
		dthct++;
		if(dthct >= dthv.length) {
			dthct = 0;
		} //if
		ImageView img = dthv[dthct];
		return img;
	} //death()
	
	/**
	 * @return number of frames
	 */
	public int getDeathLength() {
		return dthv.length;
	} //getDeathLength()

	public double getXax() {
		return xax;
	} //getXax()

	public void setXax(double xax) {
		this.xax = xax;
	} //setXax()

	public double getYax() {
		return yax;
	} //getYax()

	public void setYax(double yax) {
		this.yax = yax;
	} //setYax()
} //Sprite
