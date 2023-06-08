import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JPanel implements ActionListener, MouseMotionListener {

    private int x;
    private int y;
    private int previous;
    private JButton startWithGeese;
    private JButton startWithPeople;

    private JLabel back;

    public Home () {
        previous = 0;

        startWithGeese = new JButton(" ");
        add(startWithGeese);
        startWithGeese.setLocation(200,200);
        startWithGeese.addActionListener(this);

        startWithPeople = new JButton("  ");
        add(startWithPeople);
        startWithPeople.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon icon0 = new ImageIcon("src/title.png");
        Image iconImg = icon0.getImage();
        g.drawImage(iconImg, 0, 0, null);

        startWithPeople.setIcon(new ImageIcon("src/peopleButton.png"));
        startWithPeople.setLocation(20,0);
        startWithPeople.setBorderPainted(false);
        startWithPeople.setContentAreaFilled(false);
        startWithPeople.setFocusPainted(false);
        startWithPeople.setOpaque(false);

        startWithGeese.setIcon(new ImageIcon("src/geeseButton.png"));
        startWithGeese.setLocation(300,0);
        startWithGeese.setBorderPainted(false);
        startWithGeese.setContentAreaFilled(false);
        startWithGeese.setFocusPainted(false);
        startWithGeese.setOpaque(false);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = (JButton) source;
        String text = button.getText();

        if (text.equals(" ")){
            SimpleGUI.setIsGeese(true);
            SimpleGUI.cardLayout.show(SimpleGUI.mainPanel, "pane2");
        }

        if (text.equals("  ")){
            SimpleGUI.setIsGeese(false);
            SimpleGUI.cardLayout.show(SimpleGUI.mainPanel, "pane2");
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
