import java.util.*;
import java.awt.*;
import javax.swing.*;

//test comment
public class GameMain {

   public static void main(String[] args) {      
      Stack<Integer> stack = new Stack<Integer>(3);
      Stack<Integer> temp = new Stack<Integer>(3);
      Stack<Integer> basura = new Stack<Integer>(3);
      stack.push(50);
      stack.push(20);
      stack.push(10);
      
      
      Window window = new Window();
   
   
      boolean endgame = false;
      
      Board board = new Board(10);
      
      Hero hero = new Hero();
      HeroJLabel heroJ = new HeroJLabel();
      Inventory inv = new Inventory();

      
      //right now manually adding enemies
      Enemy mob = new Enemy(200, 2, 3);
      Enemy mob1 = new Enemy(200, 4, 3);
      Enemy furthestMob = new Enemy(200, 20, 20);
      Enemy chest = new Enemy(200, 5, 3);
      chest.setChestLabel();
      
      
      EnemyPosHeap enemyHeap = new EnemyPosHeap(4, furthestMob);
      enemyHeap.insert(mob);
      enemyHeap.insert(mob1);
      enemyHeap.insert(chest);
   
      
      // Initializes new board
      char action = 'n';
      if (action == 'n') {
      
         Board.populateEmptyBoard(board, mob, mob1, chest);
      
      }
   
      window.RenderStats(hero.healthHero, 280, hero.stamina, 100);
      window.UpdateFrame();
      
      //Player actions
      while (!endgame) {
         System.out.println("w - up\ns - down\na - left\nd - Right\nx - attack\nc - use item");
      
         Scanner input = new Scanner(System.in);
         action = input.next().charAt(0);
      
         if (action == 'w'){
         
            Hero.movePlayer("w");
            
         } else if (action == 's'){
         
            Hero.movePlayer("s");       
            
         } else if (action == 'a'){
         
            Hero.movePlayer("a");       
         
         } else if (action == 'd'){
         
            Hero.movePlayer("d");       
         
         } else if (action == 'x'){
            while (mob.getHealthEnemy() != 0 || hero.getHealthHero() != 0)
            {
               System.out.println("Heavy?(enter \"h\") or light attack (enter \"l\"?");
               String attack = input.next();
               mob.setHealthEnemy(attack, hero);
                window.RenderStats(hero.healthHero, 280, hero.stamina, 100);

               hero.setHealthHero(mob);
               System.out.println("");

               if (mob.getHealthEnemy() <= 0 ){
                  System.out.println("Enemy Died");
                  break;
               }
               if (hero.getHealthHero() <= 0){
                  System.out.println("You Died");
                  System.out.println("GAME OVER");
                  break;
               }
            }
            
         } else if (action == 'c'){
            System.out.println("How much would you like to increase your health");
            System.out.println("[10]+ Health");
            System.out.println("[20]+ Health");
            System.out.println("[50]+ Health");
            int option = input.nextInt();
            inv.openInventory(option, stack, temp, basura, hero);
            System.out.println("Your Health = " + hero.getHealthHero());

         } else {
         
            System.out.println("Invalid Command");
            
         }
         mob.enemyMove(mob);
         mob1.enemyMove(mob1);
         enemyHeap.reHeap();
         enemyHeap.printClosestEnemy();
         
      }
   }
}