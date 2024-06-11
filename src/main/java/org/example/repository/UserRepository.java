package org.example.repository;

import org.example.domain.DAO.UserDAO;
import org.example.domain.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class UserRepository implements BaseRepository<User>{
    private static final String SAVE = "select * from save_user(?,?,?,?)";
    private static final String SIGN_IN = "select * from sign_in(?,?)";
    private static final String SEARCH = "select * from search_username(?, ?::uuid)";

    @Override
    public String save(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPosition());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String update(UUID id, User update) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }

    public Optional<User> signIn(String username, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SIGN_IN)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(User.map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
    public ArrayList<UserDAO> searchByUsername(String partOfUsername, UUID id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH)) {
            preparedStatement.setString(1, partOfUsername);
            preparedStatement.setString(2, id.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<UserDAO> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(UserDAO.map(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
