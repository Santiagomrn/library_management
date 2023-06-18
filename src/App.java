
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Controllers.BooksController;
import Controllers.ControllerInterface;
import Controllers.LendingsController;
import Controllers.MembersController;


public class App {
    public static void main(String[] args) throws Exception {
        ControllerInterface[] collection={new BooksController(), new MembersController()};
        List<ControllerInterface> controllers = new ArrayList<ControllerInterface>(Arrays.asList(collection));
        controllers.stream().parallel().forEach((c)->{
            c.load();
        });
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("7")) {
            System.out.println(
                    "1. Register member\n2. Register book\n3. Register lending\n4. Show members\n5. Show books\n6. show lendings \n7. exit\n Chose:");
            choice = sc.nextLine();
            if (choice.equals("1")) {
                MembersController.getDataToRegister();
            }
            if (choice.equals("2")) {
                BooksController.getDataToRegister();
            }
            if (choice.equals("3")) {
                LendingsController.getDataToRegister();
            }
            if (choice.equals("4")) {
                MembersController.printMembers(MembersController.get());
            }
            if (choice.equals("5")) {
                BooksController.printBooks(BooksController.get());
            }
            if (choice.equals("6")) {
                LendingsController.imprimirPrestamos(LendingsController.get());
            }
        }
        sc.close();
    }
}
