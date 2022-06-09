import java.util.*;
import java.awt.*;
import javax.swing.*;


public class Board {

   public static BoardTile[][] BoardTileArray; //make private and get set methods?
   
   public Board(int size) {
      BoardTileArray = new BoardTile[size][size];
   }
   
   public static BoardTile[][] getBoardArray(){
      return BoardTileArray;
   }
   
   //populate array[][] with BoardTiles
   public static void populateEmptyBoard(Board board, Enemy mob, Enemy mob1, Enemy mob2) {
      for (int i = 0; i < board.BoardTileArray.length; i++) {
         for (int j = 0; j < board.BoardTileArray[i].length; j++) {
            if (i == 0){
               board.BoardTileArray[i][j] = new BoardTile("water", i * 100, j * 100);
            } else if ( i == BoardTileArray.length - 1){
               board.BoardTileArray[i][j] = new BoardTile("water", i * 100, j * 100);
            } else if ( j == 0 || j == BoardTileArray.length - 1){
               board.BoardTileArray[i][j] = new BoardTile("water", i * 100, j * 100);
            } else {
               board.BoardTileArray[i][j] = new BoardTile("sand", i * 100, j * 100);
            }
            Window.backGroundPanel.add(BoardTile.getIcon(board.BoardTileArray[i][j]));
         }
      }
      //for player and enemy starting positions
      BoardTile.setPlayer(BoardTileArray[Hero.getHeroYPos()][Hero.getHeroXPos()], true);
      Window.entityPanel.add(HeroJLabel.getHeroLabel(), Integer.valueOf(2));
   
   //Eventually add enemies to ADT. For each in adt do this
      BoardTile.setEnemy(BoardTileArray[mob.getEnemyYPos()][mob.getEnemyXPos()], true);
      Window.entityPanel.add(mob.getEnemyLabel(), Integer.valueOf(2));
      
      //for mob 2
      BoardTile.setEnemy(BoardTileArray[mob1.getEnemyYPos()][mob1.getEnemyXPos()], true);
      Window.entityPanel.add(mob1.getEnemyLabel(), Integer.valueOf(2));
      
      //mob 3
      BoardTile.setEnemy(BoardTileArray[mob2.getEnemyYPos()][mob2.getEnemyXPos()], true);
      Window.entityPanel.add(mob2.getEnemyLabel(), Integer.valueOf(2));
   }


   public static boolean walkable(BoardTile[][] boardTileArray, int y, int x){
      if (BoardTile.walkable(boardTileArray[y][x])){
         return true;
      } else {
         return false;
      }
   }
   
   public static JLabel getTileIcon(BoardTile[][] board, int y, int x){
      return BoardTile.getIcon(board[y][x]);
   }
//    public static void printBoard(BoardTile[][] board) {
//       for (int i = 0; i < board.length; i++) {
//          for (int j = 0; j < board[i].length; j++) {
//             BoardTile.printTileContent(board[i][j]);
//          }
//          System.out.println();
//       }
//    }
}