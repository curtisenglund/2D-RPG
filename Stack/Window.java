import javax.swing.*;
import java.awt.*;


public class Window {



   public static void main(String[] args) {

      Window window = new Window();

   }

   public static JFrame frame;
   public static JPanel backGroundPanel; 
   public static JPanel entityPanel;
   public static JLabel entityLabel;

   
   public JPanel uiPanel;

   public static JLayeredPane layeredPane;

    //Basic constructor
   public Window()
   {
      frame = new JFrame();
      frame = MakeFrame();
        
      layeredPane = new JLayeredPane();
      frame.setLayout(null);
      layeredPane.setBounds(0, 0, 1000, 1000);
         
      backGroundPanel = MakePanel();
      backGroundPanel.setBounds(0, 0, 1000, 1000);
      backGroundPanel.setBackground(Color.GRAY);
      
      entityPanel = MakePanel();
      entityPanel.setBounds(0, 0, 1000, 1000);
      entityPanel.setOpaque(false);


      uiPanel = MakePanel();
      uiPanel.setBounds(0, 0, 1000, 1000);
      uiPanel.setBackground(Color.GRAY);
   
   
      
//    //    test label
//       JLabel backGroundTile = new JLabel(new ImageIcon(new ImageIcon("brick wall.png")
//                                    .getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
//       backGroundTile.setBounds(50, 50, 460, 440);
//       backGroundTile.setBackground(Color.RED);
//       backGroundTile.setIcon(new ImageIcon("brick wall.png"));
//       backGroundPanel.add(backGroundTile);
//    
//       entityLabel = MakeLabel();
//       entityLabel.setBounds(Hero.getHeroXPos() * 100, Hero.getHeroYPos() * 100, 100, 100);
//       entityLabel.setBackground(Color.RED);
//       entityLabel.setIcon(new ImageIcon("player.png"));
          
      layeredPane.add(backGroundPanel, Integer.valueOf(0));
      layeredPane.add(entityPanel, Integer.valueOf(1));
//       entityPanel.add(entityLabel, Integer.valueOf(2));
      frame.add(layeredPane);
   }


    //Calls repaint on all UI components to update everything in the frame
   public static void UpdateFrame(){
      backGroundPanel.repaint();
      entityPanel.repaint();   
      frame.revalidate();
      frame.repaint();
   
   }

    //Returns a simple JFrame with basic settings
   public JFrame MakeFrame(){
      JFrame frame = new JFrame();
      frame.setTitle("2D Game project");
      frame.setSize(1000, 1000);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setBackground(Color.BLUE);
      frame.setLayout(null);
      frame.setResizable(false);
   
      return frame;
   }

    //Returns a simple panel with basic settings
   public JPanel MakePanel()
   {
      JPanel panel = new JPanel();
      panel.setVisible(true);
      panel.setOpaque(true);
      panel.setLayout(null);
   
      return panel;
   }
   
   public JLabel MakeLabel()
   {
      JLabel label = new JLabel();
      label.setVisible(true);
      label.setOpaque(true);
   
      return label;
   }
}