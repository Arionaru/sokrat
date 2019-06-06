package ru.ariona.sokrat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    SokratService sokratService;

    private final String host = "https://sokratitel.herokuapp.com";


    @GetMapping("/")
    public String mainPage() {
        return "mainpage";
    }

    @PostMapping
    public String doIt(@RequestParam String link, Model model) {
        Sokrat sokrat = sokratService.generate(link);
        model.addAttribute("link",host + sokrat.getShortLink());
        return "mainpage";
    }

    @GetMapping("/{shortLink}")
    public ModelAndView redirect(@PathVariable String shortLink) {
        Sokrat sokrat = sokratService.findByShortLink(shortLink);
        if (sokrat != null) {
            String path = sokrat.getUserLink();
            return new ModelAndView("redirect:" + path);
        }
        return new ModelAndView("mainpage", "link", "Ссылка не найдена!");
    }
}
