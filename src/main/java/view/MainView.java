package view;

import controller.UserController;
import java.util.Scanner;


public class MainView {


    private Scanner scanner = new Scanner(System.in);
    private UserController userController = new UserController();


    public void startProgram() {

        System.out.println(" Welcome to Profile Management System ");

        while (true) {

            showMenu();

            System.out.print("Choose: ");
            int choice = scanner.nextInt();


            scanner.nextLine();

            if (choice == 1) {
                addUser();


            } else if (choice == 2) {
                viewAllUsers();


            } else if (choice == 3) {
                viewUserById();


            } else if (choice == 4) {
                System.out.println("Exiting program... Goodbye!");
                System.exit(0);

                // Invalid choice
            } else {
                System.out.println("Invalid choice! Please choose 1, 2, 3 or 4.");
            }
        }
    }


    public void showMenu() {
        System.out.println("\n Profile Management System ");
        System.out.println("1. Add User Profile");
        System.out.println("2. View All Users");
        System.out.println("3. View My Profile (by ID)");
        System.out.println("4. Exit");
    }

    public void addUser() {

        System.out.println("\n Add New User Profile ");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Calling UserController to add the user
        boolean result = userController.addUser(name, email, password);

        if (result) {
            System.out.println("User profile added successfully!");
        } else {
            System.out.println("Failed to add user profile. Please try again.");
        }
    }



    public void viewAllUsers() {

        System.out.println("\n View All User Profiles");

        // Calling UserController which calls UserDAO to fetch all users
        userController.showAllUsers();
    }



    public void viewUserById() {

        System.out.println("\n View My Profile ");

        System.out.print("Enter your ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        userController.showUserById(id);
    }



    public static void main(String[] args) {

        MainView mainView = new MainView();
        mainView.startProgram();
    }
}