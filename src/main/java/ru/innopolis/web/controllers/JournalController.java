package ru.innopolis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.web.beans.Journal;
import ru.innopolis.web.dao.JournalDao;

import javax.servlet.http.HttpServletRequest;
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
    public String showJournal(@PathVariable int id, HttpServletRequest request, Model model) {
        List<Journal> list = journalDao.showJurnalByIdUser(id);
        model.addAttribute("list", list);
        return "/users/journal";
    }

    @RequestMapping(value = "/lections/journal", method = RequestMethod.POST)
    public String addEntry(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        journalDao.addEntryInJournal(login, id);
        return "redirect:/lections";
    }

}
