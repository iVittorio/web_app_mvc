package ru.innopolis.web.dao;

import ru.innopolis.web.beans.Journal;

import java.util.List;

/**
 * Created by i.viktor on 30/11/2016.
 */
public interface JournalDao {
    void addEntryInJournal(String login, int id);

    List<Journal> showJurnalByIdUser(int id);
}
