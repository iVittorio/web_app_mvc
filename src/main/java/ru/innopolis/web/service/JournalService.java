package ru.innopolis.web.service;

import ru.innopolis.web.beans.Journal;

import java.util.List;

/**
 * Created by i.viktor on 02/12/2016.
 */
public interface JournalService {
    List<Journal> showJurnalByIdUser(int id);

    void addEntryInJournal(String login, int id);
}
