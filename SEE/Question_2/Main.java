/*
 * 2. Write a Java program using user-defined storage classes to create a book database and 
 * store it in a Collection List. Books collection should include title, author, publisher and price.
Write method to sort the books in ascending order of price and store it in another List.
Maintain the book details with respect to an unique book id.
Prompt for an author name and list all the books with the same author’s name.
Create a new list holding all the book details with price greater than a user specified price.
For a given value by the user, find all the books that match either the whole or a part of the book title.
Identify a publisher and print books from a particular publisher. Update the publisher details based on a title.
 */
public class Main {
    public static void main(String[] args) {
        BookDatabase db = new BookDatabase();
        db.AddBook();
        db.AddBook();
        db.AddBook();
        db.printList(true);
        System.out.println("#####");
        db.printList(false);
        db.filterByPrice(10);
        db.searchBooksByAuthor("Ram");
        db.similaritySearch("Hello");
        System.out.println("Finish");
    }
}
