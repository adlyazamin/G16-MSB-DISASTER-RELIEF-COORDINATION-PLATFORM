package service;

import dao.UserDAO;
import model.User;

public class AuthService {

    private UserDAO userDAO = new UserDAO();

    // Register
    public boolean register(User user) {
        return userDAO.registerUser(user);
    }

    // Login
    public User login(String email, String password) {
        return userDAO.login(email, password);
    }

}