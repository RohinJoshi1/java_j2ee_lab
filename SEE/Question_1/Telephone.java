package SEE.Question_1;
import java.util.*;
/*
 * Write Java program to
Create a collection of contact lists (contact number and name)
Accept missed calls from the user and store them in another list. 
If the caller details exist in the contact list , 
retrieve the caller details else store as “private caller”. Store them in the order .
User can trace the missed call list and display them if required.
Delete the number if user specifies a number to delete.
Write main program to test the class.
 */
class Contact{
    String number;
    String name;
    Contact(String number,String name){
        this.number = number;
        this.name = name;
    }
    Contact(String number){
        this.number = number;
        this.name = "Private Caller";
    }
    public void printContactDetails(){
        String s = String.format("Name: %s ph_no: %s",this.name,this.number);
        System.out.println(s);
    }
}
public class Telephone {
    HashMap<String,String> contactList;
    LinkedList<Contact> missedCalls;
    public Telephone(){
        this.contactList = new HashMap<>();
        this.missedCalls = new LinkedList<>();
    }
    public void addContact(String number,String name){
        if(validateNumber(number)){ 
            contactList.put(number, name);
            System.out.println("Added contact");
        }
        else{
            System.out.println("Invalid number");
        }
        }
    private boolean validateNumber(String number) {
        if(number.length()!=10)return false;
        for(char c:number.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
    public void addMissedCall(String number){
        if(contactList.containsKey(number)){
            Contact c = new Contact(number,contactList.get(number));
            missedCalls.add(c);
            
        }else{
            Contact c = new Contact(number);
            missedCalls.add(c);
            
        }
        System.out.println("Added missed call");
    }
    public void displayMissedCalls(){
        if(missedCalls.size()==0){
            System.out.println("No missed calls");
            return;
        }
        for(Contact c:missedCalls){
            c.printContactDetails();
        }
    }
    public void deleteContact(String number){
        if(contactList.containsKey(number)){
            contactList.remove(number);
            System.out.println("Deleted successfully");
        }else{
            System.out.println("Number does not exist in contact list");
        }
    }
    public void displayContactList(){
        if(contactList.size()==0){
            System.out.println("Empty contact list");
            return;
        }
        else{
            for(Map.Entry<String,String> entry:contactList.entrySet()){
                String s = String.format("name: %s number: %s",entry.getValue(),entry.getKey());
                System.out.println(s);
            }
        }
        
    }
}
