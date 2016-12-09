package ru.innopolis.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.web.beans.Lection;
import ru.innopolis.web.dao.LectionDao;

import java.util.List;

/**
 * Created by i.viktor on 02/12/2016.
 */
@Service
public class LectionServiceImpl implements LectionService {

    private LectionDao lectionDao;

    @Autowired
    public LectionServiceImpl(LectionDao lectionDao) {
        this.lectionDao = lectionDao;
    }


    @Transactional
    public List<Lection> getLections() {
        return lectionDao.getLections();
    }

    @Transactional
    public void deleteLectionById(int id) {
        lectionDao.deletLectionById(id);
    }

    @Transactional
    public Lection getLectionById(int id) {
        return lectionDao.getLectionById(id);
    }

    @Transactional
    public void editLection(Lection lection) {
        lectionDao.editLection(lection);
    }

    @Transactional
    public void addLection(Lection lection) {
        lectionDao.addLection(lection);
    }
}
