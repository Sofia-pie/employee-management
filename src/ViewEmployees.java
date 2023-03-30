import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class ViewEmployees extends JFrame implements ActionListener {

    JTable table;
    Choice employeeId;
    JButton search, print, update, back;
    ViewEmployees(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchLabel = new JLabel("Employee id");
        searchLabel.setBounds(20,20,150,20);
        add(searchLabel);

        employeeId = new Choice();
        employeeId.setBounds(180,20,150,20);
        add(employeeId);

        table = new JTable();

        try{
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from employee");

            Statement countStmt = c.c.createStatement();
            ResultSet countRs = countStmt.executeQuery("select count(*) from employee");
            countRs.next();
            int numRows = countRs.getInt(1);

            Statement stmt = c.c.createStatement();
            ResultSet r = stmt.executeQuery("select * from employee");
            while (r.next()){
                employeeId.add(r.getString("empId"));
            }

            TableModel model = resultSetToTableModel(rs,numRows);

            table.setModel(model);
            add(table);



        }catch( Exception err){
            err.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 900, 600);
        add(sp);

        search = new JButton("Search");
        search.setBounds(20, 70,90,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70,80,20);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLocation(300,100);
        setVisible(true);


    }



    private TableModel resultSetToTableModel(ResultSet rs, int numRows) throws SQLException {
        ResultSetMetaData rsm = rs.getMetaData();
        int numColumns = rsm.getColumnCount();
        String[] columnNames = new String[numColumns];
        for (int i = 0; i < numColumns; i++) {
            columnNames[i] = rsm.getColumnLabel(i + 1);
        }

        Object[][] rowData = new Object[numRows][numColumns];
        int rowCount = 0;
        while (rs.next()) {
            for (int i = 0; i < numColumns; i++) {
                rowData[rowCount][i] = rs.getObject(i + 1);
            }
            rowCount++;

        }

        return new DefaultTableModel(rowData, columnNames);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String query = "select * from employee where empId='"+employeeId.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                TableModel model = resultSetToTableModel(rs,1);
                table.setModel(model);

            }catch (Exception err){
                err.printStackTrace();
            }
            
        } else if (e.getSource() == print) {
            try{
                table.print();

            }catch(Exception err){
                err.printStackTrace();
            }
            
        }   else if (e.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(employeeId.getSelectedItem());
        }else {
            setVisible(false);
            new Home();
        }
    }
}
