package graphics;

import assets.Participant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Question extends JFrame {
    static int number = 0;
    String text = "";
    String choice1 = "";
    String choice2 = "";
    String choice3 = "";
    String choice4 = "";
    int ans = 1;

    public Question(Participant participant) {
        number++;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1000, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Online Exam - Question" + number);
        extractQuestion();

        JLabel quiz = new JLabel("سوال" + number + ": " + text, SwingConstants.RIGHT);
        quiz.setBounds(20, 20, 950, 50);
        quiz.setFont(new Font("Serif", Font.BOLD, 25));
        add(quiz);

        JRadioButton ch1 = new JRadioButton(choice1);
        JRadioButton ch2 = new JRadioButton(choice2);
        JRadioButton ch3 = new JRadioButton(choice3);
        JRadioButton ch4 = new JRadioButton(choice4);
        ch1.setBounds(20, 70, 950, 50);
        ch2.setBounds(20, 120, 950, 50);
        ch3.setBounds(20, 170, 950, 50);
        ch4.setBounds(20, 220, 950, 50);
        ch1.setHorizontalAlignment(SwingConstants.RIGHT);
        ch2.setHorizontalAlignment(SwingConstants.RIGHT);
        ch3.setHorizontalAlignment(SwingConstants.RIGHT);
        ch4.setHorizontalAlignment(SwingConstants.RIGHT);
        ch1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        ch2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        ch3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        ch4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        ch1.setFont(new Font("Serif", Font.PLAIN, 22));
        ch2.setFont(new Font("Serif", Font.PLAIN, 22));
        ch3.setFont(new Font("Serif", Font.PLAIN, 22));
        ch4.setFont(new Font("Serif", Font.PLAIN, 22));
        add(ch1);
        add(ch2);
        add(ch3);
        add(ch4);
        ButtonGroup choices = new ButtonGroup();
        choices.add(ch1);
        choices.add(ch2);
        choices.add(ch3);
        choices.add(ch4);

        JButton next = new JButton("سوال بعد");
        next.setBounds(200, 400, 160, 40);
        next.setFont(new Font("B Nazanin", Font.BOLD, 30));
        next.setBackground(new Color(0, 196, 255));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(ch1.isSelected() || ch2.isSelected() || ch3.isSelected() || ch4.isSelected())) {
                    JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error, "حتما باید یک گزینه را انتخاب کنید!", "انتخاب گزینه", JOptionPane.ERROR_MESSAGE);
                } else {
                    switch (ans) {
                        case 1:
                            if (ch1.isSelected())
                                participant.increasePoint();
                            break;
                        case 2:
                            if (ch2.isSelected())
                                participant.increasePoint();
                            break;
                        case 3:
                            if (ch3.isSelected())
                                participant.increasePoint();
                            break;
                        case 4:
                            if (ch4.isSelected())
                                participant.increasePoint();
                            break;
                    }

                    new Question(participant);
                    setVisible(false);
                }
            }
        });
        if (number == 10) {
            next.setEnabled(false);
        }
        add(next);

        JButton end = new JButton("پایان آزمون");
        end.setBounds(500, 400, 160, 40);
        end.setFont(new Font("B Nazanin", Font.BOLD, 30));
        end.setBackground(new Color(0, 255, 142));
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(ch1.isSelected() || ch2.isSelected() || ch3.isSelected() || ch4.isSelected())) {
                    JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error, "حتما باید یک گزینه را انتخاب کنید!", "انتخاب گزینه", JOptionPane.ERROR_MESSAGE);
                } else {
                    switch (ans) {
                        case 1:
                            if (ch1.isSelected())
                                participant.increasePoint();
                            break;
                        case 2:
                            if (ch2.isSelected())
                                participant.increasePoint();
                            break;
                        case 3:
                            if (ch3.isSelected())
                                participant.increasePoint();
                            break;
                        case 4:
                            if (ch4.isSelected())
                                participant.increasePoint();
                            break;
                    }

                    new Result(participant);
                    setVisible(false);
                }
            }
        });
        if (number == 10) {
            add(end);
        }

        setVisible(true);
    }

    private void extractQuestion() {
        try {
            String path = "src\\resources\\questions\\q" + number + ".txt";
            BufferedReader f = new BufferedReader(new FileReader(path));
            text = f.readLine();
            choice1 = f.readLine();
            choice2 = f.readLine();
            choice3 = f.readLine();
            choice4 = f.readLine();
            ans = Integer.parseInt(f.readLine());
            f.close();

        } catch (Exception ignored) {

        }
    }
}
