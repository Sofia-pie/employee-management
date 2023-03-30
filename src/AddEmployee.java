import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    JButton add,back;
    JTextField nameField, lastnameField, salaryField,educationField,addressField, phoneField, emailField, designationField;
    JDateChooser dobField;
    JLabel employeeIdField;

    Random rand= new Random();
    int number = rand.nextInt(999999);
    AddEmployee(){



        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("sans-serif", Font.BOLD,25));
        add(heading);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,150,150,30);
        nameLabel.setFont(new Font("sans-serif",Font.PLAIN,20));
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200,150,150,30);
        add(nameField);

        JLabel lastnameLabel = new JLabel("Last Name");
        lastnameLabel.setBounds(400,150,150,30);
        lastnameLabel.setFont(new Font("sans-serif",Font.PLAIN,20));
        add(lastnameLabel);

        lastnameField = new JTextField();
        lastnameField.setBounds(600,150,150,30);
        add(lastnameField);

        JLabel dobLabel = new JLabel("Date of  Birth");
        dobLabel.setBounds(50,200,150,30);
        dobLabel.setFont(new Font("sans-serif",Font.PLAIN,20));
        add(dobLabel);

        dobField = new JDateChooser();
        dobField.setBounds(200,200,150,30);
        add(dobField);

        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(400,200,150,30);
        salaryLabel.setFont(new Font("sans-serif",Font.PLAIN,20));
        add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(600,200,150,30);
        add(salaryField);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(50,250,150,30);
        addressLabel.setFont(new Font("sans-serif",Font.PLAIN,20));
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(200,250,150,30);
        add(addressField);

        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(400,250,150,30);
        phoneLabel.setFont(new Font("sans-serif",Font.PLAIN,20));
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(600,250,150,30);
        add(phoneField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(400,300,150,30);
        emailLabel.setFont(new Font("sans-serif",Font.PLAIN,20));
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(600,300,150,30);
        add(emailField);

        JLabel educationLabel = new JLabel("Education");
        educationLabel.setBounds(50,300,150,30);
        educationLabel.setFont(new Font("sans-serif",Font.PLAIN,20));
        add(educationLabel);


        educationField = new JTextField();
        educationField.setBounds(200,300,150,30);
        add(educationField);

        JLabel designationLabel = new JLabel("Designation");
        designationLabel.setBounds(50,350,150,30);
        designationLabel.setFont(new Font("sans-serif",Font.PLAIN,20));
        add(designationLabel);

        designationField = new JTextField();
        designationField.setBounds(200,350,150,30);
        add(designationField);

        JLabel employeeIdLabel = new JLabel("Employee Id");
        employeeIdLabel.setBounds(400,350,150,30);
        employeeIdLabel.setFont(new Font("sans-serif",Font.PLAIN,20));
        add(employeeIdLabel);

        employeeIdField = new JLabel(""+ number);
        employeeIdField.setBounds(600,350,150,30);
        employeeIdField.setFont(new Font("sans-serif",Font.PLAIN,20));
        add(employeeIdField);

        add = new JButton("Add Employee");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String name = nameField.getText();
            String lastname = lastnameField.getText();
            Date dobDate =  dobField.getDate();
            String dob = (new SimpleDateFormat("dd-MM-yyyy")).format(dobDate);
            String salary = salaryField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String education = educationField.getText();
            String designation = designationField.getText();
            String empId = employeeIdField.getText();

            try{
                Conn c = new Conn();
                String query="insert into employee values('"+name+"','"+lastname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+empId+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new Home();

            }catch (Exception err){
                err.printStackTrace();

            }
        }else {
            setVisible(false);
            new Home();

        }
    }
}
