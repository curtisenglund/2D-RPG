

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Color;

public class Window {
    




    JFrame frame = new JFrame();

    JLayeredPane layeredPane = new JLayeredPane();


    public JPanel backGroudPanel; 
    public JPanel entityPanel;
    public JPanel uiPanel;



    //Basic constructor
    public Window()
    {
        frame = MakeFrame();

        layeredPane.setBounds(0, 0, frame.getX(), frame.getY());

        frame.add(layeredPane);

        backGroudPanel = MakePanel();
        entityPanel = MakePanel();
        uiPanel = MakePanel();

        layeredPane.add(backGroudPanel, 0);
        layeredPane.add(entityPanel, 1);
        layeredPane.add(uiPanel, 2);


    }


    //Calls repaint on all UI components to update everything in the frame
    public void UpdateFrame()
    {
        //Repaint panels
        backGroudPanel.repaint();
        entityPanel.repaint();
        uiPanel.repaint();


        layeredPane.repaint();

        frame.revalidate();
        frame.repaint();

    }

    
    //Returns a simple JFrame with basic settings
    public JFrame MakeFrame()
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



    //Returns a simple panel with basic settings
    public JPanel MakePanel()
    {
        JPanel panel = new JPanel();

        panel.setBounds(0, 0, frame.getX(), frame.getY());
        panel.setVisible(true);


        return panel;

    }


}
