package ru.innopolis.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.web.beans.Journal;
import ru.innopolis.web.dao.JournalDao;

import java.util.List;

/**
 * Created by i.viktor on 02/12/2016.
 */
@Component
public class JournalServiceImpl implements JournalService {
    private JournalDao journalDao;

    @Autowired
    public JournalServiceImpl(JournalDao journalDao) {
        this.journalDao = journalDao;
    }

    @Override
    public List<Journal> showJurnalByIdUser(int id) {
        return journalDao.showJurnalByIdUser(id);
    }

    @Override
    public void addEntryInJournal(String login, int id) {
        journalDao.addEntryInJournal(login, id);
    }
}
