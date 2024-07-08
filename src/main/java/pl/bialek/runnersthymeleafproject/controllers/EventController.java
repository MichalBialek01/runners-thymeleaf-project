package pl.bialek.runnersthymeleafproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bialek.runnersthymeleafproject.DTO.EventDTO;
import pl.bialek.runnersthymeleafproject.models.Club;
import pl.bialek.runnersthymeleafproject.models.Event;
import pl.bialek.runnersthymeleafproject.service.ClubService;
import pl.bialek.runnersthymeleafproject.service.EventService;
import pl.bialek.runnersthymeleafproject.service.implementation.EventServiceImpl;

@Controller
public class EventController {
    private final EventService eventService;
@Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") Long clubID,
                                  Model model) {
        Event event = new Event();
        model.addAttribute("clubID",clubID);
        model.addAttribute("event",event);
        return "events-create";
    }
    @PostMapping("/events/{clubId}/new")
    public String createEvent(@PathVariable("clubId") Long clubId,
                              @ModelAttribute("event") EventDTO eventDTO,
                              Model model){
        eventService.createEvent(clubId,eventDTO);
        return "redirect:/clubs/"+clubId;
    }


}
