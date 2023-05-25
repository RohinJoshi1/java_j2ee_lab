package SEE.Question_3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/*
 * Create a desktop java application using swings to enable an user to enter student information 
 * such as name, usn, age, address, sgpa of 8 semesters, category.
Perform validations on age and sgpa.
Display appropriate messages in pop up boxes to indicate wrong entries,.
On clicking of the “compute” button, find the cgpa based on the obtained sgpa’s.
On clicking of the “done” button, place the student details in a collection.
A click on the “display” button should display the collection in a textarea.
 */

public class StudentInfo implements ActionListener {
    LinkedList<Student> students = new LinkedList<>();
    //create LABELS for name, usn, age, address, sgpa of 8 semesters, category
    JLabel name = new JLabel("Enter name");
    JLabel usn = new JLabel("Enter USN");
    JLabel age = new JLabel("Enter age");
    JLabel address = new JLabel("Enter address");
    JLabel sg1 = new JLabel("Enter sgpa1");
    JLabel sg2 = new JLabel("Enter sgpa2");
    JLabel sg3 = new JLabel("Enter sgpa3");
    JLabel sg4 = new JLabel("Enter sgpa4");
    JLabel sg5 = new JLabel("Enter sgpa5");
    JLabel sg6 = new JLabel("Enter sgpa6");
    JLabel sg7 = new JLabel("Enter sgpa7");
    JLabel sg8 = new JLabel("Enter sgpa8");
    JLabel cgpa = new JLabel("CGPA");
    JLabel category = new JLabel("Enter category");

    //We will have to give options for Category 
    JComboBox cat = new JComboBox();

    //TextArea for address
    JTextArea addr = new JTextArea(20,20);
    //Create TextFields for the same 
    JTextField jname = new JTextField(10);
    JTextField jusn = new JTextField(10);
    JTextField jage = new JTextField(3);
    JTextField jsg1 = new JTextField(3);
    JTextField jsg2 = new JTextField(3);
    JTextField jsg3 = new JTextField(3);
    JTextField jsg4 = new JTextField(3);
    JTextField jsg5 = new JTextField(3);
    JTextField jsg6 = new JTextField(3);
    JTextField jsg7 = new JTextField(3);
    JTextField jsg8 = new JTextField(3);
    JTextField jcgpa = new JTextField(3);
    JButton submit = new JButton("Compute");
    JButton done = new JButton("Done");
    JButton display = new JButton("Display");

    JTextArea student_display = new JTextArea(20,20);
    //One for the menu
    JFrame f1 = new JFrame("Student details");
    //One for the students
    JFrame f2 = new JFrame("Students");

    public StudentInfo(){
        name.setBounds(10,10,10,10);
        cat.addItem("GM");
        cat.addItem("SC/ST");
        cat.addItem("idk");
        f1.add(name);f1.add(jname);
        f1.add(usn);f1.add(jusn);
        f1.add(age);f1.add(jage);
        f1.add(address);f1.add(addr);
        f1.add(sg1);f1.add(jsg1);f1.add(sg2);f1.add(jsg2);f1.add(sg3);f1.add(jsg3);
        f1.add(sg4);f1.add(jsg4);f1.add(sg5);f1.add(jsg5);f1.add(sg6);f1.add(jsg6);
        f1.add(sg7);f1.add(jsg7);f1.add(sg8);f1.add(jsg8);
        f1.add(cgpa);f1.add(jcgpa);
        f1.add(submit);
        f1.add(done);
        f1.add(display);
        f1.setLayout(new FlowLayout(20));
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.add(student_display);
        f1.setSize(900,900);
        submit.addActionListener(this);
        done.addActionListener(this);
        display.addActionListener(this);
        


    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource()==submit){
            //We need to validate all this shit
            //Validate age and sgpa
            //AGE
            try {
                int a = Integer.parseInt(jage.getText());
                if(a < 18 || a > 25){
                    String _age = JOptionPane.showInputDialog(null,"Enter valid age");
                    age.setText(_age);
                }

                
            } catch (Exception e) {
                JOptionPane.showInputDialog(f1, "Enter valid age or u dumb");
                age.requestFocus();
            }
            //SGPA
            validate_SGPA(1,jsg1);
            validate_SGPA(2,jsg2);
            validate_SGPA(3,jsg3);
            validate_SGPA(4,jsg4);
            validate_SGPA(5,jsg5);
            validate_SGPA(6,jsg6);
            validate_SGPA(7,jsg7);
            validate_SGPA(8,jsg8);
            calculate_cgpa();
        }
        else if (ev.getSource() == done ){
            Student s1 = new Student(jname.getText(), jusn.getText(), addr.getText(), String.valueOf(cat.getSelectedItem()), Integer.parseInt(jage.getText()), Float.parseFloat(jcgpa.getText()));
            students.add(s1);
        }  else{
            f1.setVisible(false);
            f2.setSize(400,400);
            f2.setVisible(true);
            student_display.setText("null");
            f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            for(Student s:students){
                student_display.append(s.toString()+"\n");
            }
        }
    }
    private void calculate_cgpa(){
        float s1 = Float.parseFloat(jsg1.getText());
        float s2 = Float.parseFloat(jsg2.getText());
        float s3 = Float.parseFloat(jsg3.getText());
        float s4 = Float.parseFloat(jsg4.getText());
        float s5 = Float.parseFloat(jsg5.getText());
        float s6 = Float.parseFloat(jsg6.getText());
        float s7 = Float.parseFloat(jsg7.getText());
        float s8 = Float.parseFloat(jsg8.getText());
        float _cgpa = (s1+s2+s3 +s4 +s5 +s6 +s7+ s8)/8;

        jcgpa.setText(Float.toString(_cgpa));
    }
    private void validate_SGPA(int sem, JTextField sgpa) {
        try {
            float sg = Float.parseFloat(sgpa.getText());
            if(sg<0 || sg>10){
                String _sgpa = JOptionPane.showInputDialog(null, "invalid sgpa");
                sgpa.setText(_sgpa);
            }
            
        } catch (Exception e) {
            String _sgpa = JOptionPane.showInputDialog(null, "Enter for sem "+sem);
            sgpa.setText(_sgpa);
        }
    }




    public static void main(String[] args) {
        StudentInfo si = new StudentInfo();
    }


}
