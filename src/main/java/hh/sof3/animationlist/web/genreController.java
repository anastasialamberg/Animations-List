package hh.sof3.animationlist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3.animationlist.domain.Genre;
import hh.sof3.animationlist.domain.GenreRepository;
import hh.sof3.animationlist.domain.Studio;

@Controller
public class genreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/genre")
    public String showGenreList(Model model) {
        List<Genre> genres = (List<Genre>) genreRepository.findAll();
        model.addAttribute("genres", genres);
        return "genrelist";
    }

    @GetMapping("/addgenre")
    public String showAddGenreForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "addgenre";
    }

    @PostMapping("/savegenre")
    public String saveGenre(Genre genre) {
        genreRepository.save(genre);
        return "redirect:/genre";

    }
}
