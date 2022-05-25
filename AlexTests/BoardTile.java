import javax.swing.*;
import java.awt.Color;


public class BoardTile {

   //private ImageIcon tileIcon;
   private String tileRepresentation;// this is for the print statement tests
   private boolean isEmpty;// false if has player or wall
   
   
   //Change to different tile types instead? dif objects?
   public BoardTile(String tileRepresentation){
      //ImageIcon sandIcon = new ImageIcon("art/SandJPG.png");
   
      // Basic Square map for test purposes
      // Need to Add Enemy Representation
      if (tileRepresentation == "^" || tileRepresentation == "_" || tileRepresentation == "|" ||
                        tileRepresentation == "P" || tileRepresentation == "E" ){
         this.tileRepresentation = tileRepresentation; //assigns tileRep field
         this.isEmpty = false;
      } else {
         this.tileRepresentation = " ";
         this.isEmpty = true;
      }
   }
	
   public static boolean walkable(BoardTile tile){
      return tile.isEmpty;
   }
	
   public static void printTileContent(BoardTile tile){
      System.out.print(tile.tileRepresentation);
   }
	
   public void assignTileContent(BoardTile tile, String input){
      tile.tileRepresentation = input;
   }
}