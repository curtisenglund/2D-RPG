import java.util.*;

public class Board {
   private static BoardTile[][] Board;
   private static Random rand = new Random();

   public Board(int size) {
      Board = new BoardTile[size][size];
   }

	// Initialize BoardTile Objects within an array of arrays
	// Able to adjust this method to generate random maps or possible use Kirils
	// text file maps to generate an underlying grid
   public static void populateEmptyBoard(Board board) {
      for (int i = 0; i < board.Board.length; i++) {
         for (int j = 0; j < board.Board[i].length; j++) {
            if (i == 0){
               board.Board[i][j] = new BoardTile("^");
            
            } else if ( i == board.Board.length - 1){
               board.Board[i][j] = new BoardTile("_");
            } else if ( j == 0 || j == board.Board.length - 1){
               board.Board[i][j] = new BoardTile("|");
            } else {
               board.Board[i][j] = new BoardTile(" ");
            }
         }
      }
      //for player and enemy starting positions
      board.Board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile("P");
      board.Board[Enemy.getEnemyYPos()][Enemy.getEnemyXPos()] = new BoardTile("E");
   }

   public static void printBoard(Board board) {
      for (int i = 0; i < board.Board.length; i++) {
         for (int j = 0; j < board.Board[i].length; j++) {
            BoardTile.printTileContent(Board[i][j]);
         }
         System.out.println();
      }
   }
   

	// Below is Player movement based on WASD.
   // Kinda ugly could clean up/consolidate based on keyed input

   public static void movePlayerUp(Board Board){
      
      if(Board.walkable(Board, Hero.getHeroYPos() - 1, Hero.getHeroXPos()) == true){
      
         Board.Board[Hero.getHeroYPos() - 1][Hero.getHeroXPos()] = new BoardTile("P");
         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(" ");
         Hero.setHeroYPos(Hero.getHeroYPos() - 1);
         
      } else {
         System.out.println("pressed w but can't move UP");
      }
      Board.printBoard(Board);
   }
   
   public static void movePlayerDown(Board Board){
      
      
      if(Board.walkable(Board, Hero.getHeroYPos() + 1, Hero.getHeroXPos()) == true){
      
         Board.Board[Hero.getHeroYPos() + 1][Hero.getHeroXPos()] = new BoardTile("P");
         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(" ");
         Hero.setHeroYPos(Hero.getHeroYPos() + 1);
         
      } else {
         System.out.println("pressed S but can't move DOWN");
      }
      Board.printBoard(Board);
   }
   
   public static void movePlayerRight(Board Board){

      if(Board.walkable(Board, Hero.getHeroYPos(), Hero.getHeroXPos() + 1) == true){

         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos() + 1] = new BoardTile("P");
         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(" ");
         Hero.setHeroXPos(Hero.getHeroXPos() + 1);

      } else {
         System.out.println("pressed D but can't move RIGHT");
      }
      Board.printBoard(Board);
   }
   
   
   public static void movePlayerLeft(Board Board){

      if(Board.walkable(Board, Hero.getHeroYPos(), Hero.getHeroXPos() - 1) == true){

         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos() - 1] = new BoardTile("P");
         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(" ");
         Hero.setHeroXPos(Hero.getHeroXPos() - 1);
         
      } else {
         System.out.println("pressed A but can't move LEFT");
      }
      Board.printBoard(Board);
   }


   //returns true if tile is walkable. IE doesn't have a wall or character on it.
   public static boolean walkable(Board Board, int y, int x){
      return BoardTile.walkable(Board.Board[y][x]);
   }
   
 //   public static int[][] checkForMeleeRange(){
//       int[][] enemyCoordArray = new int[][];
//       int x = Hero.getHeroXPos();
//       int y = Hero.getHeroYPos();
//    }
}