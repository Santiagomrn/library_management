package Controllers;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Entities.Book;
import Entities.Lending;
import Entities.Member;

public class LendingsController {
       private static ArrayList<Lending> lendings= new ArrayList<>();

       public static void register(Lending lending){
              lendings.add(lending);
       }
       public static ArrayList<Lending> get(){
              return lendings;
       }
       public static int quantityOfLentBooks(String memberNumber, ArrayList<Lending> lendings) {
              int quantity = 0;
              for (int x = 0; x < lendings.size(); x++) {
              Lending lending = lendings.get(x);
              if (lending.getMemberNumber().equals(memberNumber)) {
                     quantity++;
              }
              }
              return quantity;
       }
       public static void imprimirPrestamos(ArrayList<Lending> lendings) {
              System.out.println("+-----+------------------------------+------------------------------+--------------------+");
              System.out.printf("|%-5s|%-30s|%-30s|%-20s|\n", "No", "Codigo libro", "No. Socio", "Fecha");
              System.out.println("+-----+------------------------------+------------------------------+--------------------+");

              for (int x = 0; x < lendings.size(); x++) {
              Lending lending = lendings.get(x);
              System.out.printf("|%-5d|%-30s|%-30s|%-20s|\n", x, lending.getBookCode(), lending.getMemberNumber(),
                     lending.getFormattedDate());
              System.out.println(
                     "+-----+------------------------------+------------------------------+--------------------+");
              }
       }
       public static void getDataToRegister() {
              BooksController.printBooks(BooksController.get());
              Book book = BooksController.selectBook();
              MembersController.printMembers(MembersController.get());
              Member member = MembersController.selectMember();
              LendingsController.register(new Lending(book.getCode(), member.getNumber(), LocalDateTime.now()));
              System.out.println("Lending successfully registered");
       }
}
