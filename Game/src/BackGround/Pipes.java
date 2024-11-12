package BackGround;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Pipes extends JPanel {
    Random random = new Random();
private int X = 100;
private int  Y_UP = 0;
private int  WIDTH = 100;
private int RAND = random.nextInt(100,350);
private int RAND_LOWER = random.nextInt(RAND +150,RAND+300);



    public void CreatPipes(int X){ //// Создание трубы
        this.X = X;
    }


    @Override
    public int getX() {
        return X;
    }

public Rectangle getBounds(){
    return new Rectangle(X,Y_UP,WIDTH, RAND);
}
public Rectangle getBoundsDown(){
    return new  Rectangle(X, RAND_LOWER, WIDTH, 700);
}


    public void Paint_Pipes(Graphics g) {

        super.paintComponent(g);
        // Отрисовка верха
        g.setColor(Color.cyan);
        g.fillRect (X,Y_UP,WIDTH, RAND);
        g.setColor(Color.black);
        g.drawRect(X, Y_UP, WIDTH, RAND);

        // отрисовка низа
        g.setColor(Color.cyan);
        g.fillRect(X, RAND_LOWER, WIDTH, 700);
        g.setColor(Color.black);
        g.drawRect(X, RAND_LOWER, WIDTH, 700);
    }

    public void Move_X() {
        X-=2;
    }

    public void BackGround(Graphics g){
        ImageIcon backgroud = new ImageIcon("background.jpg");
        Image icon = backgroud.getImage();
        Image real = icon.getScaledInstance(800,800,Image.SCALE_SMOOTH);
        backgroud = new ImageIcon(real);
        super.paintComponent(g);
        g.drawImage(real,0,0,Color.black,null);
    }
}
