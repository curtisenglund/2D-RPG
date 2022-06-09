import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Enemy
{

   private int healthEnemy;
   private int lightAttack = 50;
   private int heavyAttack = 100;

   private int stamina = 100;
   private int turn;
   
   private int xCoordinate;
   private int yCoordinate;
   
   //distance to hero used in EnemyPosHeap
   public double distanceToHero;
   
   public JLabel label;
   public JLabel chestLabel;
   
   

   public Enemy(int health, int x, int y){
      this.healthEnemy = health;
   
      this.xCoordinate = x;
      this.yCoordinate = y;
      
      updateDistance();
      
      
      this.label = new JLabel(new ImageIcon(new ImageIcon("enemy.gif")
                                         .getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
      this.label.setVisible(true);
      this.label.setOpaque(false);
      this.label.setBounds(xCoordinate * 100, yCoordinate * 100, 100, 100);
      
   }
   
   public JLabel createNewJLabel(Enemy mob){
         
      mob.label = new JLabel(new ImageIcon(new ImageIcon("enemy.gif")
                                         .getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
      mob.label.setVisible(true);
      mob.label.setOpaque(false);
      mob.label.setBounds(xCoordinate * 100, yCoordinate * 100, 100, 100);
      
      return mob.label;
   }
   
   public JLabel getEnemyLabel(){
      return label;
   }
   
   public void setChestLabel(){
      this.label = new JLabel(new ImageIcon(new ImageIcon("Chest-icon.png")
                                         .getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
      
      this.label.setVisible(true);
      this.label.setOpaque(false);
      this.label.setBounds(xCoordinate * 100, yCoordinate * 100, 100, 100);
   }

   public static int attackNumber (int range)
   {
      int min = 10;
      Random r = new Random();
      return r.nextInt((range - min) + min);
   }

   public int getHealthEnemy()
   {
      return healthEnemy;
   }

   public void setHealthEnemy(String attack) {
      if (stamina >= 10) {
         if (attack.equals("l")) {
            if (stamina >= 10) {
               this.healthEnemy = healthEnemy-attackNumber(lightAttack);
               stamina -= 10;
               turn++;
            } // end of if
            if (stamina <= 10) {
               System.out.println("Not Enough Stamina");
            }
         } // end of if
         else if (attack.equals("h")) {
            if (stamina >= 50) {
               this.healthEnemy = healthEnemy-attackNumber(heavyAttack);
               stamina -= 50;
               turn++;
            }
            if (stamina < 50) {
               System.out.println("Not Enough Stamina");
            }
         } // end of if else
         System.out.println("Stamina: " + stamina);
         System.out.println("Turn: "+ turn);
      }
      if (turn % 3 == 0) {
         stamina += 30;
      }
   } // end of setHealthEnemy method
    
       
        //Enemy Position



   public int getEnemyXPos(){
      return xCoordinate;
   }

   public int getEnemyYPos(){
      return yCoordinate;
   }

   public void setEnemyYPos(int y){
      yCoordinate = y;
   }

   public void setEnemyXPos(int x){
      xCoordinate = x;
   }
   
   //update distance to hero
   public void updateDistance(){
      this.distanceToHero = Math.sqrt((this.yCoordinate - Hero.getHeroYPos()) * (this.yCoordinate - Hero.getHeroYPos())
                      + (this.xCoordinate - Hero.getHeroXPos()) * (this.xCoordinate - Hero.getHeroXPos()));
   }
   
   
   

    
      //Enemy Movement very basic at the moment 6-1
      //Could create helper methods to clean this up
   public void enemyMove(Enemy mob){
      int playerYpos = Hero.getHeroYPos();
      int playerXpos = Hero.getHeroXPos();
      int enemyYpos = getEnemyYPos();
      int enemyXpos = getEnemyXPos();
      
      
      //player is below enemy
      if (playerYpos - 1 > enemyYpos && Board.walkable(Board.getBoardArray(), yCoordinate + 1, xCoordinate) == true){
      
         BoardTile.setEnemy(Board.getBoardArray()[yCoordinate + 1][xCoordinate], true);
         BoardTile.setEnemy(Board.getBoardArray()[yCoordinate][xCoordinate], false);
         yCoordinate++;
               
         Window.entityPanel.remove(this.label);
         createNewJLabel(mob);
         Window.entityPanel.add(this.label);
         Window.UpdateFrame();
            
      } else if (playerYpos + 1 < enemyYpos && Board.walkable(Board.getBoardArray(), yCoordinate - 1, xCoordinate) == true){
      
         BoardTile.setEnemy(Board.getBoardArray()[yCoordinate - 1][xCoordinate], true);
         BoardTile.setEnemy(Board.getBoardArray()[yCoordinate][xCoordinate], false);
         yCoordinate--;
               
         Window.entityPanel.remove(this.label);
         createNewJLabel(mob);
         Window.entityPanel.add(this.label);
         Window.UpdateFrame();
            
      } else if (playerXpos - 1 > enemyXpos && Board.walkable(Board.getBoardArray(), yCoordinate, xCoordinate + 1) == true){
      
         BoardTile.setEnemy(Board.getBoardArray()[yCoordinate][xCoordinate + 1], true);
         BoardTile.setEnemy(Board.getBoardArray()[yCoordinate][xCoordinate], false);
         xCoordinate++;
               
         Window.entityPanel.remove(this.label);
         createNewJLabel(mob);
         Window.entityPanel.add(this.label);
         Window.UpdateFrame();
            
      } else if (playerXpos + 1 < enemyXpos && Board.walkable(Board.getBoardArray(), yCoordinate, xCoordinate - 1) == true){
      
         BoardTile.setEnemy(Board.getBoardArray()[yCoordinate][xCoordinate - 1], true);
         BoardTile.setEnemy(Board.getBoardArray()[yCoordinate][xCoordinate], false);
         xCoordinate--;
               
         Window.entityPanel.remove(this.label);
         createNewJLabel(mob);
         Window.entityPanel.add(this.label);
         Window.UpdateFrame();
      } 
      mob.updateDistance();
      //add an else attack here?
         
   }
}