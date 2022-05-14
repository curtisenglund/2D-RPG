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
              // int randomTile = rand.nextInt(10);
              // if (randomTile <= 8){
               board.Board[i][j] = new BoardTile(" ");
              // } else {
              //    board.Board[i][j] = new BoardTile(" X");
              // }
            }
         
            
         }
      	// New BoardTile(1) sets the value of the tile to an int --- 1
      	// Was just using 1 to represent empty at the moment
      	// But we can change the int to a field or whatever we want within
      	// the BoardTile class
      }
   }

   public static void printBoard(Board board) {
      for (int i = 0; i < board.Board.length; i++) {
         for (int j = 0; j < board.Board[i].length; j++) {
            BoardTile.printTileContent(Board[i][j]);
         }
         System.out.println();
      }
   }

	// Below were experimental but I'm saving them at the moment

   public static void movePlayerUp(Board Board){
      
      
      if(Board.walkable(Board, Hero.getHeroYPos() - 1, Hero.getHeroXPos()) == true){
      
         Board.Board[Hero.getHeroYPos() - 1][Hero.getHeroXPos()] = new BoardTile(true);
         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(" ");
         Hero.setHeroYPos(Hero.getHeroYPos() - 1);
         
      } else {
         System.out.println("pressed w but can't move UP");
      
      }
      Board.printBoard(Board);
   
   }
   
   public static void movePlayerDown(Board Board){
      
      
      if(Board.walkable(Board, Hero.getHeroYPos() + 1, Hero.getHeroXPos()) == true){
      
         Board.Board[Hero.getHeroYPos() + 1][Hero.getHeroXPos()] = new BoardTile(true);
         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(" ");
         Hero.setHeroYPos(Hero.getHeroYPos() + 1);
         
      } else {
         System.out.println("pressed S but can't move DOWN");
      
      }
      Board.printBoard(Board);
   
   }
   
   public static void movePlayerRight(Board Board){
      
      
      if(Board.walkable(Board, Hero.getHeroYPos(), Hero.getHeroXPos() + 1) == true){
      
         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos() + 1] = new BoardTile(true);
         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(" ");
         Hero.setHeroXPos(Hero.getHeroXPos() + 1);
         
      } else {
         System.out.println("pressed D but can't move RIGHT");
      
      }
      Board.printBoard(Board);
   
   }
   
   
   public static void movePlayerLeft(Board Board){
      
      
      if(Board.walkable(Board, Hero.getHeroYPos(), Hero.getHeroXPos() - 1) == true){
      
         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos() - 1] = new BoardTile(true);
         Board.Board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(" ");
         Hero.setHeroXPos(Hero.getHeroXPos() - 1);
         
      } else {
         System.out.println("pressed A but can't move LEFT");
      
      }
      Board.printBoard(Board);
   
   }

   public static boolean walkable(Board Board, int y, int x){
      return BoardTile.walkable(Board.Board[y][x]);
   }
	//
	// public static void setTileAs(Board newBoard, int x, int y, int
	// newContent){
	// newBoards[x][y].tileContent = newContent;
	// }

}