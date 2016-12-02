package ru.innopolis.web.dao;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.web.beans.User;
import ru.innopolis.web.constants.Role;
import ru.innopolis.web.constants.Sex;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.innopolis.web.constants.Queries.*;

/**
 * Created by i.viktor on 28/11/2016.
 */
public class UserDaoImpl implements UserDao {
    private DataSource dataSource;

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> showUsers() {
        List<User> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String fullName = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                Role role = Role.valueOf(resultSet.getString("role"));
                Sex sex = Sex.valueOf(resultSet.getString("sex"));
                list.add(new User(id, login, email, fullName, role, sex));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addUser(User user, String password) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_USER_QUERY)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getSex().toString());
            preparedStatement.setString(6, user.getRole().toString());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        User user = new User();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String fullName = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                Role role = Role.valueOf(resultSet.getString("role"));
                Sex sex = Sex.valueOf(resultSet.getString("sex"));
                user = new User(id, login, email, fullName, role, sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_USER_QUERY)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSex().toString());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int verifyLoginData(String login, String password) {
        int result = -1;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(VERIFY_LOGIN_DATA_QUERY)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idFromDB = resultSet.getInt("id");
                String passFromDB = resultSet.getString("password");
                if (DigestUtils.md5Hex(password).equals(passFromDB)) {
                    result = idFromDB;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
