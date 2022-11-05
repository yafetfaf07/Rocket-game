package dodge;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Medium extends MyFrame{
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

    public Medium(){
        level = "Medium";
        t.scheduleAtFixedRate(task, 0, 31);
    }

    public void gameOver() {
        t.cancel();
        super.t.cancel();
        car.setBounds(0, 0, 0, 0);
        output = JOptionPane.showOptionDialog(null, "Your score is " + counterStr,
                "GAME OVER", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, decide, 0);
        try {
            writer = new FileWriter("Scores.txt", true);
            writer.append("\nName: " + userName + "\t\t" + "Score: " + counterStr + "\t\t" + "Level: " + level);

            writer.close();

        } catch (IOException f) {
            f.printStackTrace();
        }
        switch (output) {
            case 0:
                frame.dispose();
                new Medium();
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
}
