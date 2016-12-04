package ru.innopolis.web.dao;

import ru.innopolis.web.beans.User;

import java.util.List;

/**
 * Created by i.viktor on 30/11/2016.
 */
public interface UserDao {
    List<User> showUsers();

    void addUser(User user);

    User getUserById(int id);

    void updateUser(User user);

    void deleteUserById(int id);

    int verifyLoginData(String login, String password);
}
