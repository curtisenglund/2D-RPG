import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class HeroJLabel{
   public static JLabel heroLabel;
   
   public HeroJLabel(){
      this.heroLabel = new JLabel(new ImageIcon(new ImageIcon("player.png")
                                         .getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
      this.heroLabel.setVisible(true);
      this.heroLabel.setOpaque(true);
      this.heroLabel.setBounds(Hero.getHeroXPos() * 100, Hero.getHeroYPos() * 100, 100, 100);

   }
   
   public static JLabel getHeroLabel(){
      return heroLabel;
   }
}