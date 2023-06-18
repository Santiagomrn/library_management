package Controllers;



import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import Entities.Lending;
import Entities.Member;

public class MembersController implements ControllerInterface{
    private static ArrayList<Member> members= new ArrayList<>();

    @Override
    public void load(){
        members.add(new Member("1", "Mike1", "his house"));
        members.add(new Member("2", "Mike2", "his house"));
        members.add(new Member("3", "Mike3", "his house"));
        System.out.println("Members Successfully loaded");  
    }
    public static void getDataToRegister(){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter member number: ");
            String number = sc.nextLine();
            System.out.println("Enter member name: ");
            String name = sc.nextLine();
            System.out.println("Enter member address: ");
            String address = sc.nextLine();
            MembersController.register(new Member(number, name, address));
        }
        System.out.println("Member successfully registered");
     
    }
    public static void register(Member member){
        members.add(member);
    }
    public static ArrayList<Member> get(){
        return members;
    }

    public static void printMembers(ArrayList<Member> members){
        ArrayList<Lending> lendings = LendingsController.get();
        System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        System.out.printf("|%-5s|%-10s|%-40s|%-40s|%-20s|\n", "#", "No. Member", "Name", "Address",
                "Libros prestados");
        System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        for (int x = 0; x < members.size(); x++) {
            Member member = members.get(x);
            System.out.printf("|%-5s|%-10s|%-40s|%-40s|%-20s|\n", x + 1, member.getNumber(), member.getName(),
                    member.getAddress(), LendingsController.quantityOfLentBooks(member.getNumber(), lendings));
            System.out.println(
                    "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        }
    }
    public static Member findMemberByNumber(String number){
        return members.stream().filter(member -> number.equals(member.getNumber())).findAny().orElse(null);
    }

    public static Member selectMember() {
  
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter member number: ");
            String numero = sc.nextLine();
            Member member = MembersController.findMemberByNumber(numero);
            if (Objects.isNull(member)) {
                System.out.println("The member does not exist");
            } else {
                sc.close();
                return member;
            }
        }
    }
}
