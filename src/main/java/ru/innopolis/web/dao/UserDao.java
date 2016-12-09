package ru.innopolis.web.dao;

import ru.innopolis.web.beans.Lection;
import ru.innopolis.web.beans.User;

import java.util.List;
import java.util.Set;

/**
 * Created by i.viktor on 30/11/2016.
 */
public interface UserDao {
    List showUsers();

    void addUser(User user);

    Set<Lection> getUserLection(int id);

    void addLectionInJournal(String login, int lection_id);

    User getUserByLogin(String login);
}
