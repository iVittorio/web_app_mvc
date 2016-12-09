package ru.innopolis.web.beans;

import ru.innopolis.web.constants.Role;
import ru.innopolis.web.constants.Sex;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by i.viktor on 28/11/2016.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "JOURNAL",
            joinColumns = {@JoinColumn(name = "ID_USER")},
            inverseJoinColumns = {@JoinColumn(name = "ID_LECTION")})
    private Set<Lection> lectionSet = new HashSet<>();


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Lection> getLectionSet() {
        return lectionSet;
    }

    public void setLectionSet(Set<Lection> lectionSet) {
        this.lectionSet = lectionSet;
    }

    public User(int id, String login, String password, String email, String fullName, Role role, Sex sex) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (fullName != null ? !fullName.equals(user.fullName) : user.fullName != null) return false;
        if (role != user.role) return false;
        return sex == user.sex;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role=" + role +
                ", sex=" + sex +
                '}';
    }
}
