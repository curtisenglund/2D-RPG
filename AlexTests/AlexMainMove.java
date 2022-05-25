import java.util.*;
import java.awt.*;

public class AlexMainMove {

   public static void main(String[] args) {      
      
      
      boolean endgame = false;
   
      Board Board = new Board(12);
      Hero Hero = new Hero();
      Enemy Mob = new Enemy();
      
      // Initializes new board
      char action = 'n';
      if (action == 'n') {
         Board.populateEmptyBoard(Board);
         Board.printBoard(Board);
      }
      
      //Player actions, right now just actionment
      while (!endgame) {
         System.out.println("w - up\ns - down\na - left\nd - Right\nx - attack");
      
         Scanner input = new Scanner(System.in);
         action = input.next().charAt(0);
      
         if (action == 'w'){
            Board.movePlayerUp(Board);
         } else if (action == 's'){
            Board.movePlayerDown(Board);
         } else if (action == 'a'){
            Board.movePlayerLeft(Board);
         } else if (action == 'd'){
            Board.movePlayerRight(Board);
         } else if (action == 'x'){
            //should make Hero and Enemy objects with parameters?
            System.out.println("Heavy?(enter \"h\") or light attack (enter \"l\"?");
            String attack = input.next();
            Mob.setHealthEnemy(attack);
            System.out.println("Enemy health = " + Mob.getHealthEnemy());
         } else {
            System.out.println("Invalid Command");
         }
      }
   }
}