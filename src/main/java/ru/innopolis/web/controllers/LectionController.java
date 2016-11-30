package ru.innopolis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.web.beans.Lection;
import ru.innopolis.web.dao.LectionDao;
import ru.innopolis.web.dao.LectionDaoImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by i.viktor on 28/11/2016.
 */
@Controller
public class LectionController {
    private LectionDao lectionDao;

    @Autowired
    public LectionController(LectionDao lectionDao) {
        this.lectionDao = lectionDao;
    }

    @RequestMapping("/lections")
    public String showLections(Model model) {
        List<Lection> list = lectionDao.getLections();
        model.addAttribute("list", list);
        return "lections";
    }

    @RequestMapping(value = "/lections/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        lectionDao.deletLectionById(id);
        return "redirect:/lections";
    }

    @RequestMapping(value = "/lections/edit/{id}")
    public ModelAndView editLection(@PathVariable int id) {
        Lection lection = lectionDao.getLectionById(id);
        return new ModelAndView("/lections/edit", "command", lection);
    }

    @RequestMapping(value = "/lections/editsave", method = RequestMethod.POST)
    public ModelAndView editLection(@ModelAttribute("lection") Lection lection) {
        lectionDao.editLection(lection);
        return new ModelAndView("redirect:/lections");
    }

    @RequestMapping(value = "/lections/show/{id}")
    public String showLection(@PathVariable int id, Model model, HttpServletRequest request) {
        String login = request.getUserPrincipal().getName();

        System.out.println("DEBUG: " + login);
        Lection lection = lectionDao.getLectionById(id);
        model.addAttribute("lection", lection);
        model.addAttribute("login", login);
        return "/lections/show";
    }

    @RequestMapping("/lections/add")
    public String addLection() {
        return "/lections/add";
    }

    @RequestMapping(value = "/lections/addsave", method = RequestMethod.POST)
    public ModelAndView addLection(HttpServletRequest request) {
        String name = request.getParameter("name");
        String text = request.getParameter("text");
        lectionDao.addLection(new Lection(0, name, text));
        return new ModelAndView("redirect:/lections");
    }
}
