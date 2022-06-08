import java.util.Scanner;
import java.awt.*;
import javax.swing.*;


public class AlexMainMove {

   public static void main(String[] args) { 
      
      Stack<Integer> stack = new Stack<Integer>(3);
      Stack<Integer> temp = new Stack<Integer>(10);
      Stack<Integer> basura = new Stack<Integer>(10);
      stack.push(50);
      stack.push(20);
      stack.push(10);

      Window window = new Window();
   
   
      boolean endgame = false;
      
      Board board = new Board(10);
      Hero heros = new Hero(200);
      Enemy mob = new Enemy(200, 2, 3);
      Enemy mob1 = new Enemy(200, 4, 3);
      HeroJLabel heroJ = new HeroJLabel();
      Inventory inv = new Inventory();
      //EnemyJLabel enemyJ = new EnemyJLabel(mob);
      
      // Initializes new board
      char action = 'n';
      if (action == 'n') {
      
         Board.populateEmptyBoard(board, mob, mob1);
      
      }
   
      Window.UpdateFrame();

      
      //Player actions, right now just movement
      while (!endgame) {
         System.out.println("w - up\ns - down\na - left\nd - Right\nx - attack\nc - inventory");
      
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
            while (mob.getHealthEnemy() != 0 || heros.getHealthHero() != 0)
            {
               System.out.println("Heavy?(enter \"h\") or light attack (enter \"l\"?");
               String attack = input.next();
               mob.setHealthEnemy(attack, heros);
               heros.setHealthHero(mob);
               System.out.println("");
               if (mob.getHealthEnemy() <= 0 ){
                  System.out.println("Enemy Died");
                  break;
               }
               if (heros.getHealthHero() <= 0){
                  System.out.println("You Died");
                  break;
               }
            }
            
         } else if (action == 'c'){
            System.out.println("How much would you like to increase your health");
            int option = input.nextInt();
            inv.openInventory(option, stack, temp, basura, heros);
            System.out.println("Your Health = " + heros.getHealthHero());

         /* } else if (action == 'n'){
            System.out.println(Hero.attackChoice());
         */   
         } else {
            System.out.println("Invalid Command");
         }
      }
   }
}