import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
public class ScoreBoard extends JPanel implements ActionListener{
    private ArrayList<Person> people;
    private JTextField nameInsert;
    private JButton submit;
    private String name;

    public ScoreBoard(){
        people = new ArrayList<Person>();
        nameInsert = new JTextField(10);
        nameInsert.setFont(new Font("Arial", Font.BOLD, 40));
        add(nameInsert);
        submit = new JButton(" ");
        add(submit);
        name = "";
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon icon0 = new ImageIcon("src/bg2.jpeg");
        Image iconImg = icon0.getImage();
        g.drawImage(iconImg, 0, 0, null);
        nameInsert.setLocation(125,30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = (JButton) source;
        String text = button.getText();

        if (text.equals(" ")) {
            name = nameInsert.getText();


        }
    }

    public void setPerson(){
        Person currentPerson = new Person(name, Geese.getCurrentScore());
        //if null immediately add it in.
        //if full, check for each if it fits in

        for (int i = 0; i<people.size();i++){
            //if ()
        }
    }
}
