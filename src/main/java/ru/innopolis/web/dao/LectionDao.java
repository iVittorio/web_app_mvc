package ru.innopolis.web.dao;

import ru.innopolis.web.beans.Lection;

import java.util.List;

/**
 * Created by i.viktor on 30/11/2016.
 */
public interface LectionDao {
    List<Lection> getLections();

    Lection getLectionById(int id);

    void deletLectionById(int id);

    void addLection(Lection lection);

    void editLection(Lection lection);
}
