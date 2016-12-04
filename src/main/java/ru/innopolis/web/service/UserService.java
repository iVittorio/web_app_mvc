package ru.innopolis.web.service;

import ru.innopolis.web.beans.User;

import java.util.List;

/**
 * Created by i.viktor on 02/12/2016.
 */
public interface UserService {

    List<User> showUsers();

    void addUser(User user);
}
