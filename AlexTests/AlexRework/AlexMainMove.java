import java.util.*;
import java.awt.*;
import javax.swing.*;


public class AlexMainMove {

   public static void main(String[] args) {      
      Window window = new Window();
   
   
      boolean endgame = false;
      
      Board board = new Board(10);
      Hero hero = new Hero();
      Enemy mob = new Enemy(200, 2, 3);
      Enemy mob1 = new Enemy(200, 4, 3);
      HeroJLabel heroJ = new HeroJLabel();
   //      EnemyJLabel enemyJ = new EnemyJLabel(mob);
      
      // Initializes new board
      char action = 'n';
      if (action == 'n') {
      
         Board.populateEmptyBoard(board, mob, mob1);
      
      }
   
      window.UpdateFrame();
      //Player actions, right now just movement
      while (!endgame) {
         System.out.println("w - up\ns - down\na - left\nd - Right\nx - attack");
      
         Scanner input = new Scanner(System.in);
         action = input.next().charAt(0);
      
         if (action == 'w'){
         
            Hero.movePlayer("w");
            mob.enemyMove(mob);
            mob1.enemyMove(mob1);
         
            
         } else if (action == 's'){
         
            Hero.movePlayer("s");
            mob.enemyMove(mob);
            mob1.enemyMove(mob1);
         
            
         } else if (action == 'a'){
         
            Hero.movePlayer("a");
            mob.enemyMove(mob);
            mob1.enemyMove(mob1);
         
         
         } else if (action == 'd'){
         
            Hero.movePlayer("d");
            mob.enemyMove(mob);
            mob1.enemyMove(mob1);
         
         
         } else if (action == 'x'){
         
            System.out.println("Heavy?(enter \"h\") or light attack (enter \"l\"?");
            String attack = input.next();
            mob.setHealthEnemy(attack);
            System.out.println("Enemy health = " + mob.getHealthEnemy());
            
         } else {
         
            System.out.println("Invalid Command");
            
         }
      }
   }
}