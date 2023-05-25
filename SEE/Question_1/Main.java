package SEE.Question_1;
/*
 * Write Java program to
[X]Create a collection of contact lists (contact number and name)
[X]Accept missed calls from the user and store them in another list. 
[X]If the caller details exist in the contact list , 
retrieve the caller details else store as “private caller”. Store them in the order .
[X]User can trace the missed call list and display them if required.
[X]Delete the number if user specifies a number to delete.
Write main program to test the class.
 */
public class Main {

    public static void main(String[] args) {
        Telephone tp = new Telephone();
        tp.addContact("1234567890","Ram");
        tp.addContact("1234567891","Ram2");
        tp.addContact("1234567892","Ram3");
        tp.addMissedCall("1234567890");
        tp.addMissedCall("1234567899");
        tp.displayMissedCalls();
        tp.displayContactList();
        tp.deleteContact("1234567890");
    }
}
