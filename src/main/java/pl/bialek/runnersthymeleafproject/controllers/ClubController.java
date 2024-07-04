package pl.bialek.runnersthymeleafproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bialek.runnersthymeleafproject.DTO.ClubDTO;
import pl.bialek.runnersthymeleafproject.models.Club;
import pl.bialek.runnersthymeleafproject.service.ClubService;

import java.util.List;

@Controller
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping("/clubs")
    public String getClubs(Model model) {
        List<ClubDTO> clubs = clubService.findAll();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club = new Club();
        model.addAttribute("club",club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") Club club){
        clubService.saveClub(club);
        return "redirect:/clubs";
    }
}