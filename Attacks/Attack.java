package Attacks;

import java.util.Scanner;

public class Attack
{
    public static void main (String [] args)
    {
        //Scanner input = new Scanner(System.in);
        Enemy jerry = new Enemy();
        Hero hero = new Hero();
        hero.setHealthHero();
        jerry.setHealthEnemy();
        System.out.println(jerry.getHealthEnemy());
    }
}
