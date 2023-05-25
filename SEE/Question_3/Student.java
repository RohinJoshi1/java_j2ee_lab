package SEE.Question_3;
/*
 * /*
 * Create a desktop java application using swings to enable an user to enter student information such as
 *  name,
 *  usn, age, address, sgpa of 8 semesters, category.
Perform validations on age and sgpa. Display appropriate messages in pop up boxes to indicate wrong entries,.
On clicking of the “compute” button, find the cgpa based on the obtained sgpa’s.
On clicking of the “done” button, place the student details in a collection.
A click on the “display” button should display the collection in a textarea.
 */


public class Student {
    String name,usn,address,category;
    int age;
    float cgpa;
    public Student(String name,String usn,String address,String category,int age,float cgpa){
        this.name = name;
        this.usn=usn;
        this.address=address;
        this.category=category;
        this.age = age;
        this.cgpa = cgpa;
    }
    //A to String method for the display box
    public String toString(){
        return String.format("%s with usn %s of age %d living at %s, from category %s has a cgpa of %f ",name,usn,age,address,category,cgpa);
    }
}
