package ru.innopolis.web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.web.beans.Lection;
import ru.innopolis.web.beans.User;

import java.util.List;
import java.util.Set;

/**
 * Created by i.viktor on 04/12/2016.
 */
@Repository
public class UserDaoHibernate implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<User> showUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public Set<Lection> getUserLection(int id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        return user.getLectionSet();
    }

    @Override
    public void addLectionInJournal(String login, int lection_id) {
        Lection lection = sessionFactory.getCurrentSession().get(Lection.class, lection_id);
        User user = getUserByLogin(login);
        Set<Lection> lectionSet = user.getLectionSet();
        lectionSet.add(lection);
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User getUserByLogin(String login) {
        String hql = "select user from User user where user.login = :login";
        return (User) sessionFactory.getCurrentSession().createQuery(hql).setParameter("login",login).uniqueResult();
    }
}
