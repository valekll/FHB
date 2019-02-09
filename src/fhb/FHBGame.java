package fhb;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.shape.StrokeType;
import javafx.scene.shape.Rectangle;

public class FHBGame extends Application {
   AnimationTimer timer;
   int money; //player money
   Group group; //main group
   double t; //keep track of time
   Stage fhbStage; //the main stage
   ArrayList<Sprite> sprites; // arraylist of characters existing
   Sprite x;
   ArrayList<ImageView> images;
   ArrayList<Rectangle> recs;
   ArrayList<Rectangle> inner;
   
 /**
  * default Constructor
  */
   public FHBGame() {
   } //constructor

  public List<ImageView> getSprites() {
     return group.getChildren().stream()
                                 .map(node->(ImageView)node)
				 .collect(Collectors.toList());
  } //getSprites()

  public void update() {
    t += .01666;
    /*this.getSprites().forEach(s-> {
         
    });*/

    for (int i = 0; i< images.size(); i++) {
	if (images.get(i) != null) {
		System.out.println("removing image");
		group.getChildren().remove(images.get(i));
	} //if
	System.out.println("setting image");
	images.set(i, sprites.get(i).cycle());
	System.out.println("placing image");
	group.getChildren().add(images.get(i));
    } //for
  } //update()


 /**
  * sets up the nodes and adds them to the group
  */
   public void setUp() {
	   Image[] img = new Image[2]; 
	   img[0] = new Image("https://m.media-amazon.com/images/M/MV5BMTQ5NTUzNDE5OV5BMl5BanBnXkFtZTgwMjAwOTE1MDE@._V1_.jpg", 160, 160, false, false);
	   img[1] = new Image("https://pbs.twimg.com/media/DfzhghPX0AA4vHO.jpg", 160, 160, false, false);
	   x = new Sprite(100,100,img,img,img);
	   sprites = new ArrayList<Sprite>();
	   sprites.add(x);
	   images = new ArrayList<ImageView>();
	   images.add(sprites.get(0).cycle());
	   group.getChildren().add(images.get(0));
	   //SQUARES
	   recs = new ArrayList<Rectangle>();
	   inner = new ArrayList<Rectangle>();
	   for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	        	recs.add(new Rectangle(80 * i, 80 * j + 1, 79, 79));
	        	inner.add(new Rectangle(80 * i + 20, 80 * j + 21, 39, 39));
	        	recs.get((i * 8) + j).setStroke(Color.BLACK);
	        	recs.get((i * 8) + j).setFill(Color.web("F7F7F7"));
	        	inner.get((i * 8) + j).setStroke(Color.BLACK);
	        	inner.get((i * 8) + j).setFill(Color.web("FFB3B3")); //FFB3B3 red //98E698 green
				group.getChildren().add(recs.get((i * 8) + j));
	        	group.getChildren().add(inner.get((i * 8) + j));
	        }//for
	   }//for
   } //setUp

 /**
 * the start method. sets up group and scene and bg
 * @param stage
 */
   public void start(Stage stage) {
	  fhbStage = stage;
      group = new Group();
      setUp();
      timer = new AnimationTimer() {
         public void handle(long now) {
            if(stage.isShowing()) {
            	update();
            }
         } //handle()
      }; //AnimationTimer
      timer.start();
      Scene scene = new Scene(group, 880, 640, Color.BLACK);
      fhbStage.setTitle("Farm. Hack. Build. || Wonder Fieri");
      fhbStage.setScene(scene);
      fhbStage.sizeToScene();
      fhbStage.show();
   } //start

  /**
   * The main entry point for starting this application
   * @param args an array of String params given on the command line
   */
   public static void main(String[] args) {
      try {
         Application.launch(args);
      } catch (UnsupportedOperationException e) { 
         System.out.println(e);
         System.err.println("If this is a DISPLAY problem, then your X server connection");
         System.err.println("has likely timed out. This can generally be fixed by logging");
         System.err.println("out and logging back in.");
         System.exit(1);
      } // try
   } // main
} //fhbgame
