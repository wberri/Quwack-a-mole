import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Geese extends JPanel implements ActionListener, MouseMotionListener {
    private int x;
    private int y;
    private int previous;
    private boolean isGeese;
    private JButton switchButton;

    private JLabel back;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;

    private JButton pStart;
    private Timer timer;
    private int seconds;
    private JLabel timerLabel;
    private JLabel timerLabel2; //the drawing
    private static int currentScore;

    public Geese () {
        timer = new Timer(1000, null);
        seconds = 15;
        timerLabel = new JLabel("" + seconds);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 40));
        Color c = new Color(179, 125, 84);
        timerLabel.setForeground(c);
        timerLabel2 = new JLabel(" ");
        currentScore = 0;

        add(timerLabel);
        add(timerLabel2);
        pStart = new JButton("  ");
        add(pStart);
        previous = 0;
        b4 = new JButton(""); //put out of order in order to fix overlapping
        add(b4);
        b5 = new JButton("");
        add(b5);
        b6 = new JButton("");
        add(b6);
        b1 = new JButton("");
        add(b1);
        b2 = new JButton("");
        add(b2);
        b3 = new JButton("");
        add(b3);
        b7 = new JButton("");
        add(b7);
        b8 = new JButton("");
        add(b8);
        b9 = new JButton("");
        add(b9);
        switchButton = new JButton("switch mode");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        timer.addActionListener(this);
        pStart.addActionListener(this);
        addMouseMotionListener(this);

        pStart.setVisible(true);
        timerLabel.setVisible(false);
        timerLabel2.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);
        b6.setVisible(false);
        b7.setVisible(false);
        b8.setVisible(false);
        b9.setVisible(false);
    }

    public static int getCurrentScore(){
        return currentScore;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon icon0 = new ImageIcon("src/bg2.png");
        Image iconImg = icon0.getImage();
        g.drawImage(iconImg, 0, 0, null);

        timerLabel.setLocation(510, 75);
        timerLabel2.setLocation(470, 18);

        if (seconds%2 == 0) {
            ImageIcon icon;
            icon = new ImageIcon("src/clockFront.png");
            timerLabel2.setIcon(icon);
            if (seconds < 10) {
                timerLabel.setLocation(520, 75);
            } else if (seconds < 20) {
                timerLabel.setLocation(507, 78);
            }
        } else {
            ImageIcon icon;
            icon = new ImageIcon("src/clockBack.png");
            timerLabel2.setIcon(icon);
            timerLabel2.setLocation(470, 5);
            if (seconds < 10) {
                timerLabel.setLocation(519, 80);
            } else if (seconds < 20) {
                timerLabel.setLocation(507, 80);
            } else {
                timerLabel.setLocation(508, 80);
            }
        }

        pStart.setLocation(53,260);

        ImageIcon icon11;
        if (SimpleGUI.IsGeese()){
            icon11 = new ImageIcon("src/geeseStart.png");
        }else{
            icon11 = new ImageIcon("src/peopleStart.png");
        }
        pStart.setIcon(icon11);
        pStart.setBorderPainted(false);
        pStart.setContentAreaFilled(false);
        pStart.setFocusPainted(false);
        pStart.setOpaque(false);

        b1.setLocation(10,290);
        b2.setLocation(210,290);
        b3.setLocation(410,290);
        b4.setLocation(10,435);
        b5.setLocation(210,435);
        b6.setLocation(410,435);
        b7.setLocation(10,590);
        b8.setLocation(210,590);
        b9.setLocation(420,590);

        ImageIcon icon1;
        if (SimpleGUI.IsGeese()){
            icon1 = new ImageIcon("src/goose.png");

        }else{
            icon1 = new ImageIcon("src/Mole1.png");
            b1.setLocation(21,340);
        }

        b1.setIcon(icon1);
        b1.setBorderPainted(false);
        b1.setContentAreaFilled(false);
        b1.setFocusPainted(false);
        b1.setOpaque(false);

        ImageIcon icon2;
        if (SimpleGUI.IsGeese()){
            icon2 = new ImageIcon("src/goose.png");
        }else{
            icon2 = new ImageIcon("src/mole2.png");
            b2.setLocation(220,346);
        }

        b2.setIcon(icon2);
        b2.setBorderPainted(false);
        b2.setContentAreaFilled(false);
        b2.setFocusPainted(false);
        b2.setOpaque(false);

        ImageIcon icon3;
        if (SimpleGUI.IsGeese()){
            icon3 = new ImageIcon("src/goose.png");
        }else{
            icon3 = new ImageIcon("src/mole3.png");
            b3.setLocation(440,305);
        }

        b3.setIcon(icon3);
        b3.setBorderPainted(false);
        b3.setContentAreaFilled(false);
        b3.setFocusPainted(false);
        b3.setOpaque(false);

        ImageIcon icon4;
        if (SimpleGUI.IsGeese()){
            icon4 = new ImageIcon("src/goose.png");
        }else{
            icon4 = new ImageIcon("src/mole4.png");
            b4.setLocation(25,492);
        }

        b4.setIcon(icon4);
        b4.setBorderPainted(false);
        b4.setContentAreaFilled(false);
        b4.setFocusPainted(false);
        b4.setOpaque(false);

        ImageIcon icon5 = new ImageIcon("src/goose.png");
        if (SimpleGUI.IsGeese()){
            icon5 = new ImageIcon("src/goose.png");
        }else{
            icon5 = new ImageIcon("src/mole5.png");
            b5.setLocation(225,486);
        }

        b5.setIcon(icon5);
        b5.setBorderPainted(false);
        b5.setContentAreaFilled(false);
        b5.setFocusPainted(false);
        b5.setOpaque(false);

        ImageIcon icon6 = new ImageIcon("src/goose.png");
        if (SimpleGUI.IsGeese()){
            icon6 = new ImageIcon("src/goose.png");
        }else{
            icon6 = new ImageIcon("src/mole6.png");
            b6.setLocation(430,500);
        }

        b6.setIcon(icon6);
        b6.setBorderPainted(false);
        b6.setContentAreaFilled(false);
        b6.setFocusPainted(false);
        b6.setOpaque(false);

        ImageIcon icon7 = new ImageIcon("src/goose.png");
        if (SimpleGUI.IsGeese()){
            icon7 = new ImageIcon("src/goose.png");
        }else{
            icon7 = new ImageIcon("src/mole7.png");
            b7.setLocation(12,595);
        }

        b7.setIcon(icon7);
        b7.setBorderPainted(false);
        b7.setContentAreaFilled(false);
        b7.setFocusPainted(false);
        b7.setOpaque(false);

        ImageIcon icon8 = new ImageIcon("src/goose.png");
        if (SimpleGUI.IsGeese()){
            icon8 = new ImageIcon("src/goose.png");
        }else{
            icon8 = new ImageIcon("src/mole8.png");
            b8.setLocation(218,603);
        }

        b8.setIcon(icon8);
        b8.setBorderPainted(false);
        b8.setContentAreaFilled(false);
        b8.setFocusPainted(false);
        b8.setOpaque(false);

        ImageIcon icon9 = new ImageIcon("src/goose.png");
        if (SimpleGUI.IsGeese()){
            icon9 = new ImageIcon("src/goose.png");
        }else{
            icon9 = new ImageIcon("src/mole9.png");
            b9.setLocation(435,630);
        }

        b9.setIcon(icon9);
        b9.setBorderPainted(false);
        b9.setContentAreaFilled(false);
        b9.setFocusPainted(false);
        b9.setOpaque(false); //the rest of the icons 2-9

        if (!(pStart.isVisible())) {
            ImageIcon icon10 = new ImageIcon("src/hammer.png");
            Image iconImg10 = icon10.getImage();
            g.drawImage(iconImg10, x-30, y-57, null);
        }

//        if (!SimpleGUI.timerFired) {
//            SimpleGUI.timerFalse();
//            b1.setVisible(false);
//            b2.setVisible(false);
//            b3.setVisible(false);
//            b4.setVisible(false);
//            b5.setVisible(false);
//            b6.setVisible(false);
//            b7.setVisible(false);
//            b8.setVisible(false);
//            b9.setVisible(false);
//            randomGoose();
//            SimpleGUI.timerRestart();
//        }
    }

    private void randomGoose() {
        int ran = (int) ((Math.random() * 9) + 1);

        while (ran == previous) {
            ran = (int) ((Math.random() * 9) + 1);
        }

        switch (ran) {
            case 1:
                b1.setVisible(true);
                break;
            case 2:
                b2.setVisible(true);
                break;
            case 3:
                b3.setVisible(true);
                break;
            case 4:
                b4.setVisible(true);
                break;
            case 5:
                b5.setVisible(true);
                break;
            case 6:
                b6.setVisible(true);
                break;
            case 7:
                b7.setVisible(true);
                break;
            case 8:
                b8.setVisible(true);
                break;
            case 9:
                b9.setVisible(true);
                break;
        }
        previous = ran;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof Timer) {
            timerFire();
        } else if (source instanceof JButton) {
            JButton button = (JButton) source;
            String text = button.getText();
            if (text.equals("")) {
                button.setVisible(false);
                randomGoose();
            } else if (text.equals("  ")) { //pStart
                pStart.setVisible(false);
                timer.start();
                ImageIcon icon;
                icon = new ImageIcon("src/clockFront.png");
                timerLabel2.setIcon(icon);
                timerLabel.setVisible(true);
                timerLabel2.setVisible(true);
                randomGoose();
            }
        }
    }

    public void timerFire() {
        seconds--;
        timerLabel.setText(Integer.toString(seconds));
//        randomGoose();
//        if (previous==1){
//            b1.setVisible(false);
//        } else if (previous==2){
//            b2.setVisible(false);
//        } else if (previous==3){
//            b3.setVisible(false);
//        } else if (previous==4){
//            b4.setVisible(false);
//        } else if (previous==5){
//            b5.setVisible(false);
//        } else if (previous==6){
//            b6.setVisible(false);
//        } else if (previous==7){
//            b7.setVisible(false);
//        } else if (previous==8){
//            b8.setVisible(false);
//        } else if (previous==9){
//            b9.setVisible(false);
//        }

        if (seconds == 0) {
            timer.stop();
            SimpleGUI.cardLayout.show(SimpleGUI.mainPanel, "pane3");
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }
}
