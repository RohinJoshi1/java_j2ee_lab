import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import java.util.*;
public class StudentClass implements ActionListener{
    LinkedList<Student> students = new LinkedList<>();
    //Name, USN , address, sgpa 1->5 , age
    //##LABELS###
    JLabel jname = new JLabel("Enter name");
    JLabel jusn = new JLabel("Enter USN");
    JLabel jaddress = new JLabel("Enter address");
    JLabel jcat = new JLabel("Select Category");
    JLabel jage = new JLabel("Enter age");
    JLabel jsg1 = new JLabel("Enter sgpa 1");
    JLabel jsg2 = new JLabel("Enter sgpa 2");
    JLabel jsg3 = new JLabel("Enter sgpa 3");
    JLabel jsg4 = new JLabel("Enter sgpa 4");
    JLabel jsg5 = new JLabel("Enter sgpa 5");
    JLabel jcgpa = new JLabel("CGPA :");

    ///TEXTFIELDS
    JTextField name = new JTextField(20);
    JTextField usn = new JTextField(20);
    JTextArea address = new JTextArea(3,4);
    JTextField age = new JTextField(2);
    JComboBox cat = new JComboBox();
    JTextField sgpa1 = new JTextField(5);
    JTextField sgpa2 = new JTextField(5);
    JTextField sgpa3 = new JTextField(5);
    JTextField sgpa4 = new JTextField(5);
    JTextField sgpa5 = new JTextField(5);
    JTextField cgpa = new JTextField();
    JButton submit = new JButton("compute");
    JButton done = new JButton("Done");
    JButton display = new JButton("Display");
    JTextArea student_display = new JTextArea(20,20);
    JFrame f1 = new JFrame("Student Information");
    JFrame f2 = new JFrame("Student Collection Display");
    StudentClass(){
        jname.setBounds(10, 10, 10, 10);
        cat.addItem("GM");
        cat.addItem("SC/ST");
        f1.add(jname);f1.add(name);
        f1.add(jusn);f1.add(usn);
        f1.add(jaddress);f1.add(address);
        f1.add(jcat);f1.add(cat);
        f1.add(jage);f1.add(age);
        f1.add(jsg1);f1.add(sgpa1);
        f1.add(jsg2);f1.add(sgpa2);
        f1.add(jsg3);f1.add(sgpa3);
        f1.add(jsg4);f1.add(sgpa4);
        f1.add(jsg5);f1.add(sgpa5);
        f1.add(jcgpa);f1.add(cgpa);
        f1.add(submit);f1.add(done);f1.add(display);
        f2.add(student_display);
        f1.setSize(900,800);
        f1.setLayout(new GridLayout(40, 20));
        f1.setVisible(true);
        done.addActionListener(this);
        submit.addActionListener(this);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
   
    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource()==submit){
            try {
                int a = Integer.parseInt(age.getText());
                if(a<18 || a>30){
                    String age1 = JOptionPane.showInputDialog(null,"Invalid");
                    age.setText(age1);
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(f1,"invalid entry");
                age.requestFocus();
            }
            ArrayList<JTextField> sgpaList = new ArrayList<>();
            for(int i=0;i<5;i++){
                String sg = "sgpa"+i;
                Component[] components = f1.getComponents();
                JTextField tx;
                for(Component component:components){
                    if (component instanceof JTextField && component.getName().equals(sg)) {
                        tx= (JTextField) component;
                        sgpaList.add(tx);
                        checkSGPA(i,tx);
                        break;
                    }
                }
                }
            float _cgpa = calculate_cgpa(sgpaList);
            cgpa.setText(Float.toString(_cgpa));
        }
        else if(evt.getSource()==done){
            //String name,int age,String address,float cgpa,String category
            Student s1= new Student(name.getText(), Integer.parseInt(age.getText()),address.getText(), Float.parseFloat(cgpa.getText()), String.valueOf(cat.getSelectedItem()));
            students.add(s1);
        }else{
            f1.setVisible(false);
            f2.setVisible(true);
            f2.setSize(50,500);
            student_display.setText(" ");
            for(Student s:students){
                student_display.append(s.toString()+"\n");
            }
        }
      
        

        

    }
    public float calculate_cgpa(ArrayList<JTextField>  sgpaList){
        float res=0 ;
        for(JTextField sg:sgpaList){
            res+=Float.parseFloat(sg.getText());
        }
        res/=sgpaList.size();
        return res;
    }
    public void checkSGPA(int i,JTextField sgpa){
        try {
            if(Float.parseFloat(sgpa.getText())>10){
                String v1 = JOptionPane.showInputDialog(null,"Enter valid sgpa");
                sgpa.setText(v1);
            }
        } catch (Exception e) {
            String v2 = JOptionPane.showInputDialog(null, "Enter valid sgpa");
            sgpa.setText(v2);
        }
    }
    public static void main(String[] args) {
        StudentClass s = new StudentClass();
    }

}
