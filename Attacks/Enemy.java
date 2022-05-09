package Attacks; 

public class Enemy
{
    private int healthE = 50;
    private int damageE = 50;

    public int getHealthEnemy()
    {
        return healthE;
    }

    public void setHealthEnemy() {
        this.healthE = healthE-damageE;
    }
}
