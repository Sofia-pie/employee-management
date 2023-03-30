import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice empIdField;
    JButton delete,back;
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel empIdLabel = new JLabel("Employee Id");
        empIdLabel.setBounds(50,50,100,30);
        add(empIdLabel);

        empIdField = new Choice();
        empIdField.setBounds(200,50,150,30);
        add(empIdField);

        try{
            Conn c =new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                empIdField.add(rs.getString("empId"));
            }
        }catch(Exception err){
            err.printStackTrace();
        }

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,100,100,30);
        add(nameLabel);

        JLabel nameLbl = new JLabel();
        nameLbl.setBounds(200,100,100,30);
        add(nameLbl);

        JLabel lastnameLabel = new JLabel("Last Name");
        lastnameLabel.setBounds(50,150,100,30);
        add(lastnameLabel);

        JLabel lastnameLbl = new JLabel();
        lastnameLbl.setBounds(200,150,100,30);
        add(lastnameLbl);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50,200,100,30);
        add(emailLabel);

        JLabel emailLbl = new JLabel();
        emailLbl.setBounds(200,200,100,30);
        add(emailLbl);



        empIdField.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try{
                        Conn c =new Conn();
                        String query = "select * from employee where empId='"+empIdField.getSelectedItem()+"'";
                        ResultSet rs = c.s.executeQuery(query);
                        while (rs.next()){
                            nameLbl.setText(rs.getString("name"));
                            lastnameLbl.setText(rs.getString("lastname"));
                            emailLbl.setText(rs.getString("email"));
                        }
                    }catch(Exception err){
                        err.printStackTrace();
                    }
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.addActionListener(this);
        add(back);

        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where empId='"+ empIdField.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Information Deleted");
                setVisible(false);
                new Home();
            }catch(Exception err){
                err.printStackTrace();
            }

        }
        else {
            setVisible(false);
            new Home();
        }

    }



}
