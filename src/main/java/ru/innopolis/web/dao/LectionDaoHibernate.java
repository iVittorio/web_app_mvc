package ru.innopolis.web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.web.beans.Lection;

import java.util.List;

/**
 * Created by i.viktor on 04/12/2016.
 */
@Repository
public class LectionDaoHibernate implements LectionDao {

    private SessionFactory sessionFactory;

    @Autowired
    public LectionDaoHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Lection> getLections() {
        return (List<Lection>) sessionFactory.getCurrentSession().createQuery("from Lection").list();
    }

    @Override
    public Lection getLectionById(int id) {
        return sessionFactory.getCurrentSession().get(Lection.class, id);
    }

    @Override
    public void deletLectionById(int id) {
        Lection load = sessionFactory.getCurrentSession().get(Lection.class, id);
        if (load != null) sessionFactory.getCurrentSession().delete(load);
    }

    @Override
    public void addLection(Lection lection) {
        sessionFactory.getCurrentSession().save(lection);
    }

    @Override
    public void editLection(Lection lection) {
        sessionFactory.getCurrentSession().saveOrUpdate(lection);
    }
}
