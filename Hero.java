public class Hero
{
    private int healthH = 100;
    private int damageH = 50;



    public int getHealthHero()
    {
        return healthH;
    }

    public void setHealthHero() {
        this.healthH = healthH-damageH;
    }

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
