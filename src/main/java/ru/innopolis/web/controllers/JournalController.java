package ru.innopolis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.web.beans.Journal;
import ru.innopolis.web.dao.JournalDao;

import java.util.List;

/**
 * Created by i.viktor on 29/11/2016.
 */
@Controller
public class JournalController {
    private JournalDao journalDao;

    @Autowired
    public JournalController(JournalDao journalDao) {
        this.journalDao = journalDao;
    }

    @RequestMapping(value = "/users/journal/{id}")
    public String showJournal(@PathVariable int id, Model model) {
        List<Journal> list = journalDao.showJurnalByIdUser(id);
        model.addAttribute("list", list);
        return "/users/journal";
    }

}
