package graphics;

import assets.Participant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Result extends JFrame {
    public Result(Participant participant) {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Online Exam - Result");

        JLabel title = new JLabel("اعلام نتایج", SwingConstants.CENTER);
        title.setBounds(200, 20, 600, 40);
        title.setFont(new Font("B Nazanin", Font.BOLD, 40));
        title.setForeground(new Color(8, 187, 0));
        add(title);

        JLabel name = new JLabel("نام و نام خانوادگی: " + participant.getName(), SwingConstants.RIGHT);
        name.setBounds(200, 100, 600, 40);
        name.setFont(new Font("B Homa", Font.BOLD, 30));
        add(name);
        JLabel phone = new JLabel("شماره تلفن: " + participant.getPhone(), SwingConstants.RIGHT);
        phone.setBounds(200, 150, 600, 40);
        phone.setFont(new Font("B Homa", Font.BOLD, 30));
        add(phone);
        JLabel gender = new JLabel("جنسیت: " + participant.getGender(), SwingConstants.RIGHT);
        gender.setBounds(200, 200, 600, 40);
        gender.setFont(new Font("B Homa", Font.BOLD, 30));
        add(gender);
        JLabel birthdate = new JLabel("تاریخ تولد: " + participant.getBirthDate(), SwingConstants.RIGHT);
        birthdate.setBounds(200, 250, 600, 40);
        birthdate.setFont(new Font("B Homa", Font.BOLD, 30));
        add(birthdate);
        JLabel address = new JLabel("آدرس: " + participant.getAddress(), SwingConstants.RIGHT);
        address.setBounds(200, 300, 600, 150);
        address.setFont(new Font("B Homa", Font.BOLD, 30));
        add(address);
        JLabel score = new JLabel("نمره آزمون: " + participant.getPoint(), SwingConstants.CENTER);
        score.setBounds(200, 450, 600, 40);
        score.setFont(new Font("B Homa", Font.BOLD, 30));
        score.setForeground(new Color(188, 206, 17));
        add(score);

        JButton exit = new JButton("خروج");
        exit.setBounds(450, 550, 100, 50);
        exit.setFont(new Font("B Nazanin", Font.BOLD, 25));
        exit.setBackground(new Color(247, 53, 0));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame error = new JFrame();
                int order = JOptionPane.showConfirmDialog(error, "آیا برای خروج از برنامه اطمینان دارید؟");
                if (order == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        add(exit);

        setVisible(true);
    }
}