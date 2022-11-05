package dodge;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MyFrame implements KeyListener{
    int counter = 0;
    String counterStr;
    static String userName;
    String level;
    String[] decide = {"Restart", "Exit", "Menu"};
    FileWriter writer;
    int output;
    int screenHeight = 600;
    int screenWidth = 600;
    JFrame frame;
    JLabel car, block1, block2, block3, block4, score = new JLabel();
    int randomX;
    int randomY;
    Timer t = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            block1.setBounds(block1.getX()-5, block1.getY(), 72 , 64);
            if(block1.getX() < -72){
                randomX = (int) (Math.random()*screenWidth + screenWidth);
                randomY =(int) (Math.random()*screenHeight);
                block1.setBounds(randomX, randomY, 72, 64);
                counter++;
                counterStr = Integer.toString(counter);
                score.setText("Score:"+counterStr);
            }

            block2.setBounds(block2.getX()-5, block2.getY(), 70 , 60);
            if(block2.getX() < -70){
                randomX = (int) (Math.random()*screenWidth + screenWidth);
                randomY =(int) (Math.random()*screenHeight);
                block2.setBounds(randomX, randomY, 70, 60);
                counter++;
                counterStr = Integer.toString(counter);
                score.setText("Score:"+counterStr);
            }

            block3.setBounds(block3.getX()-5, block3.getY(), 72 , 67);
            if(block3.getX() < -72){
                randomX = (int) (Math.random()*screenWidth + screenWidth);
                randomY =(int) (Math.random()*screenHeight);
                block3.setBounds(randomX, randomY, 72, 67);
                counter++;
                counterStr = Integer.toString(counter);
                score.setText("Score:"+counterStr);
            }

            block4.setBounds(block4.getX()-5, block4.getY(), 67 , 67);
            if(block4.getX() < -67){
                randomX = (int) (Math.random()*screenWidth + screenWidth);
                randomY =(int) (Math.random()*screenHeight);
                block4.setBounds(randomX, randomY, 67, 67);
                counter++;
                counterStr = Integer.toString(counter);
                score.setText("Score:"+counterStr);
            }

            if (block1.getBounds().intersects(car.getBounds()) || block2.getBounds().intersects(car.getBounds()) ||
                    block3.getBounds().intersects(car.getBounds()) || block4.getBounds().intersects(car.getBounds()) ||
                    car.getX() < 0 || car.getX() > screenWidth || car.getY() < 0 || car.getY() > screenHeight){
                counterStr=Integer.toString(counter);
                gameOver();
            }
        }
    };
    MyFrame(){
        level = "easy";
        ImageIcon i = new ImageIcon("icon_main.png");
        frame = new JFrame("DODGE");
        frame.setIconImage(i.getImage());
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("background.jpg")))));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        score.setText("Score: 0");
        score.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        score.setBackground(Color.darkGray);
        score.setForeground(Color.red);
        score.setBounds(200, 0, 200, 50);

        car = new JLabel();
        ImageIcon i1 = new ImageIcon("spaceShip.png");
        car.setBounds(screenWidth/6, screenHeight/2, 64, 42);
        car.setIcon(i1);

        block1 = new JLabel();
        ImageIcon i2 = new ImageIcon("rock.png");
        randomX = (int) (Math.random()*screenWidth + screenWidth);
        randomY = (int) (Math.random()*screenHeight);
        block1.setBounds(randomX, randomY, 72, 64);
        block1.setIcon(i2);

        block2 = new JLabel();
        ImageIcon i3 = new ImageIcon("rock2.png");
        randomX = (int) (Math.random()*screenWidth + screenWidth);
        randomY = (int) (Math.random()*screenHeight);
        block2.setBounds(randomX, randomY, 70, 60);
        block2.setIcon(i3);

        block3 = new JLabel();
        ImageIcon i4 = new ImageIcon("rock3.png");
        randomX = (int) (Math.random()*screenWidth + screenWidth);
        randomY = (int) (Math.random()*screenHeight);
        block3.setBounds(randomX, randomY, 72, 67);
        block3.setIcon(i4);

        block4 = new JLabel();
        ImageIcon i5 = new ImageIcon("rock4.png");
        randomX = (int) (Math.random()*screenWidth + screenWidth);
        randomY = (int) (Math.random()*screenHeight);
        block4.setBounds(randomX, randomY, 67, 67);
        block4.setIcon(i5);

        frame.add(car);
        frame.add(block1);
        frame.add(block2);
        frame.add(block3);
        frame.add(block4);
        frame.add(score);

        frame.setVisible(true);
        startGame();
    }

    void startGame(){
        t.scheduleAtFixedRate(task, 0, 33);
    }

    public static void setUserName(String n){
        userName = n;
    }

    public void gameOver(){
        t.cancel();
        car.setBounds(0,0,0,0);
        output = JOptionPane.showOptionDialog(null, "Your score is " + counterStr,
                "GAME OVER", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, decide, 0);
        try {
            writer = new FileWriter("Scores.txt",true);
            writer.append("\nName: "+userName+"\t\t"+"Score: "+counterStr+"\t\t"+"Level: "+level );

            writer.close();

        } catch (IOException f) {
            f.printStackTrace();
        }
        switch (output) {
            case 0:
                frame.dispose();
                new MyFrame();
                break;
            case 1:
                frame.dispose();
                System.exit(0);
                break;
            case 2:
                frame.dispose();
                new FirstPage();
                break;
        }
    }



    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case 37:
                car.setLocation(car.getX()-10, car.getY());
                break;
            case 38:
                car.setLocation(car.getX(), car.getY()-10);
                break;
            case 39:
                car.setLocation(car.getX()+10, car.getY());
                break;
            case 40:
                car.setLocation(car.getX(), car.getY()+10);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
