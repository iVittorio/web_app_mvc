package ru.innopolis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.web.beans.User;
import ru.innopolis.web.dao.UserDao;
import ru.innopolis.web.dao.UserDaoImpl;

import java.util.List;

/**
 * Created by i.viktor on 28/11/2016.
 */
@Controller
public class UserController {

    private UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/")
    public String redirect() {
        return "signin";
    }

    @RequestMapping("/users")
    public String showUsers(Model model) {
        List<User> list = userDao.showUsers();
        model.addAttribute("list", list);
        return "users";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
        return "signin";
    }

    @RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
    public String signinFailure() {
        return "signin_failure";
    }

    /*@RequestMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userDaoImpl.deleteUserById(id);
        return "redirect:/users";
    }*/
}
