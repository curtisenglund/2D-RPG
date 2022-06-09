import javax.swing.*;
import java.awt.*;


public class BoardTile {

   //private ImageIcon tileIcon;
   private JLabel tileIcon;
   private boolean isEmpty;// false if has player/enemy or wall
   private boolean hasPlayer;
   private boolean hasEnemy;
   
   
   //new boardtile
   public BoardTile(String tileType, int x, int y){
      switch (tileType){
         case "chest":
            this.tileIcon = new JLabel(new ImageIcon(new ImageIcon("Chest-icon.png")
                                              .getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
            this.tileIcon.setVisible(true);
            this.tileIcon.setOpaque(true);
            this.tileIcon.setBounds(x, y, 100, 100);
            
            this.isEmpty = false;
            
            this.hasPlayer = false;
            this.hasEnemy = false;
            
            break;
            
         case "brick":
            this.tileIcon = new JLabel(new ImageIcon(new ImageIcon("brick wall.png")
                                             .getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
            this.tileIcon.setVisible(true);
            this.tileIcon.setOpaque(true);
            this.tileIcon.setBounds(x, y, 100, 100);
                                         
            this.isEmpty = true;
            
            this.hasPlayer = false;
            this.hasEnemy = false;
            
            break;
            
         case "water":
            this.tileIcon = new JLabel(new ImageIcon(new ImageIcon("water.jpg")
                                             .getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
            this.tileIcon.setVisible(true);
            this.tileIcon.setOpaque(true);
            this.tileIcon.setBounds(x, y, 100, 100);
                                         
            this.isEmpty = false;
            
            this.hasPlayer = false;
            this.hasEnemy = false;
            
            break;
         
         case "sand":
            this.tileIcon = new JLabel(new ImageIcon(new ImageIcon("Sand.jpg")
                                             .getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
            this.tileIcon.setVisible(true);
            this.tileIcon.setOpaque(true);
            this.tileIcon.setBounds(x, y, 100, 100);
                                         
            this.isEmpty = true;
            
            this.hasPlayer = false;
            this.hasEnemy = false;
            
            break;
      }
   }
 
   public static boolean walkable(BoardTile tile){
      if(tile.isEmpty){
            return true;
      } else {
         return false;
      }
   }
   
   public boolean hasEnemy(BoardTile tile){
      return tile.hasEnemy;
   }
   
   
   public boolean hasPlayer(BoardTile tile){
      return tile.hasPlayer;
   }
   
   public static void setPlayer(BoardTile tile, boolean trueOrFalse){
      tile.hasPlayer = trueOrFalse;
      tile.isEmpty = !trueOrFalse;
   }
   
   public static void setEnemy(BoardTile tile, boolean trueOrFalse){
      tile.hasEnemy = trueOrFalse;
      tile.isEmpty = !trueOrFalse;
   }
   
   public static JLabel getIcon(BoardTile tile){
      return tile.tileIcon;
   }
	
   //unused atm
   public void assignTileContent(BoardTile tile, JLabel input){
      tile.tileIcon = input;
   }
}