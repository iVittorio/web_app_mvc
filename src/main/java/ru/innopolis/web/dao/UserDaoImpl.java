package ru.innopolis.web.dao;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.innopolis.web.beans.User;
import ru.innopolis.web.constants.Role;
import ru.innopolis.web.constants.Sex;
import ru.innopolis.web.exception.MyException;

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
    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private DataSource dataSource;

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @ExceptionHandler(MyException.class)
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
            logger.error("Error with SQL in showUsers method", e);
            throw new MyException(e.getMessage());
        }
        return list;
    }

    @ExceptionHandler(MyException.class)
    public void addUser(User user, String password) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_USER_QUERY)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, DigestUtils.md5Hex(password));
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getSex().toString());
            preparedStatement.setString(6, user.getRole().toString());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error("Error with SQL in addUser method", e);
            throw new MyException(e.getMessage());
        }
    }

    @ExceptionHandler(MyException.class)
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
            logger.error("Error with SQL in getUserById method", e);
            throw new MyException(e.getMessage());
        }
        return user;
    }

    @ExceptionHandler(MyException.class)
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
            logger.error("Error with SQL in updateUser method", e);
            throw new MyException(e.getMessage());
        }
    }

    @ExceptionHandler(MyException.class)
    public void deleteUserById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error with SQL in deleteUserById method", e);
            throw new MyException(e.getMessage());
        }
    }

    @ExceptionHandler(MyException.class)
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
            logger.error("Error with SQL in verifyLoginData method", e);
            throw new MyException(e.getMessage());
        }
        return result;
    }
}
