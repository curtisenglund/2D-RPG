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
   private static int yCoordinate = 5; // Array Coords look like Array[y][x]


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
}