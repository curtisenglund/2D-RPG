package Attacks;

import java.util.Random;

public class Hero
{
    private int healthEnemy = 200;
    private int lightAttack = 50;
    private int heavyAttack = 100;

    private int stamina = 100;
    private int turn; 

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

    //Player Position
    private int xCoordinate = 5;
    private int yCoordinate = 5;


    public int getHeroXPos(){
        return xCoordinate;
    }

    public int getHeroYPos(){
        return yCoordinate;
    }

    public void setHeroYPos(int y){
        yCoordinate = y;
    }

    public void setHeroxPos(int x){
        xCoordinate = x;
    }
}
