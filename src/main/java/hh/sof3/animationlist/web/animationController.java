package hh.sof3.animationlist.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import hh.sof3.animationlist.domain.Animation;
import hh.sof3.animationlist.domain.AnimationRepository;
import hh.sof3.animationlist.domain.GenreRepository;
import hh.sof3.animationlist.domain.StudioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class animationController {

    @Autowired
    private AnimationRepository animationRepository;

    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private GenreRepository genreRepository;

    // Find all animations
    @GetMapping("/animations")
    public String getMethodName(Model model) {

        model.addAttribute("animations", animationRepository.findAll());
        return "animationList";
    }

    // Create new animation
    @GetMapping("/newanimation")
    public String getNewAnimation(Model model) {
        model.addAttribute("newAnimation", new Animation());
        model.addAttribute("studios", studioRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "addanimation";

    }

    // save new animation
    @PostMapping("/save")
    public String saveAnimation(@ModelAttribute("newAnimation") Animation newAnimation) {

        animationRepository.save(newAnimation);
        return "redirect:/animations";
    }

    // Votes

    @PostMapping("/vote/{animation_id}")
    public String voteAnimation(@PathVariable Long animation_id) {
        Optional<Animation> optionalAnimation = animationRepository.findById(animation_id);
        if (optionalAnimation.isPresent()) {
            Animation animation = optionalAnimation.get();
            animation.setVotes(animation.getVotes() + 1);
            animationRepository.save(animation);
        }
        return "redirect:/animations";
    }

}
