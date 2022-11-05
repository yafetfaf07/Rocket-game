package dodge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPage implements ActionListener {
    int input;
    int screenHeight = 600;
    int screenWidth = 600;
    String userName;
    JFrame first;
    JLabel dodge;
    JButton start;
    JButton listOFScores;
    JButton exit;
    JButton instruction;
    String[] difficulty={"Easy","Medium","Hard"};

    FirstPage(){
        dodge = new JLabel("DODGE");
        first = new JFrame("HOME");
        start = new JButton("Start");
        listOFScores = new JButton("Score");
        exit = new JButton("Exit");
        instruction = new JButton("Instruction");
        Font f = new Font("Gill Sans Ultra Bold", Font.BOLD, 25);
        ImageIcon i = new ImageIcon("icon_main.png");

        dodge.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 80));
        dodge.setBounds(120,50,400,100);
        dodge.setForeground(Color.WHITE);

        first.setDefaultCloseOperation(first.EXIT_ON_CLOSE);
        first.setResizable(false);
        first.setLayout(null);
        first.getContentPane().setBackground(Color.DARK_GRAY);
        first.setIconImage(i.getImage());
        first.setTitle("DODGE");

        start.setBounds(145,180,300,70);
        start.setFocusable(false);
        start.setBackground(Color.GRAY);
        start.setForeground(Color.WHITE);
        start.setFont(f);
        start.addActionListener(this);

        listOFScores.setBounds(145,265,300,70);
        listOFScores.setFocusable(false);
        listOFScores.addActionListener(this);
        listOFScores.setBackground(Color.GRAY);
        listOFScores.setForeground(Color.WHITE);
        listOFScores.setFont(f);

        instruction.setBounds(145,350,300,70);
        instruction.setFocusable(false);
        instruction.addActionListener(this);
        instruction.setBackground(Color.GRAY);
        instruction.setForeground(Color.WHITE);
        instruction.setFont(f);

        exit.setBounds(145,435,300,70);
        exit.setFocusable(false);
        exit.setBackground(Color.GRAY);
        exit.setForeground(Color.WHITE);
        exit.setFont(f);
        exit.addActionListener(this);

        first.add(start);
        first.add(listOFScores);
        first.add(exit);
        first.add(dodge);
        first.add(instruction);
        first.setSize(screenWidth, screenHeight);
        first.setLocationRelativeTo(null);
        first.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            userName = JOptionPane.showInputDialog("Enter Your Name:");
            MyFrame.setUserName(userName);

            input = JOptionPane.showOptionDialog(null,
                    "CHOOSE DIFFICULTY", "LEVELS",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, difficulty, 0);

            switch (input) {
                case 0:
                    first.dispose();
                    new MyFrame();
                    break;
                case 1:
                    first.dispose();
                    new Medium();
                    break;
                case 2:
                    first.dispose();
                    new Hard();
                    break;
                }
            }

        if(e.getSource()==listOFScores) {
            first.dispose();
            new History();
        }

        if (e.getSource()==exit) {
            System.exit(0);
        }

        if(e.getSource()==instruction){
            first.dispose();
            new Instruction();
        }
    }
}
