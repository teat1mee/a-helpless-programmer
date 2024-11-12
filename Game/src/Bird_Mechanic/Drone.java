package Bird_Mechanic;

import javax.swing.*;
import java.awt.*;

public class Drone extends JPanel {
    private int X = 400;
    private int Y = 100;
    private int WIDHT = 20;
    private float SPEED = 0f;


    public Drone(){

            ImageIcon Drone = new ImageIcon("Drone.png");
            Image icon = Drone.getImage();
            Image real= icon.getScaledInstance(32,32, Image.SCALE_SMOOTH);
            Drone= new ImageIcon(real);
    }


    public void Paint_Drone(Graphics g) {
        ImageIcon Drone = new ImageIcon("Drone.png");
        Image icon = Drone.getImage();
        Image real= icon.getScaledInstance(32,32, Image.SCALE_SMOOTH);
        Drone= new ImageIcon(real);
        super.paintComponent(g);
        g.drawImage(real,X-64,Y-64,128,128,null);
    }

    public Rectangle getBounds(){
return new Rectangle(X, Y, WIDHT, 20);
    }

    public void Move_X() {
        X++;
    }

    public void Move_YDOWN() {
        Y += 10;
    }

    public void Move_YUP() {
        Y -= 10;
    }

    public void Move_Drone(){
        Y+=SPEED;
        SPEED += 0.5;
    }

    public void setSPEED(float SPEED) {
        this.SPEED = SPEED;
    }
}
