package pl.bialek.runnersthymeleafproject.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bialek.runnersthymeleafproject.DTO.ClubDTO;
import pl.bialek.runnersthymeleafproject.entity.Club;
import pl.bialek.runnersthymeleafproject.entity.UserEntity;
import pl.bialek.runnersthymeleafproject.security.SecurityUtil;
import pl.bialek.runnersthymeleafproject.service.ClubService;
import pl.bialek.runnersthymeleafproject.service.UserService;

import java.util.List;

@Controller
public class ClubController {


    private ClubService clubService;
    private UserService userService;
@Autowired
    public ClubController(ClubService clubService, UserService userService) {
        this.clubService = clubService;
        this.userService = userService;
    }

    @GetMapping("/clubs")
    public String getClubs(Model model) {
        UserEntity user = new UserEntity();
        List<ClubDTO> clubs = clubService.findAll();
        String username = SecurityUtil.getSesionUser();
        if(username!=null){
            user = userService.findByUsername(username);
            model.addAttribute("user",user);
        }
        model.addAttribute("user",user);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDTO clubDto,
                           BindingResult bindingResult,
                           Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("club",clubDto);
            return "clubs-create";
        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") Long clubId, Model model) {
        ClubDTO club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    @PostMapping("clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long clubId,
                             @Valid @ModelAttribute("club") ClubDTO club,
                             BindingResult bindingResult,
                             Model model) {
        club.setId(clubId);
        if (bindingResult.hasErrors()) {
            model.addAttribute("club",club);
            return "clubs-edit";
        }
        clubService.updateClub(club);
        return "redirect:/clubs";
    }
    @GetMapping("clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") Long clubId,Model model){
        UserEntity user = new UserEntity();
        ClubDTO clubDTO = clubService.findClubById(clubId);
        String username = SecurityUtil.getSesionUser();
        if(username!=null){
            user = userService.findByUsername(username);
            model.addAttribute("user",user);
        }
        model.addAttribute("user",user);
        model.addAttribute("club",clubDTO);
        return "clubs-detail";
    }

    @GetMapping("clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId")Long clubId){
        clubService.deleteClub(clubId);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query")String query, Model model){
        List<ClubDTO> clubs = clubService.searchClubs(query);
        model.addAttribute("clubs",clubs);
        return "clubs-list";
    }
}