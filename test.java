import java.awt.Color;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;

public class test {



    public static void main(String[] args) throws InterruptedException
    {

        JFrame frame = new JFrame();
        frame.setTitle("2D Game project");
        frame.setSize(1000,1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.MAGENTA);
        frame.setLayout(null);
        frame.setResizable(false);

        

        int[] pos = new int[] {100, 100};

        Tile[][] grid = new Tile[10][10];


        Scanner mapReader = null;






        grid = ReadMapFile();


        System.out.println("LOADING MAP");

        
        RenderMapFile(frame, grid);
       
        System.out.println("\nMap loaded");





        

    }



    public static Tile[][] ReadMapFile()
    {

        Tile grid[][] = new Tile[10][10];


        Scanner mapReader = null;

        try{
            File mapFile = new File("map.txt");
            mapReader = new Scanner(mapFile);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        

        //Create the 2D grid from the txt file
        for (int i = 0; i < 10; i++)
        {

            String input = mapReader.nextLine();

            for (int d = 0; d < 10; d++)
            {
                

                switch (input.charAt(d))
                {
                    case 'X':
                        grid[d][i] = Tile.SOLID;
                        break;
                    
                    case '_':
                        grid[d][i] = Tile.EMPTY;
                        break;

                    case 'O':
                        grid[d][i] = Tile.CHEST;
                        break;

                }

            }

        }


        return grid;

        

    }


    public static void RenderMapFile(JFrame frame, Tile[][] grid)
    {


        //Icons
        ImageIcon chestIcon = new ImageIcon("Chest-icon.png");
        ImageIcon brickIcon = new ImageIcon("brick wall.png");





        for (int i = 0; i < 10; i++)
        {

            for (int d = 0; d < 10; d++)
            {

                
                JPanel tileBox = new JPanel();

                tileBox.setVisible(true);

                switch (grid[d][i])
                {
                    case SOLID:
                        tileBox.setBackground(Color.BLACK);

                        JLabel brickWall = new JLabel();
                        brickWall.setIcon(brickIcon);
                        brickWall.setBounds(0,0,100,100);

                        tileBox.add(brickWall);
                        break;
                    
                    case EMPTY:
                        tileBox.setBackground(Color.GRAY);
                        break;


                    case CHEST:
                        tileBox.setBackground(Color.GRAY);

                        JLabel chest = new JLabel();
                        chest.setIcon(chestIcon);
                        chest.setBounds(0,0,100,100);

                        tileBox.add(chest);
                        break;

                }


                tileBox.setBounds(d*100, i*100, 100, 100);
                frame.add(tileBox);


                System.out.print("-");

            }
            

        }


        frame.repaint();
    }





}








enum Tile{
    SOLID,
    EMPTY,
    CHEST
}

