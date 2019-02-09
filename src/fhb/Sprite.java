package fhb;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sprite {
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
	
	public Sprite(double x, double y,Image[] normal, Image[] build, Image[] death) {
		xax = x;
		yax = y;
		nml = normal;
		nmlv = imageToImageViewArr(nml);
		bd = build;
		bdv = imageToImageViewArr(bd);
		dth = death;
		dthv = imageToImageViewArr(dth);
	} //Sprite()
	
	/**
	 * Change arr of Image to ImageView
	 * @param img the Image array
	 * @return ImageView Array
	 */
	public static ImageView[] imageToImageViewArr(Image ... img) {
		ImageView[] imgv = new ImageView[img.length];
		for(int i = 0; i > img.length; i++) {
			imgv[i] = new ImageView(img[i]);
		} //for
		return imgv;
	} //imageToImageViewArr()
	
	/**
	 * Cycles to next ImageView sprite
	 * @return the next ImageView
	 */
	public ImageView cycle() {
		nmlct++;
		if(nmlct >= nmlv.length) {
			nmlct = 0;
		} //if
		ImageView img = nmlv[nmlct];
		return img;
	} //cycle()
	
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
