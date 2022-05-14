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
               board.Board[i][j] = new BoardTile("^^");
            
            } else if ( i == board.Board.length - 1){
               board.Board[i][j] = new BoardTile("__");
            } else if ( j == 0 || j == board.Board.length - 1){
               board.Board[i][j] = new BoardTile("| ");
            } else {
              // int randomTile = rand.nextInt(10);
              // if (randomTile <= 8){
                  board.Board[i][j] = new BoardTile("  ");
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

	public static void movePlayerUp(Board Board, int x, int y){
      Board.Board[y][x] = new BoardTile("  ");
      Board.Board[y][x - 1] = new BoardTile(true);
      Hero.setHeroXPos(y - 1);

	}

	public static boolean getContent(Board Board, int x, int y){
	   return BoardTile.getTileContent(Board.Board[y][x]);
	}
	//
	// public static void setTileAs(Board newBoard, int x, int y, int
	// newContent){
	// newBoards[x][y].tileContent = newContent;
	// }

}