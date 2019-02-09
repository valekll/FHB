package fhb;

public class FHBGame extends Application {

   int money; //player money
   Group group; //main group
   double t; //keep track of time
   Stage fhbStage; //the main stage
   ArrayList<Character>();

 /**
  * default Constructor
  */
   public FHBGame() {
   }//constructor

 /**
 * sets up the nodes and adds them to the group
 */
   public void setUp() {
      
   }//setUp

 /**
 * the start method. sets up group and scene and bg
 * @param stage
 */
   public void start(Stage stage) {
      group = new Group();
      setUp();
      Scene scene = new Scene(group, 640, 880, Color.BLACK);
      stage.setTitle("Farm Hack Build");
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
