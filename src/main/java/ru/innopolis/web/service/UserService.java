package ru.innopolis.web.service;

import ru.innopolis.web.beans.Lection;
import ru.innopolis.web.beans.User;

import java.util.List;
import java.util.Set;

/**
 * Created by i.viktor on 02/12/2016.
 */
public interface UserService {

    List<User> showUsers();

    void addUser(User user);

    Set<Lection> getUserLections(int id);

    void addLectionInJournal(String login, int lection_id);
}
