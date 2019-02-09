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

public class FHBGame extends Application {

   int money; //player money
   Group group; //main group
   double t; //keep track of time
   Stage fhbStage; //the main stage
   ArrayList<Character> characters; // arraylist of characters existing
   Sprite x;
 /**
  * default Constructor
  */
   public FHBGame() {
   }//constructor

  public List<Sprite> getCharacters() {
     return group.getChildren().stream()
                                 .map(node->(Sprite)node)
				 .collect(Collectors.toList());
  } //getCharacters()

  public void update() {
    t+= .01666;
    this.getCharacters().forEach(c-> {
       c.build();
    });
  }


 /**
 * sets up the nodes and adds them to the group
 */
   public void setUp() {
      characters = new ArrayList<Character>();
      Image[] img = new Image[1]; 
      img[0] = new Image("https://m.media-amazon.com/images/M/MV5BMTQ5NTUzNDE5OV5BMl5BanBnXkFtZTgwMjAwOTE1MDE@._V1_.jpg", 150, 150, false, false);
      x = new Sprite(100,100,img,img,img);
   }//setUp

 /**
 * the start method. sets up group and scene and bg
 * @param stage
 */
   public void start(Stage stage) {
      group = new Group();
      setUp();
      Scene scene = new Scene(group, 880, 640, Color.BLACK);
      stage.setTitle("Farm. Hack. Build.");
      stage.setScene(scene);
      stage.sizeToScene();
      stage.show();
   }//start

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
}//fhbgame
