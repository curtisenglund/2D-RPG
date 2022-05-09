import javax.swing.*;

import java.awt.Color;
import java.io.File;
import java.util.Scanner;


public class Level{
    

    static Tile[][] grid = null;




    //Base constructor, creates a basic level
    public Level()
    {
        grid = ReadLevelFile("map.txt");

    } 


    //Constructor that takes a file name as a parameter
    public Level(String lvlName)
    {
        grid = ReadLevelFile(lvlName);
    }

    


    
    //Create the 2D grid from the txt file
    public static Tile[][] ReadLevelFile(String lvlName)
    {

        Tile grid[][] = new Tile[10][10];


        Scanner mapReader = null;

        try{
            File mapFile = new File(lvlName);
            mapReader = new Scanner(mapFile);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        


        
        for (int i = 0; i < 10; i++)
        {

            String input = mapReader.nextLine();

            for (int d = 0; d < 10; d++)
            {
                

                switch (input.charAt(d))
                {
                    case 'X':
                        grid[d][i] = new Tile(Type.SOLID);
                        break;
                    
                    case '_':
                        grid[d][i] = new Tile(Type.EMPTY);
                        break;

                    case 'O':
                        grid[d][i] = new Tile(Type.CHEST);
                        break;

                }

            }

        }


        return grid;

        

    }




    //This bad boy takes in a JFrame as a parameter, and renders the current grid onto it
    public void Render(JFrame frame)
    {


        //Icons
        ImageIcon chestIcon = new ImageIcon("Art/Chest-icon.png");
        ImageIcon brickIcon = new ImageIcon("Art/brick wall.png");






        for (int i = 0; i < 10; i++)
        {

            for (int d = 0; d < 10; d++)
            {

                
                JPanel tileBox = new JPanel();
                tileBox.setVisible(true);


                switch (grid[d][i].type)
                {
                    case SOLID:
                        tileBox.setBackground(Color.magenta);

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



    //Parameters: grid coordinate in int[] format
    //Returns tile object
    public static Tile GetTile(int[] pos)
    {

        return grid[pos[0]][pos[1]];

    }





    //Parameters: grid coordinate in format of an int[] and Tile object
    //Sets the specified grid location to passed tile
    public static void SetTile(int[] pos, Tile tile)
    {
        grid[pos[0]][pos[1]] = tile;
    }

    //Parameters: grid coordinate in format of an int[] and Type enum (from tile class)
    //Sets the spe
    public static void SetTile(int[] pos, Type tileType)
    {
        grid[pos[0]][pos[1]] = new Tile(tileType);
    }


}
