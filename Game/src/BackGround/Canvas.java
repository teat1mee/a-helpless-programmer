package BackGround;

import Bird_Mechanic.Drone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public  class Canvas extends JPanel implements ActionListener,KeyListener {
    private Timer timer;
    private Pipes Pipes = new Pipes();
    private Drone drone = new Drone();
    private Pipes ARRAY_PIPES []  = new Pipes[4];
    // Конструктор со всякими приколами
    public Canvas(Pipes[] pipes) {
        timer = new Timer(1,  this);
        timer.start(); // запуск таймерa
        this.ARRAY_PIPES = pipes;
        this.setFocusable(true);
        this.addKeyListener(this);
    }


// Отрисовка всего и вся в моем случае
    // WHILE но думаю что и всегда с работает как WHILE


    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Pipes.BackGround(g);
        for (int i = 0; i < ARRAY_PIPES.length; i++) {
            ARRAY_PIPES[i].Paint_Pipes(g);
            ARRAY_PIPES[i].Move_X();
            if (ARRAY_PIPES[i].getX() < -100){
                ARRAY_PIPES[i].CreatPipes(1100);
            }
        }
        drone.Paint_Drone(g);
        drone.Move_Drone();
        checkCollision();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
// Отвечает за нажатие
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            drone.setSPEED(-7);
        }
    }
    // Отвечает за отжатие
    @Override
    public void keyReleased(KeyEvent e) {

    }

    // ХЗ что это не помню
    @Override
    public void keyTyped(KeyEvent arg0) {}




    // Проверка колизий
    private void checkCollision() {
        for (Pipes pipe : ARRAY_PIPES) {
            if (drone.getBounds().intersects(pipe.getBounds()) || // intersects пересечение ну так если че
                    drone.getBounds().intersects(pipe.getBoundsDown())) {
                JOptionPane.showMessageDialog(null, "Вот тебя и сбили\n А теперь марш на штурм!");
                System.exit(0);

            }
        }
    }
}
