package hh.sof3.animationlist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import hh.sof3.animationlist.domain.Animation;
import hh.sof3.animationlist.domain.AnimationRepository;
import hh.sof3.animationlist.domain.GenreRepository;
import hh.sof3.animationlist.domain.StudioRepository;
import hh.sof3.animationlist.domain.UserRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class animationController {

    @Autowired
    private AnimationRepository animationRepository;

    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private UserRepository userRepository;

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
    public String saveAnimation(@Valid @ModelAttribute("newAnimation") Animation newAnimation,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addanimation";
        }
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

    // delete animation
    @GetMapping("/delete/{animation_id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteAnimation(@PathVariable("animation_id") Long animation_id, Model model) {
        animationRepository.deleteById(animation_id);
        return "redirect:/animations";
    }

    // Edit animation
    @GetMapping("/edit/{animation_id}")
    public String editAnimation(@PathVariable("animation_id") Long animation_id, Model model) {
        Optional<Animation> optionalAnimation = animationRepository.findById(animation_id);

        if (optionalAnimation.isPresent()) {
            Animation animation = optionalAnimation.get();
            model.addAttribute("animation", animation);
            model.addAttribute("studios", studioRepository.findAll());
            model.addAttribute("genres", genreRepository.findAll());
            return "editanimation";
        } else {
            return "redirect:/animations";
        }

    }

    // Update animation
    @PostMapping("/update/{animation_id}")
    public String updateAnimation(@PathVariable("animation_id") Long animation_id,
            @ModelAttribute("animation") Animation updateAnimation) {
        animationRepository.save(updateAnimation);
        return "redirect:/animations";

    }

}
