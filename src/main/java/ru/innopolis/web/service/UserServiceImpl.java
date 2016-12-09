package ru.innopolis.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.web.beans.Lection;
import ru.innopolis.web.beans.User;
import ru.innopolis.web.dao.UserDao;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> showUsers() {
        return (List<User>) userDao.showUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public Set<Lection> getUserLections(int id) {
        return userDao.getUserLection(id);
    }

    @Override
    @Transactional
    public void addLectionInJournal(String login, int lection_id) {
        userDao.addLectionInJournal(login, lection_id);
    }
}
