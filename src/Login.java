
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame  implements ActionListener {
JTextField usernameField, passwordField;
    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(40,20,100,30);
        add(usernameLabel);

         usernameField = new JTextField();
        usernameField.setBounds(150,20,150,30);
        add(usernameField);


        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40,70,100,30);
        add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(150,70,150,30);
        add(passwordField);

        JButton login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.addActionListener(this);
        add(login);
        setSize(600,300);
        setLocation(450,200);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String username = usernameField.getText();
            String password = passwordField.getText();
            Conn c = new Conn();
            String query = "select * from login where username='" + username + "' AND password = '" + password + "'";
           ResultSet res = c.s.executeQuery(query);
            if(res.next()){
                setVisible(false);
                new Home();
            }else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }

        }catch (Exception err){
             err.printStackTrace();
        }
    }
}
