package ru.innopolis.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.web.beans.User;
import ru.innopolis.web.dao.UserDao;

import java.util.List;


@Component
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> showUsers() {
        List<User> list = userDao.showUsers();
        return list;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
