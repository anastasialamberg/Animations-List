package hh.sof3.animationlist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import hh.sof3.animationlist.domain.Studio;
import hh.sof3.animationlist.domain.StudioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class studioController {

    @Autowired
    private StudioRepository studioRepository;


    // find all studios
    @GetMapping("/studio")
    public String showStudioList(Model model) {
        List<Studio> studios = (List<Studio>) studioRepository.findAll();
        model.addAttribute("studios", studios);
        return "studiolist";
    }

    // add new studio
    @GetMapping("/add")
    public String showAddStudioForm(Model model) {
        model.addAttribute("studio", new Studio());
        return "addstudio";
    }

    // save new studio
    @PostMapping("/savestudio")
    public String saveStudio(Studio studio) {
        studioRepository.save(studio);
        return "redirect:/studio";

    }

}
