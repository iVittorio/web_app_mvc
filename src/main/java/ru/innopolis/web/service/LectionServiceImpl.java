package ru.innopolis.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.web.beans.Lection;
import ru.innopolis.web.dao.LectionDao;

import java.util.List;

/**
 * Created by i.viktor on 02/12/2016.
 */
@Component
public class LectionServiceImpl implements LectionService {

    private LectionDao lectionDao;

    @Autowired
    public LectionServiceImpl(LectionDao lectionDao) {
        this.lectionDao = lectionDao;
    }


    @Override
    public List<Lection> getLections() {
        return lectionDao.getLections();
    }

    @Override
    public void deleteLectionById(int id) {
        lectionDao.deletLectionById(id);
    }

    @Override
    public Lection getLectionById(int id) {
        return lectionDao.getLectionById(id);
    }

    @Override
    public void editLection(Lection lection) {
        lectionDao.editLection(lection);
    }

    @Override
    public void addLection(Lection lection) {
        lectionDao.addLection(lection);
    }
}
