package prog5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class question_five {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JLabel jnum = new JLabel("Enter customer number");
        JLabel jfname = new JLabel("Enter customer name");
        JLabel jstate = new JLabel("Enter state");
        JLabel jcredit_limit = new JLabel("Enter credit limit");

        JTextField num = new JTextField(20);
        JTextField name = new JTextField(20);
        JTextField state = new JTextField(20);
        JTextField credit_limit = new JTextField(20);

        JButton submit = new JButton("Submit");
        JButton show = new JButton("Show output");
        JTextArea output = new JTextArea(30,30);
        f.setLayout(new FlowLayout());
        f.add(jnum);
        f.add(num);
        f.add(jfname);
        f.add(name);
        f.add(jstate);
        f.add(state);
        f.add(jcredit_limit);
        f.add(credit_limit);
        f.add(submit);
        f.add(show);
        f.add(output);
        f.setVisible(true);
        f.setSize(800,800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Submit should insert entries to db;
        submit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                String _name = name.getText();
                int _num = Integer.parseInt(num.getText());
                String _state = state.getText();
                int _credit_limit = Integer.parseInt(credit_limit.getText());
                try {
                    Class.forName("com.mysql.jdbc.cj.Driver");
                    String url = "jdbc:mysql://localhost:3306/java_lab";
                    String user = "root";
                    String pw = "";
                    Connection conn = DriverManager.getConnection(url, user, pw);
                    if(conn!=null){
                        String query = String.format("insert into customer values (%d,'%s','%s',%d)",_num,_name,_state,_credit_limit);
                        conn.createStatement().executeUpdate(query);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            
        });
        show.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.cj.Driver");
                    String url = "jdbc:mysql://localhost:3306/java_lab";
                    String user = "root";
                    String pw = "";
                    Connection conn = DriverManager.getConnection(url, user, pw);
                    if(conn!=null){
                        String query = "select * from customers where credit_limit > 15000 ";
                        ResultSet rs = conn.createStatement().executeQuery(query);
                        String s ="";
                        while(rs.next()){
                            s+=rs.getInt(1)+" ";
                            s+=rs.getString(2)+" ";
                            s+=rs.getString(3)+" ";
                            s+=rs.getInt(4)+" ";
                            s+="\n";
                        }
                        System.out.println(s);
                        output.append(s);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            
        });
    }
}
