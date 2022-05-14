import java.util.*;

public class AlexMainMove {

   public static void main(String[] args) {
      boolean endgame = false;
   
      Board Board = new Board(10);
      Hero Hero = new Hero(100, 10);
   
      char move = 'n';// creates new board
      if (move == 'n') {
         Board.populateEmptyBoard(Board);
         Board.printBoard(Board);
      }
   
      while (!endgame) {
         System.out.println("W - up\nS - down\nA - left\nD - Right");
      
         Scanner input = new Scanner(System.in);
         move = input.next().charAt(0);
      
         if (move == 'w') {
            Board.movePlayerUp(Board);
         
         } else if (move == 's') {
            Board.movePlayerDown(Board);
            
         } else if (move == 'a') {
            Board.movePlayerLeft(Board);
         } else if (move == 'd') {
            Board.movePlayerRight(Board);
         }
      }
   }
}