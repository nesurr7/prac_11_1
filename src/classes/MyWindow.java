package classes;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

public class MyWindow extends JFrame {

    public static int SCRN_WIDTH= Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int SCRN_HEIGHT= Toolkit.getDefaultToolkit().getScreenSize().height;
    public MyWindow(){
        createWindow();
        add(new MyPane());
        setVisible(true);
    }

    public void createWindow(){
        setTitle("Игра");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(SCRN_WIDTH, SCRN_HEIGHT);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){new MyWindow();}

}