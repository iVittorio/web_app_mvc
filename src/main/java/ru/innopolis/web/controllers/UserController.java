package ru.innopolis.web.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.web.beans.User;
import ru.innopolis.web.constants.Role;
import ru.innopolis.web.constants.Sex;
import ru.innopolis.web.service.UserService;

import java.util.List;

/**
 * Created by i.viktor on 28/11/2016.
 */
@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String redirect() {
        return "signin";
    }

    @RequestMapping("/users")
    public String showUsers(Model model) {
        List<User> list = userService.showUsers();
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

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/signup/add", method = RequestMethod.POST)
    public String addUser(
            @RequestParam(name = "login") String login,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "fullName") String fullName,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "sex") String sex) {
        userService.addUser(new User(0, login, DigestUtils.md5Hex(password), email, fullName, Role.ROLE_STUDENT, Sex.valueOf(sex)));
        return "redirect:/signin";
    }
}
