package dodge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instruction extends JFrame implements ActionListener {
    int screenHeight = 600;
    int screenWidth = 600;
    JButton back;

    Instruction(){
        this.setLayout(null);
        back = new JButton("Back");
        JLabel instruct = new JLabel("INSTRUCTIONS");
        JLabel gamePlay = new JLabel("GamePlay");
        JLabel scoring = new JLabel("Scoring");
        JTextArea t1 = new JTextArea("Avoid the space rocks my moving around." +
                " Use the arrow keys\n to maneuver across the space.");
        JTextArea t2 = new JTextArea("Earn points by evading the rocks." +
                " For every rock you dodge you\n earn +1 point.");
        Font f = new Font("Gill Sans Ultra Bold", Font.BOLD, 25);
        ImageIcon i = new ImageIcon("icon_main.png");
        back.addActionListener(this);

        instruct.setBounds(110, 25, 400, 50);
        instruct.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 40));

        gamePlay.setBounds(50,100,200,25);
        gamePlay.setFont(f);

        t1.setBounds(50,135,400,60);
        t1.setFont(new Font("Calibri", Font.ITALIC, 15));
        t1.setEditable(false);

        scoring.setBounds(50,250, 200, 25);
        scoring.setFont(f);

        t2.setBounds(50, 285, 400, 60);
        t2.setFont(new Font("Calibri", Font.ITALIC, 15));
        t2.setEditable(false);

        back.setBounds(400, 400, 160, 50);
        back.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 20));
        back.setBackground(Color.GRAY);

        this.setSize(screenWidth,screenHeight);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(i.getImage());
        this.setTitle("DODGE");

        this.add(instruct);
        this.add(gamePlay);
        this.add(t1);
        this.add(scoring);
        this.add(t2);
        this.add(back);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            dispose();
            new FirstPage();
        }
    }
}
