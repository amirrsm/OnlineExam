package graphics;

import assets.Participant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StartMenu extends JFrame {

    Participant participant = null;

    public StartMenu() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Online Exam");

        JLabel title = new JLabel("فرم مشخصات داوطلب", SwingConstants.CENTER);
        title.setBounds(300, 15, 400, 50);
        title.setFont(new Font("B Nazanin", Font.BOLD, 40));
        add(title);

        JTextField nameIn = new JTextField();
        nameIn.setBounds(150, 80, 320, 35);
        nameIn.setFont(new Font("B Homa", Font.PLAIN, 25));
        nameIn.setHorizontalAlignment(SwingConstants.RIGHT);
        add(nameIn);
        JLabel nameL = new JLabel("نام و نام خانوادگی(فارسی):", SwingConstants.LEFT);
        nameL.setBounds(500, 80, 400, 35);
        nameL.setFont(new Font("B Nazanin", Font.BOLD, 25));
        add(nameL);

        JTextField phoneIn = new JTextField();
        phoneIn.setBounds(150, 180, 320, 35);
        phoneIn.setFont(new Font("B Homa", Font.PLAIN, 25));
        phoneIn.setHorizontalAlignment(SwingConstants.LEFT);
        phoneIn.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        add(phoneIn);
        JLabel phoneL = new JLabel("شماره تلفن همراه:", SwingConstants.LEFT);
        phoneL.setBounds(500, 180, 400, 35);
        phoneL.setFont(new Font("B Nazanin", Font.BOLD, 25));
        add(phoneL);

        JRadioButton chooseMan = new JRadioButton("مرد", true);
        chooseMan.setBounds(300, 260, 75, 20);
        chooseMan.setFont(new Font("B Homa", Font.PLAIN, 25));
        add(chooseMan);
        JRadioButton chooseWoman = new JRadioButton("زن");
        chooseWoman.setBounds(375, 260, 75, 25);
        chooseWoman.setFont(new Font("B Homa", Font.PLAIN, 20));
        add(chooseWoman);
        ButtonGroup chooseStarter = new ButtonGroup();
        chooseStarter.add(chooseMan);
        chooseStarter.add(chooseWoman);
        JLabel gender = new JLabel("جنسیت:", SwingConstants.LEFT);
        gender.setBounds(500, 260, 400, 35);
        gender.setFont(new Font("B Nazanin", Font.BOLD, 25));
        add(gender);

        JTextArea address = new JTextArea();
        address.setBounds(150, 340, 320, 200);
        address.setFont(new Font("B Homa", Font.PLAIN, 20));
        address.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(address);
        JLabel addrL = new JLabel("آدرس:", SwingConstants.LEFT);
        addrL.setBounds(500, 340, 400, 35);
        addrL.setFont(new Font("B Nazanin", Font.BOLD, 25));
        add(addrL);

        Integer[] day = new Integer[31];
        for (int i = 1; i <= 31; i++) {
            day[i - 1] = i;
        }
        String[] month = {"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
        Integer[] year = new Integer[50];
        for (int i = 0; i < 50; i++) {
            year[50 - 1 - i] = 1401 - i;
        }
        JComboBox yearCombo = new JComboBox(year);
        yearCombo.setBounds(200, 570, 70, 30);
        yearCombo.setFont(new Font("B Homa", Font.PLAIN, 16));
        add(yearCombo);
        JComboBox monthCombo = new JComboBox(month);
        monthCombo.setBounds(270, 570, 80, 30);
        monthCombo.setFont(new Font("B Homa", Font.PLAIN, 16));
        add(monthCombo);
        JComboBox dayCombo = new JComboBox(day);
        dayCombo.setBounds(350, 570, 50, 30);
        dayCombo.setFont(new Font("B Homa", Font.PLAIN, 16));
        add(dayCombo);
        JLabel birthdate = new JLabel("تاریخ تولد:", SwingConstants.LEFT);
        birthdate.setBounds(500, 570, 400, 35);
        birthdate.setFont(new Font("B Nazanin", Font.BOLD, 25));
        add(birthdate);

        JCheckBox accept = new JCheckBox("پذیرش شرایط آزمون");
        accept.setBounds(250, 630, 350, 35);
        accept.setFont(new Font("B Nazanin", Font.BOLD, 20));
        accept.setHorizontalAlignment(SwingConstants.CENTER);
        accept.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(accept);

        JButton start = new JButton("شروع آزمون");
        start.setBounds(260, 680, 150, 40);
        start.setBackground(new Color(58, 225, 99));
        start.setFont(new Font("B Nazanin", Font.BOLD, 25));
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameIn.getText().trim();
                String phone = phoneIn.getText().trim();
                String addr = address.getText().trim();
                String gender;
                if (chooseMan.isSelected())
                    gender = chooseMan.getText();
                else
                    gender = chooseWoman.getText();
                int day = (int) dayCombo.getSelectedItem();
                String month = (String) monthCombo.getSelectedItem();
                int year = (int) yearCombo.getSelectedItem();
                if (name.equals("") || phone.equals("") || addr.equals("")) {
                    JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error, "تمام فیلدها باید تکمیل شود!", "فیلد خالی", JOptionPane.ERROR_MESSAGE);
                } else if (!accept.isSelected()) {
                    JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error, "لطفا شرایط آزمون را بپذیرید.", "پذیرش شرایط", JOptionPane.ERROR_MESSAGE);
                } else {
                    participant = new Participant(name, phone, gender, addr, day, month, year);
                    new Question(participant);
                    setVisible(false);
                }
            }
        });
        add(start);

        JButton clear = new JButton("پاک کردن فرم");
        clear.setBounds(420, 680, 180, 40);
        clear.setBackground(new Color(215, 41, 75));
        clear.setFont(new Font("B Nazanin", Font.BOLD, 25));
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameIn.setText("");
                phoneIn.setText("");
                chooseMan.setSelected(true);
                chooseWoman.setSelected(false);
                address.setText("");
            }
        });
        add(clear);
        setVisible(true);
    }
}
