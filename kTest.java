import java.awt.Color;

import javax.swing.*;

public class test 
{



    public static void main(String[] args)
    {





        int[] pos = new int[] {3, 4};




        JFrame frame = MakeFrame();



        Level level = new Level();



        System.out.println("LOADING MAP");
        
        level.Render(frame);
       
        System.out.println("\nMap loaded");



        
        
        JLabel playerLable = MakePlayerLabel();



        playerLable.setBounds(pos[0] * 100,pos[1] * 100, 100,100);

        
        playerLable.repaint();
        frame.add(playerLable);
        
        frame.repaint();


        

        //This is how to properly retreive 
        //System.out.print(Level.GetTile(pos).type);





    }



    //Returns a basic JLabel for the player
    public static JLabel MakePlayerLabel()
    {

        ImageIcon playerIcon = new ImageIcon("Art/player.png");


        JLabel playerLable = new JLabel();


        playerLable.setVisible(true);
        playerLable.setIcon(playerIcon);
        playerLable.setBackground(Color.magenta);

        return playerLable;

    }


    //Returns a simple JFrame with basic settings
    public static JFrame MakeFrame()
    {
        JFrame frame = new JFrame();
        frame.setTitle("2D Game project");
        frame.setSize(1015,1015);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.MAGENTA);
        frame.setLayout(null);
        frame.setResizable(false);

        return frame;
    }





}













