package com.game.zmeika.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Launcher extends JPanel implements ActionListener {
    private final int SIZE = 20;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    private Fruit fruit = new Fruit((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
    private Snake snake = new Snake(0, 10);
    private Timer timer = new Timer(150, this);

    public Launcher() {
        timer.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    public void paint(Graphics graphics) {
        graphics.setColor(new Color(0, 100, 255));
        graphics.fillRect(0, 0, WIDTH * SIZE, HEIGHT * SIZE);
        graphics.setColor(new Color(50, 100, 50));
        graphics.fillRect(snake.snakePositionX[0] * SIZE, snake.snakePositionY[0] * SIZE, SIZE, SIZE);
        for (int i = 1; i < snake.snakeLength; i++) {
            graphics.setColor(new Color(50, 200, 50));
            graphics.fillRect(snake.snakePositionX[i] * SIZE, snake.snakePositionY[i] * SIZE, SIZE, SIZE);
        }
        graphics.setColor(new Color(255, 50, 0));
        graphics.fillRect(fruit.applePositionX * SIZE, fruit.applePositionY * SIZE, SIZE, SIZE);
    }

    public void run() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(WIDTH * SIZE + 16, HEIGHT * SIZE + 38);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new Launcher());
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.movement();
        if ((snake.snakePositionX[0] == fruit.applePositionX) && (snake.snakePositionY[0] == fruit.applePositionY)) {
            fruit.setApplePosition();
            snake.snakeLength++;
        }
        for (int i = 1; i < snake.snakeLength; i++) {
            if ((snake.snakePositionX[i] == fruit.applePositionX) && (snake.snakePositionY[i] == fruit.applePositionY)) {
                fruit.setApplePosition();
            }
        }
        repaint();
    }

    private class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent keyEvent) {
            int key = keyEvent.getKeyCode();
            if (key == KeyEvent.VK_RIGHT && snake.direction != 2) {
                snake.direction = 0;
            }
            if (key == KeyEvent.VK_DOWN && snake.direction != 3) {
                snake.direction = 1;
            }
            if (key == KeyEvent.VK_LEFT && snake.direction != 0) {
                snake.direction = 2;
            }
            if (key == KeyEvent.VK_UP && snake.direction != 1) {
                snake.direction = 3;
            }
        }
    }
}
