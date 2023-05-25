package SEE.Question_5;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;



/*
 * Write a program that uses Java Swing and JDBC to create a stand-alone application:
i. Create a table namely,
a. [X]Customer (CustNo, CustName, State, Credit_Limit, RepNo) in MySQL database. CustNo is the primary key
ii. Use appropriate Swing components to insert values in a form.
iii. Display Customer information when Credit_Limit is above 15,000.
 */

public class Main implements ActionListener {
    JLabel CustNo = new JLabel("Enter cust Number");
    JLabel CustName = new JLabel("Enter name");
    JLabel State = new JLabel("Enter state");
    JLabel credit_limit = new JLabel("Credit limit");
    JLabel RepNo = new JLabel("RepNo");

    JTextField jcustno = new JTextField(20);
    JTextField jcustname = new JTextField(20);
    JTextField jstate = new JTextField(20);
    JTextField jcreditlimit = new JTextField(20);
    JTextField jrepno = new JTextField(20);

    JButton add = new JButton("Add");
    JButton display = new JButton("Display");
    JTextArea res = new JTextArea(40,40);

    JFrame f1 = new JFrame("Card details");

    public Main(){
        f1.setLayout(new FlowLayout(30));
        f1.setSize(800,800);
        f1.add(CustNo);
        f1.add(jcustno);
        f1.add(CustName);
        f1.add(jcustname);
        f1.add(State);
        f1.add(jstate);
        f1.add(credit_limit);
        f1.add(jcreditlimit);
        f1.add(RepNo);
        f1.add(jrepno);
        f1.add(add);
        f1.add(display);
        f1.add(res);
        add.addActionListener(this);
        display.addActionListener(this);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        DBConn db = new DBConn();
        if(evt.getSource()==add){
            try {
                String query = String.format("Insert into Customer values (%d,'%s','%s',%d,%d)", Integer.parseInt(jcustno.getText()),jcustname.getText(),jstate.getText(),Integer.parseInt(jcreditlimit.getText()),Integer.parseInt(jrepno.getText()));
                db.update(query);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                String s = db.display();
                res.setText(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
    	Main m = new Main();
    }

}
