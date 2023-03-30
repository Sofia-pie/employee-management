import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame implements ActionListener {
    Start(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("sans-serif",Font.PLAIN,60));
        add(heading);

        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400,400,300,70);
        clickhere.addActionListener(this);
        add(clickhere);

        setSize(1170,650);



    }
    public static void main(String[] args) {
    new Start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}
