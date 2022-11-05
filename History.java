package dodge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class History extends JFrame implements ActionListener {
    JTextArea place;
    String reading;
    Scanner read;
    FileWriter delete;
    JButton back, clear;
    JLabel score;
    History(){
        place=new JTextArea();
        back = new JButton("Back");
        clear = new JButton("Clear");
        score = new JLabel("SCORE-BOARD");
        JScrollPane sp= new JScrollPane();
        ImageIcon i = new ImageIcon("icon_main.png");
        clear.addActionListener(this);
        back.addActionListener(this);
        this.setLayout(null);

        score.setBounds(50, 25, 400, 50);
        score.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 40));

        back.setBounds(350, 450, 160, 50);
        back.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 20));
        back.setBackground(Color.GRAY);

        clear.setBounds(50, 450, 160, 50);
        clear.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 20));
        clear.setBackground(Color.GRAY);

        place.setBounds(40,100,500,300);
        place.setEditable(false);
        place.setFont(new Font("Calibri", Font.ITALIC, 15));

        sp.setBounds(40,100,500,300);
        sp.getViewport().setBackground(Color.WHITE);
        sp.getViewport().add(place);


        this.setSize(600,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(i.getImage());
        this.setTitle("DODGE");
        this.add(score);
        this.add(back);
        this.add(clear);
        this.add(sp);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        try{
            read=new Scanner(new File("Scores.txt"));
            while(read.hasNextLine()){
                reading= read.nextLine();

                place.append(reading+"\n");
            }
            read.close();

        }

        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            this.dispose();
            new FirstPage();
        }
        if(e.getSource()==clear){
            try {
                delete = new FileWriter("Scores.txt");
                // delete.write("n");
                delete.close();

            } catch (IOException f) {
                f.printStackTrace();
            }

            try {
                read=new Scanner(new File("Scores.txt"));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            while(read.hasNextLine()){
                reading= read.nextLine();

                place.append(reading+"\n");
            }
            read.close();
            new History();
            this.dispose();

        }
    }
}
