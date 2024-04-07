package hh.sof3.animationlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import hh.sof3.animationlist.domain.Animation;
import hh.sof3.animationlist.domain.AnimationRepository;
import hh.sof3.animationlist.domain.GenreRepository;
import hh.sof3.animationlist.domain.StudioRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class animationController {

    @Autowired
    private AnimationRepository animationRepository;

    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/animations")
    public String getMethodName(Model model) {

        model.addAttribute("animations", animationRepository.findAll());
        return "animationList";
    }

    @GetMapping("/newanimation")
    public String getNewAnimation(Model model) {
        model.addAttribute("newAnimation", new Animation());
        model.addAttribute("studios", studioRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "addanimation";

    }

    @PostMapping("/save")
    public String saveAnimation(@ModelAttribute("newAnimation") Animation newAnimation) {

        animationRepository.save(newAnimation);
        return "redirect:/animations";
    }

}
