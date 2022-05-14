
public class BoardTile {
   private String tileRepresentation;
   private boolean isEmpty;
   
   
   //Change to different tile types instead? dif objects?
   public BoardTile(String tileRepresentation){
      if (tileRepresentation == "^" || tileRepresentation == "_" || tileRepresentation == "|" ){
         this.tileRepresentation = tileRepresentation;
         this.isEmpty = false;
      } else {
         this.tileRepresentation = " ";
         this.isEmpty = true;
      }
   }
   
   public BoardTile(boolean hasPlayer){
      if(hasPlayer){
         this.tileRepresentation = "P";
         this.isEmpty = false;
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