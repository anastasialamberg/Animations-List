package hh.sof3.animationlist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import hh.sof3.animationlist.domain.Animation;
import hh.sof3.animationlist.domain.AnimationRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/api/animations")
public class AnimationRestController {

    @Autowired
    private AnimationRepository animationRepository;

    // get all rest animations
    @GetMapping
    public @ResponseBody List<Animation> animationsListRest() {
        return (List<Animation>) animationRepository.findAll();
    }

    // find by Id
    @GetMapping("/{animation_id}")
    public @ResponseBody Optional<Animation> findAnimationRest(@PathVariable("animation_id") Long animation_id) {
        return animationRepository.findById(animation_id);
    }

    // save new animation
    @PostMapping
    public @ResponseBody Animation saveAnimationRest(@RequestBody Animation animation) {
        return animationRepository.save(animation);

    }

}
