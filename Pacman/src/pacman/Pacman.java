package pacman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pacman extends Panel implements KeyListener {
    
    static int y = 120, x = 100, sa = 23, mouth = 305;
    static int rx = 0, ry = 0;
    static int score;
    static Color color = Color.YELLOW;
    
    static boolean f1 = true;
    static boolean f2 = false;
    static boolean ff1 = false;
    static boolean ff2 = false;
    static int ran1;
    static int ran2;
    
    static int foodLocationX;
    static int foodLocationY;
    
    @Override
    public void paint(Graphics g) {
        g.setColor(new Color (0, 41, 66));
        g.fillOval(foodLocationX, foodLocationY, 30, 30);
        
        g.setColor(color);
        g.fillArc(x, y, 80, 80, sa, mouth);
        
        g.setColor(Color.WHITE);
        g.drawRect(10, 10, 570, 50);
        g.setColor(Color.black);
        g.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        g.drawString("Score = " + score, 210, 40);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Pacman panel = new Pacman();
        while (f1) {
            ran1 = (int) (Math.random() * 430);
            if (ran1 % 15 == 0) {
                foodLocationX = ran1+10;
                f1 = false;
                f2 = true;
            } else {
                f1 = true;
            }
        }
        while (f2) {
            ran2 = (int) (Math.random() * 430);
            if (ran2 % 15 == 0) {
                foodLocationY = ran2+10;
                f2 = false;
            } else {
                f2 = true;
            }
        }
        
        
        
        
        panel.addKeyListener(panel);
        panel.setBackground(new Color(29, 131, 139));
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(
                                       JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'r') {
            color = Color.RED;
        }
        if (e.getKeyChar() == 'y') {
            color = Color.YELLOW;
        }
        if (e.getKeyChar() == 'b') {
            color = Color.cyan;
        }
        if (e.getKeyChar() == 'g') {
            color = Color.green;
        }
        
        
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (y <= 0) //  y = 0;
            {
                y = (getHeight());
            } else {
                y -= 5;
            }
            sa = 113;
            if (y % 2 == 0) {
                mouth = 360;
            } else {
                mouth = 305;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (y >= (getHeight() - 100)) // y = (getHeight() - 100);
            {
                y = -90;
            } else {
                y += 5;
            }
            sa = 293;
            if (y % 2 == 0) {
                mouth = 360;
            } else {
                mouth = 305;
            }
            
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (x <= 0) //  y = 0;
            {
                x = (getWidth());
            } else {
                x -= 5;
            }
            sa = 203;
            if (x % 2 == 0) {
                mouth = 360;
            } else {
                mouth = 305;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (x >= (getWidth() - 100)) // x = (getWidth() - 100);
            {
                x = -90;
            } else {
                x += 5;
            }
            sa = 23;
            if (x % 2 == 0) {
                mouth = 360;
            } else {
                mouth = 305;
            }
        }
        rx = x + 15;
        ry = y + 15;
        int m = 20;
        if (rx >= foodLocationX -m && rx <= foodLocationX+m) {
            if (ry >= foodLocationY -m && ry <= foodLocationY+m) {
                ff1 = true;
                while (ff1) {
                    ran1 = (int) (Math.random() * 430);
                    if (ran1 % 15 == 0) {
                        foodLocationX = ran1+30;
                        ff1 = false;
                        ff2 = true;
                    } else {
                        ff1 = true;
                    }
                }
                while (ff2) {
                    ran2 = (int) (Math.random() * 430);
                    if (ran2 % 15 == 0) {
                        foodLocationY = ran2+30;
                        ff2 = false;
                    } else {
                        ff2 = true;
                    }
                }
                score = score + 1;
                if(score == 10){
                    repaint();
                    JOptionPane.showMessageDialog(null, "game over");
                    System.exit(0);
                }
            }
        }
        repaint();
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
