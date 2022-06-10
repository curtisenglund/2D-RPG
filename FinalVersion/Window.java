import javax.swing.*;
import java.awt.*;


public class Window {

   public static void main(String[] args) {
      Window window = new Window();
   }

   public static JFrame frame;
   public static JPanel backGroundPanel; 
   public static JPanel entityPanel;
   public JPanel UIPanel;
   public JLabel UILabel;

   

   public JLayeredPane layeredPane;



   //Health and stamina bar
   public JLabel staminaBar;
   public JLabel staminaBGround;

   public JLabel healthBar;
   public JLabel healthBGround;


    //Basic constructor
   public Window()
   {
      frame = new JFrame();
      frame = MakeFrame();


      staminaBar = MakeLabel();
      staminaBGround = MakeLabel();

      staminaBar.setBackground(Color.GREEN);
      staminaBar.setHorizontalAlignment(JLabel.LEFT);
      staminaBar.setBounds(30, 120, 200, 30);

      staminaBGround.setBackground(Color.GRAY);
      staminaBar.setHorizontalAlignment(JLabel.LEFT);
      staminaBGround.setBounds(30, 120, 200, 30);
      

      healthBar = MakeLabel();
      healthBGround = MakeLabel();

      healthBar.setBackground(Color.RED);
      healthBar.setBounds(30, 60, 200, 30);

      healthBGround.setBackground(Color.GRAY);
      healthBGround.setBounds(30, 60, 200, 30);




      layeredPane = new JLayeredPane();
      frame.setLayout(null);
      layeredPane.setBounds(0, 0, 1000, 1000);
         
      backGroundPanel = MakePanel();
      backGroundPanel.setBounds(0, 0, 1000, 1000);
      backGroundPanel.setBackground(Color.GRAY);
      
      entityPanel = MakePanel();
      entityPanel.setBounds(0, 0, 1000, 1000);
      entityPanel.setOpaque(false);

      UIPanel = MakePanel();
      UIPanel.setBounds(0, 0, 1000, 1000);
      UIPanel.setOpaque(false);
   
          
      layeredPane.add(backGroundPanel, Integer.valueOf(0));
      layeredPane.add(entityPanel, Integer.valueOf(1));
      layeredPane.add(UIPanel, Integer.valueOf(2));


      
      
      UIPanel.add(healthBar);
      UIPanel.add(healthBGround);


      UIPanel.add(staminaBar);
      UIPanel.add(staminaBGround);



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


   public void RenderStats(int health, int healthMax, int stamina, int staminaMax)
   {

      healthBar.setSize((int) ((float) health/healthMax * 200f), 30);
      healthBar.setText(Integer.toString(health));

      staminaBar.setSize( (int) ((float) stamina/staminaMax * 200f), 30);
      staminaBar.setText(Integer.toString(stamina));

      healthBar.repaint();

      staminaBar.repaint();


      UIPanel.validate();
      UIPanel.revalidate();
      UIPanel.repaint();

      frame.repaint();

   }


}