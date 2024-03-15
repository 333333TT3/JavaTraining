package org.example;
import java.util.Scanner;

public class Main {

    private static final UsersRepository REPOSITORY = new UsersRepository();
    private static int COUNTER = 1;
    private static final int LIST_USER_OPTION = 0;
    private static final int NEW_USER = 1;
    private static final int UPDATE_USER_INFO = 2;
    private static final int DELETE_USER = 3;
    private static final int  QUIT = 4;



    public static void main(String[] args) {

        printMenu();

        Scanner in = new Scanner(System.in);

        int selectedOption;
        do {
            System.out.println("Choose other option");
            selectedOption = Integer.parseInt(in.nextLine());
            if(selectedOption == LIST_USER_OPTION)
            {
                listUsers();
            }
            if (selectedOption == NEW_USER)
            {
                addUser(in);
            }
            if (selectedOption == UPDATE_USER_INFO)
            {
                updateUser(in);
            }

            if (selectedOption == DELETE_USER)
            {
                deleteUser(in);
            }
        } while (selectedOption != QUIT);
    }

    private static void listUsers() {
        REPOSITORY.listUsers().forEach(System.out::println);
    }

    private static void addUser(Scanner in) {
        System.out.println("Name: ");
        String name = in.nextLine();
        System.out.println("Second Name: ");
        String secName = in.nextLine();
        System.out.println("PhoneNumber: ");
        String PhoneNumber = in.nextLine();
        System.out.println("UserName: ");
        String UserName = in.nextLine();

        User user = new User();
        user.id = COUNTER ++;
        user.name = name;
        user.secName = secName;
        user.PhoneNumber = PhoneNumber;
        user.UserName = UserName;
        REPOSITORY.addUser(user);
    }

    private static void updateUser(Scanner in)
    {
        System.out.println("Set an ID for account to be updated: ");
        int i = Integer.parseInt(in.nextLine());

        System.out.println("Name: ");
        String name = in.nextLine();
        System.out.println("Second Name: ");
        String secName = in.nextLine();
        System.out.println("PhoneNumber: ");
        String PhoneNumber = in.nextLine();
        System.out.println("UserName: ");
        String UserName = in.nextLine();

        User user = new User();
        user.id = i;
        user.name = name;
        user.secName = secName;
        user.PhoneNumber = PhoneNumber;
        user.UserName = UserName;
        REPOSITORY.updateUser(user);
    }

    private static void deleteUser(Scanner in) {
        System.out.println("Set an ID for account to be removed: ");
        int id = Integer.parseInt(in.nextLine());
        REPOSITORY.deleteUser(id);
    }

    private static void printMenu()
    {
        System.out.println("Choose from these options");
        System.out.println("-------------------------");
        System.out.println("0 - List of users");
        System.out.println("1 - New user");
        System.out.println("2 - Update users info");
        System.out.println("3 - Delete user");
        System.out.println("4 - Quit");
        System.out.println("-------------------------");
    }
}