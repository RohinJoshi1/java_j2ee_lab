/**
 * Student
 */
public class Student {
    String name;
    int age;
    String usn;
    String address;
    float cgpa;
    String category;
    public Student(String name,int age,String address,float cgpa,String category){
        this.name=name;
        this.age=age;
        this.address =address;
        this.cgpa=cgpa;
        this.category=category;
    }
    public String toString(){
        return name+" "+usn+" "+address+" "+cgpa+" "+category;
    }
    
    
}