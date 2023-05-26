package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import javax.swing.*;
/*
 * /*
 * Write a java program using Swings to validate user login information using dialog boxes.
a. Once validated, allow the user to enter the customer id, if the person is a new customer,
 else check whether the customer exists in a collection and obtain the customer id.
b. The customer id can be obtained given a mobile number. Allow the user to enter the item purchased
by giving the item id and quantity purchased.
c. On clicking of a button, the item name and the total cost should appear in the corresponding GUI components.
d. Using option dialog box, indicate the types of discount available for the customer.
On clicking on the print button, print the details in information dialog box.
 */
class ItemDetails{
    int id;
    float cost;
    String name;
    ItemDetails(int id,float cost,String name){
        this.id = id;
        this.cost=cost;
        this.name=name;
    }
    public String toString(){
        String s = String.format("id: %d cost: %f name:%s", id,cost,name);
        return s;
    }
}
public class Login implements ActionListener {
    //Map for storing no-> id
     HashMap<String,Integer> map = new HashMap<>();
     ArrayList<ItemDetails> items = new ArrayList<>();
    void add_collection(){
        map.put("1234567890",1);
        map.put("1234567891",2);
        map.put("1234567892",3);

    }
    void init(){
        add_collection();
    }
    int check_collection(String num){
        init();
        if(map.containsKey(num)){
            return map.get(num);
        }
        return -1;
    }
    //Required Components
    //Main page
    JFrame f1 = new JFrame("Customer info");
    JFrame f2 = new JFrame("Customer info");
    JLabel custID = new JLabel("Customer id");
    JTextField jcustID = new JTextField(20);
    JLabel iid = new JLabel("Enter item id");
    JTextField jiid = new JTextField(20);
    JLabel iname = new JLabel("Name");
    JTextField jiname = new JTextField(20);
    JLabel icost = new JLabel("Item cost");
    JTextField jicost = new JTextField(20);
    JLabel quantity = new JLabel("Enter quantity");
    JTextField jquantity = new JTextField(20);

    JButton display = new JButton("Display item details");

    //Number checker
    JLabel number = new JLabel("Enter number");
    JTextField jnumber = new JTextField(20);
    JButton check = new JButton("Check number");


    public Login(){
        //Page 1 : Username + password
        String uname = JOptionPane.showInputDialog(null,"Enter valid username");
        String password = JOptionPane.showInputDialog(null,"Enter password");
        if(uname.equals("r@gmail.com") && password.equals("hello"))
        {
            //If validated, we go to the number page
            JPanel jp = new JPanel();
            jp.add(number);
            jp.add(jnumber);
            jp.add(check);
            f1.add(jp);
            f1.setSize(200, 200);
            f1.setVisible(true);
            //Now we check the number
            check.addActionListener(this);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid input");
        }
        display.addActionListener(this);
    }
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource()==check){
            f1.setVisible(false);
            JPanel jp = new JPanel();
            jp.add(custID);
            jp.add(jcustID);
            jp.add(iid);
            jp.add(jiid);
            jp.add(quantity);
            jp.add(jquantity);
            jp.add(display);
            jp.add(iname);
            jp.add(jiname);
            jp.add(icost);
            jp.add(jicost);
            f2.add(jp);
            int v = check_collection(number.getText());
            custID.setText(Integer.toString(v));
            if(v==-1){
                String cid = JOptionPane.showInputDialog(null,"Enter customer ID");
                jcustID.setText(cid);
            }
            f2.setVisible(true);

        }
        else{
            int v1 = Integer.parseInt(jiid.getText());
            int quantity = Integer.parseInt(jquantity.getText());
            checkItem(v1,quantity);

        }

    }

    private void checkItem(int v1, int quantity) {
        for(ItemDetails item:items){
            if(item.id == v1){
                jiname.setText(item.name);
                jicost.setText(Float.toString(quantity*item.cost));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login l = new Login();
        l.init();
        for(int i=0;i<2;i++){
            System.out.println("Enter item id");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("Enter name");
            String name = sc.nextLine();
            System.out.println("Enter cost");
            float cost = Float.parseFloat(sc.nextLine());
            ItemDetails item = new ItemDetails(id,cost,name);
            l.items.add(item);
        }

    }
}
