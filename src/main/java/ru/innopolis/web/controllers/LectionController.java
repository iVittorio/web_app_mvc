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
import ru.innopolis.web.service.LectionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by i.viktor on 28/11/2016.
 */
@Controller
public class LectionController {
    private LectionService lectionService;

    @Autowired
    public LectionController(LectionService lectionService) {
        this.lectionService = lectionService;
    }

    @RequestMapping("/lections")
    public String showLections(Model model) {
        List<Lection> list = lectionService.getLections();
        model.addAttribute("list", list);
        return "lections";
    }

    @RequestMapping(value = "/lections/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        lectionService.deleteLectionById(id);
        return "redirect:/lections";
    }

    @RequestMapping(value = "/lections/edit/{id}")
    public ModelAndView editLection(@PathVariable int id) {
        Lection lection = lectionService.getLectionById(id);
        return new ModelAndView("/lections/edit", "command", lection);
    }

    @RequestMapping(value = "/lections/editsave", method = RequestMethod.POST)
    public ModelAndView editLection(@ModelAttribute("lection") Lection lection) {
        lectionService.editLection(lection);
        return new ModelAndView("redirect:/lections");
    }

    @RequestMapping(value = "/lections/show/{id}")
    public String showLection(@PathVariable int id, Model model, HttpServletRequest request) {
        String login = request.getUserPrincipal().getName();
        Lection lection = lectionService.getLectionById(id);
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
        lectionService.addLection(new Lection(0, name, text));
        return new ModelAndView("redirect:/lections");
    }
}
