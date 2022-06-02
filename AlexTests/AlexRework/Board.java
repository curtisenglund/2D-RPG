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
   public static void populateEmptyBoard(Board board, Enemy mob, Enemy mob1) {
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
   
   //********** add enemies to ADT for each in adt do this
      BoardTile.setEnemy(BoardTileArray[mob.getEnemyYPos()][mob.getEnemyXPos()], true);
      Window.entityPanel.add(mob.getEnemyLabel(), Integer.valueOf(2));
      
      //for mob 2
      BoardTile.setEnemy(BoardTileArray[mob1.getEnemyYPos()][mob1.getEnemyXPos()], true);
      Window.entityPanel.add(mob1.getEnemyLabel(), Integer.valueOf(2));
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
   
//    public static void renderBoard(Board board, Window window) {
//       for (int i = 0; i < board.BoardTileArray.length; i++) {
//          for (int j = 0; j < board.BoardTileArray[i].length; j++) {
//            window.addTileToBackground(board.BoardTileArray[i][j], i* 60, j * 60);
//          }
//       }
//    }
   




//    public static void movePlayerUp(BoardTile[][] board, Window window){
//       
//       if(walkable(board, Hero.getHeroYPos() - 1, Hero.getHeroXPos()) == true){
//          System.out.println("we walked up");
// 
//       
//          board[Hero.getHeroYPos() - 1][Hero.getHeroXPos()] = new BoardTile("player", Hero.getHeroYPos() * 100, Hero.getHeroXPos() * 100));
//          window.backGroundPanel.add(BoardTile("player", Hero.getHeroXPos() * 100, Hero.getHeroYPos() * 100));
//          window.backGroundPanel.revalidate();
//          window.backGroundPanel.repaint();
// 
//          board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(null);
//          Hero.setHeroYPos(Hero.getHeroYPos() - 1);
//          
//       } else {
//          System.out.println("pressed w but can't move UP");
//       }
//    }














               //OLD MOVEMENT 5-26 MOVING TO NOT BOARD BASED MOVEMENT.
	// Below is Player movement based on WASD.
   // Kinda ugly could clean up/consolidate based on keyed input

//    public static void movePlayerUp(BoardTile[][] board, Window window){
//       
//       if(walkable(board, Hero.getHeroYPos() - 1, Hero.getHeroXPos()) == true){
//          System.out.println("we walked up");
// 
//       
//          board[Hero.getHeroYPos() - 1][Hero.getHeroXPos()] = new BoardTile("player", Hero.getHeroYPos() * 100, Hero.getHeroXPos() * 100));
//          window.backGroundPanel.add(BoardTile("player", Hero.getHeroXPos() * 100, Hero.getHeroYPos() * 100));
//          window.backGroundPanel.revalidate();
//          window.backGroundPanel.repaint();
// 
//          board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(null);
//          Hero.setHeroYPos(Hero.getHeroYPos() - 1);
//          
//       } else {
//          System.out.println("pressed w but can't move UP");
//       }
//    }
//    
//    public static void movePlayerDown(BoardTile[][] board){
//       
//       
//       if(walkable(board, Hero.getHeroYPos() + 1, Hero.getHeroXPos()) == true){
//       
//          board[Hero.getHeroYPos() + 1][Hero.getHeroXPos()] = new BoardTile("player", Hero.getHeroYPos() * 100, Hero.getHeroXPos() * 100));
//          board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(null);
//          Hero.setHeroYPos(Hero.getHeroYPos() + 1);
//          
//       } else {
//          System.out.println("pressed S but can't move DOWN");
//       }
//    }
//    
//    public static void movePlayerRight(BoardTile[][] board){
//    
//       if(walkable(board, Hero.getHeroYPos(), Hero.getHeroXPos() + 1) == true){
//       
//          board[Hero.getHeroYPos()][Hero.getHeroXPos() + 1] = new BoardTile("player", Hero.getHeroYPos() * 100, Hero.getHeroXPos() * 100));
//          board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(null);
//          Hero.setHeroXPos(Hero.getHeroXPos() + 1);
//       
//       } else {
//          System.out.println("pressed D but can't move RIGHT");
//       }
//    }
//    
//    
//    public static void movePlayerLeft(BoardTile[][] board){
//    
//       if(walkable(board, Hero.getHeroYPos(), Hero.getHeroXPos() - 1) == true){
//       
//          board[Hero.getHeroYPos()][Hero.getHeroXPos() - 1] = new BoardTile(playerTile);
//          board[Hero.getHeroYPos()][Hero.getHeroXPos()] = new BoardTile(null);
//          Hero.setHeroXPos(Hero.getHeroXPos() - 1);
//          
//       } else {
//          System.out.println("pressed A but can't move LEFT");
//       }
//    }


   //returns true if tile is walkable. IE doesn't have a wall or character on it.

   
 //   public static int[][] checkForMeleeRange(){
//       int[][] enemyCoordArray = new int[][];
//       int x = Hero.getHeroXPos();
//       int y = Hero.getHeroYPos();
//    }
}