import java.util.*;
/*2. Write a Java program using user-defined storage classes to 
create a book database and store it in a Collection List. Books collection should include title, author, publisher and price.
Write method to sort the books in ascending order of price and store it in another List.
Maintain the book details with respect to an unique book id.
Prompt for an author name and list all the books with the same author’s name.
Create a new list holding all the book details with price greater than a user specified price.
For a given value by the user, find all the books that match either the whole or a part of the book title.
Identify a publisher and print books from a particular publisher. Update the publisher details based on a title. */
class Book {
    String title,author,publisher;
    int id;
    int counter =0;
    int price;
    Book(String title,String author,String publisher,int price){
        this.id = ++counter;
        this.title =title;
        this.author =author;
        this.publisher = publisher;
        this.price = price;
    }
    void printDetails(){
        String s = String.format("ID: %d\ntitle: %s\n Author: %s\n Publisher: %s\n Price: %d\n",id,title,author,publisher,price);
        System.out.println(s);
    }
}
public class BookDatabase {
    ArrayList<Book> books;
    Scanner sc = new Scanner(System.in);
    public BookDatabase(){
        books = new ArrayList<>();
    }
    public void AddBook(){
        System.out.println("Enter title");
        String title = sc.nextLine();
        System.out.println("Enter author");
        String auth= sc.nextLine();
        System.out.println("Enter publisher");
        String publisher = sc.nextLine();
        System.out.println("Enter price");
        int price = Integer.parseInt(sc.nextLine());
        if(price<0){
            System.out.println("Invalid price, setting it to 100");
            price = 100;
        }
        addBook(title, auth, publisher, price);

    }
    private void addBook(String title,String author,String publisher,int price){
        //Check if the book exists, we will see later if required
        Book b = new Book(title, author, publisher, price);
        books.add(b);
    }
    public ArrayList<Book> sortBooks(){
        ArrayList<Book> copy = new ArrayList<>(books);
        copy.sort((Book b1,Book b2)-> b1.price -b2.price);
        return copy;
    }
    void printList(boolean sorted){
        if(sorted){
            ArrayList<Book> s = sortBooks();
            for(Book b: s){
                b.printDetails();
            }
        }else{
            for(Book b:books){
                b.printDetails();
            }
        }
    }
    //Updated java syntax cuz I'm lazy
    void filterByPrice(int price){
        books.stream().filter((Book b ) -> b.price > price).forEach(System.out::println);
    }
    void similaritySearch(String phrase){
        for(Book b: books){
            if(b.title.contains(phrase)){
                b.printDetails();
            }
        }
    }
    void searchBooksByAuthor(String author){
        books.stream().filter((Book b)-> b.author.equals(author)).forEach(System.out::println);
    }

}
