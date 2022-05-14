public class Hero{
    private int health;
    private int damage;


   public Hero(int health, int damage){
      this.health = health;
      this.damage = damage;
   }
   

    public int getHealthHero(){
        return health;
    }

    public void setHealthHero(){
        this.health = health-damage;
    }

  //Player Position
    private static int xCoordinate = 5;
    private static int yCoordinate = 5;


    public int getHeroXPos(){
        return this.xCoordinate;
    }

    public int getHeroYPos(){
        return this.yCoordinate;
    }

    public static void setHeroYPos(int y){
        yCoordinate = y;
    }

    public static void setHeroXPos(int x){
        xCoordinate = x;
    }
}