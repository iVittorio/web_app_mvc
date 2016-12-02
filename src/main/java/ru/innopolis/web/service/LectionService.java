package ru.innopolis.web.service;

import ru.innopolis.web.beans.Lection;

import java.util.List;

/**
 * Created by i.viktor on 02/12/2016.
 */
public interface LectionService {
    List<Lection> getLections();

    void deleteLectionById(int id);

    Lection getLectionById(int id);

    void editLection(Lection lection);

    void addLection(Lection lection);
}
