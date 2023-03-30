import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton view, update, add,remove;
    Home(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(650,20,400,40);
        heading.setFont(new Font("sans-serif", Font.BOLD,25));
        add(heading);

        add = new JButton("Add Employee");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        add(add);

        view = new JButton("View Employees");
        view.setBounds(850,80,150,40);
        view.addActionListener(this);
        add(view);

        update = new JButton("Update Employee");
        update.setBounds(650,140,150,40);
        update.addActionListener(this);
        add(update);

        remove  = new JButton("Remove  Employee");
        remove.setBounds(850,140,150,40);
        remove.addActionListener(this);
        add(remove);


        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            setVisible(false);
            new AddEmployee();
        } else if (e.getSource()==update) {
            setVisible(false);
            new ViewEmployees();
        } else if (e.getSource()== view) {
            setVisible(false);
            new ViewEmployees();
        }else{
            setVisible(false);
            new RemoveEmployee();

        }
    }
}
