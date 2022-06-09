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
   
          
      layeredPane.add(backGroundPanel, Integer.valueOf(0));
      layeredPane.add(entityPanel, Integer.valueOf(1));
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