package controller;

import dao.UserDAO;
import model.User;

import java.util.List;


public class UserController {

    private UserDAO userDAO = new UserDAO();

    public boolean addUser(String name, String email, String password) {

        User user = new User(name, email, password);

        return userDAO.insertUser(user);
    }


    public void showAllUsers() {

        List<User> users = userDAO.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("\n All User Profiles");

            for (User user : users) {
                System.out.println(user);
            }
        }
    }


    public void showUserById(int id) {

        User user = userDAO.getUserById(id);

        if (user == null) {
            System.out.println("No user found with ID: " + id);
        } else {
            System.out.println("\n Your Profile ");
            System.out.println(user);
        }
    }
}