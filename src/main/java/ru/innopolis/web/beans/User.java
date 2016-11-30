package ru.innopolis.web.beans;

import ru.innopolis.web.constants.Role;
import ru.innopolis.web.constants.Sex;

/**
 * Created by i.viktor on 28/11/2016.
 */
public class User {
    private int id;
    private String login;
    private String email;
    private String fullName;
    private Role role;
    private Sex sex;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public User(int id, String login, String email, String fullName, Role role, Sex sex) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.sex = sex;
    }
}
