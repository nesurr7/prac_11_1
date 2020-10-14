package classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPane extends JPanel {
    private int HEIGHT = MyWindow.SCRN_HEIGHT;
    private int WIDTH = MyWindow.SCRN_WIDTH;
    private JButton button = new JButton("Проверить");
    private JLabel label = new JLabel("Угадайте число от 0 до 20");
    private JTextField inputTextfield = new JTextField();
    private final int constant = (int)(Math.random() * 100) % 21;
    private int counter = 0;

    public MyPane() {
        setLayout(null);
        label.setBounds((WIDTH-150)/2,(HEIGHT-50)/2,200,50);
        inputTextfield.setBounds((WIDTH-100)/2,(HEIGHT-50-200)/2,100,50);
        button.setBounds((WIDTH)/2-60,(HEIGHT+50)/2,120,40);
        button.addActionListener(new ButtonEvent());
        add(label);
        add(inputTextfield);
        add(button);
    }

    class ButtonEvent implements ActionListener {
        public void actionPerformed(ActionEvent ev){
            counter++;
            try {
                if (counter <= 3 && constant == Integer.valueOf(inputTextfield.getText())) {
                    JOptionPane.showMessageDialog(null, "Вы угадали число!\nЧисло: " + constant, "Победа", JOptionPane.PLAIN_MESSAGE);
                    System.exit(1);
                } else if (counter == 3 && constant != Integer.valueOf(inputTextfield.getText())) {
                    JOptionPane.showMessageDialog(null, "Вы не угадaли число.\nЧисло: " + constant + "\nКонец игры", "Поражение", JOptionPane.PLAIN_MESSAGE);
                    System.exit(1);
                } else {
                    if (Integer.valueOf(inputTextfield.getText()) > constant)
                        JOptionPane.showMessageDialog(null, "Введенное число больше загаданного.", "Окно", JOptionPane.PLAIN_MESSAGE);
                    else if (Integer.valueOf(inputTextfield.getText()) < constant)
                        JOptionPane.showMessageDialog(null, "Введенное число меньше загаданного.", "Окно", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (NumberFormatException e) {
                counter--;
                inputTextfield.setText("");
                JOptionPane.showMessageDialog(null, "Вводите числа!!!", "Ошибка", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}