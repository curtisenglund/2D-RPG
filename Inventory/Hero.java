import java.util.Random;
import javax.swing.*;
import javax.xml.stream.events.EndElement;

import java.awt.*;

public class Hero
{
   
   private int healthHero = 200;

   //attacks
   private int lightAttack = 50;
   private int heavyAttack = 100;

   private int stamina = 100;
   private int turn;

   public Hero(int health){
      this.healthHero = health;

   }

   public static int attackNumber (int range)
   {
      int min = 10;
      Random r = new Random();
      return r.nextInt((range - min) + min);
   }

   public static int attackChoice ()
   {
      Random r = new Random();
      return r.nextInt((3 - 2) + 1);
   }

   public int getHealthHero()
   {
      return healthHero;
   }


   public void setHealthHero(Enemy mob) {
      if (stamina >= 10) {
         if (attackChoice() == 0) {
            if (stamina >= 10) {
               this.healthHero = healthHero-attackNumber(lightAttack);
               stamina -= 10;
               turn++;
            } // end of if
            if (stamina <= 10) {
               System.out.println("Not Enough Stamina");
            }
         } // end of if
         else if (attackChoice() == 1) {
            if (stamina >= 50) {
               this.healthHero = healthHero-attackNumber(heavyAttack);
               stamina -= 50;
               turn++;
            }
            if (stamina < 50) {
               System.out.println("Not Enough Stamina");
            }
         } // end of if else
         System.out.println("Enemy Health: " + mob.getHealthEnemy());
         System.out.println("Stamina: " + stamina);
         System.out.println("Turn: "+ turn);
      }
      if (turn % 3 == 0) {
         stamina += 30;
      }
   } // end of setHealthHero method */

   public void setHealthItem (int x){
      healthHero += x;
   }

   public void setStaminaItem (int x){
      stamina += x;
   }

    //Player Position
   private static int xCoordinate = 7;
   private static int yCoordinate = 7;


   public static int getHeroXPos(){
      return xCoordinate;
   }

   public static int getHeroYPos(){
      return yCoordinate;
   }

   public static void setHeroYPos(int y){
      yCoordinate = y;
   }

   public static void setHeroXPos(int x){
      xCoordinate = x;
   }
    
    //NEW MOVEMENT STUFF 5-26
   public static void movePlayer(String directionWASD){
      
      switch (directionWASD){
         case "w":
         
            if(Board.walkable(Board.getBoardArray(), yCoordinate - 1, xCoordinate) == true){
               BoardTile.setPlayer(Board.getBoardArray()[yCoordinate - 1][xCoordinate], true);
               BoardTile.setPlayer(Board.getBoardArray()[yCoordinate][xCoordinate], false);
               yCoordinate--;
               
               Window.entityPanel.remove(HeroJLabel.getHeroLabel());
               HeroJLabel heroJ = new HeroJLabel();
               Window.entityPanel.add(HeroJLabel.getHeroLabel());
               Window.UpdateFrame();
               
               break;
               
            } else {
               System.out.println("pressed w but can't move UP");
               break;
            }
            
         case "s":
         
            if(Board.walkable(Board.getBoardArray(), yCoordinate + 1, xCoordinate) == true){
               BoardTile.setPlayer(Board.getBoardArray()[yCoordinate + 1][xCoordinate], true);
               BoardTile.setPlayer(Board.getBoardArray()[yCoordinate][xCoordinate], false);
               yCoordinate++;
               
               Window.entityPanel.remove(HeroJLabel.getHeroLabel());
               HeroJLabel heroJ = new HeroJLabel();
               Window.entityPanel.add(HeroJLabel.getHeroLabel());
               Window.UpdateFrame();
               
               break;
               
            } else {
               System.out.println("pressed s but can't move DOWN");
               break;
            }
            
         case "a":
         
            if(Board.walkable(Board.getBoardArray(), yCoordinate, xCoordinate - 1) == true){
               BoardTile.setPlayer(Board.getBoardArray()[yCoordinate][xCoordinate - 1], true);
               BoardTile.setPlayer(Board.getBoardArray()[yCoordinate][xCoordinate], false);
               xCoordinate--;
               
               Window.entityPanel.remove(HeroJLabel.getHeroLabel());
               HeroJLabel heroJ = new HeroJLabel();
               Window.entityPanel.add(HeroJLabel.getHeroLabel());
               Window.UpdateFrame();
               
               break;
               
            } else {
               System.out.println("pressed a but can't move LEFT");
               break;
            }
            
         case "d":
         
            if(Board.walkable(Board.getBoardArray(), yCoordinate, xCoordinate + 1) == true){
               BoardTile.setPlayer(Board.getBoardArray()[yCoordinate][xCoordinate + 1], true);
               BoardTile.setPlayer(Board.getBoardArray()[yCoordinate][xCoordinate], false);
               xCoordinate++;
               
               Window.entityPanel.remove(HeroJLabel.getHeroLabel());
               HeroJLabel heroJ = new HeroJLabel();
               Window.entityPanel.add(HeroJLabel.getHeroLabel());
               Window.UpdateFrame();
               
               break;
               
            } else {
               System.out.println("pressed d but can't move RIGHT");
               break;
            }
      } 
   }
}