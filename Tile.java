import javax.swing.ImageIcon;



public class Tile {



    Type type;
    ImageIcon tileIcon;
    
 


    public Tile(Type type)
    {
        this.type = type;

    }


    public void AssignIcon(int[] tilePos, Tile[][] grid)
    {

        if (this.tileIcon == null)
            return;

        

    }


}


enum Type{
    SOLID,
    EMPTY,
    CHEST,
}

