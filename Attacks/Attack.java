package Attacks;

import java.util.Random;
import java.util.Scanner;

public class Attack
{
    public static void main (String [] args)
    {
        Enemy mob = new Enemy();
        Hero hero = new Hero();
        Scanner input = new Scanner(System.in);
        
        while(mob.getHealthEnemy() > 0) {
	        System.out.println("What attack would you like to do");
	        String attack = input.nextLine();
	        //hero.setHealthHero();
	        mob.setHealthEnemy(attack);
	        System.out.println("Monster Health: " + mob.getHealthEnemy());
        	if (mob.getHealthEnemy() <= 0) {
	        	System.out.println("Monster Died");
        	}
        } // end of while loop
    }
}
