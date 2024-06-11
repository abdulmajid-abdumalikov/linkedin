package org.example.service;

import org.example.domain.DAO.UserDAO;
import org.example.domain.model.User;
import org.example.repository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class UserService implements BaseService<User> {
    private static final UserRepository userRepository = new UserRepository();
    @Override
    public String save(User user) {
        return userRepository.save(user);

    }

    @Override
    public String update(UUID id, User update) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User signIn(String username, String password) {
        return userRepository.signIn(username, password).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public ArrayList<UserDAO> searchByUsername(String partOfUsername, UUID id) {
        return userRepository.searchByUsername(partOfUsername, id);
    }
}
