package BackGround;

import Bird_Mechanic.Drone;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;

public class BackGround extends JFrame  {

    final String TITLE_OF_PROGRAM = "Flappy Bird";
    final int WINDOW_WIDTH = 800;
    final int WINDOW_HEIGHT = 800;



    public BackGround(){
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        Pipes Pipes = new Pipes();
        Drone drone = new Drone();

        Pipes ARRAY_PIPES[]  = new Pipes[4];
        for (int i = 1; i<ARRAY_PIPES.length + 1 ; i++) {
            ARRAY_PIPES[i-1] = new Pipes();
            ARRAY_PIPES[i-1].CreatPipes(400 + i*300);
        }




        





        Canvas canvas = new Canvas(ARRAY_PIPES);

        canvas.setBackground(Color.white);
        canvas.setPreferredSize(
                new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));



        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }




}
