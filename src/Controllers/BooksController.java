package Controllers;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import Entities.Book;


public class BooksController implements ControllerInterface {
    private static ArrayList<Book> books= new ArrayList<>();
    @Override
    public void load(){
        books.add(new Book("1", "Book 1", "Miker", true));    
        books.add(new Book("2", "Book 2", "Miker", true));    
        books.add(new Book("3", "Book 3", "Miker", true));  
        System.out.println("Books Successfully loaded");  
    }
    public static void getDataToRegister() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter book code:");
            String code = sc.nextLine();
            System.out.println("Enter book title:");
            String title = sc.nextLine();
            System.out.println("Enter book author:");
            String author = sc.nextLine();
            System.out.println("The book is available? [true/false]");
            boolean available = Boolean.valueOf(sc.nextLine());
            BooksController.register(new Book(code, title, author, available));
        }
        System.out.println("Book successfully registered");
    }
    
    public static void register(Book book){
        books.add(book);
    }

    public static ArrayList<Book> get(){
        return books;
    }

    public static Book findBookByCode(String code){
        return books.stream().filter(book -> code.equals(book.getCode())).findAny().orElse(null);
    }

    public static void setAsLent(Book book ){
        book.setAvailable(false);
    }

    public static void printBooks(ArrayList<Book> books) {
        System.out.println(
                "+-----+----------+----------------------------------------+--------------------+----------+");
        System.out.printf("|%-5s|%-10s|%-40s|%-20s|%-10s|\n", "No", "Code", "Title", "Author",
                "Available");
        System.out.println(
                "+-----+----------+----------------------------------------+--------------------+----------+");

        for (int x = 0; x < books.size(); x++) {
            Book book = books.get(x);
            System.out.printf("|%-5d|%-10s|%-40s|%-20s|%-10s|\n", x + 1, book.getCode(),
                    book.getTitle(),
                    book.getAuthor(), book.isAvailable() ? "Si" : "No");
            System.out.println(
                    "+-----+----------+----------------------------------------+--------------------+----------+");
        }
    }
    public static boolean lendBook(Book book){
   
        if(book.isAvailable()){
            BooksController.setAsLent(book);
            return true;
        }else{
            System.out.println("The book is not currently available");
            return false;
        }      
    }

    public static Book selectBook(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter book code: ");
            String code = sc.nextLine();
            Book book=BooksController.findBookByCode(code);
            if(Objects.isNull(book)) {
                System.out.println("The book does not exist");
            }else{
                if(book.isAvailable()){
                    sc.close();
                    return book;
                }else{
                    System.out.println("The book is not currently available");
                }  
            }
         
        }
    }
}
