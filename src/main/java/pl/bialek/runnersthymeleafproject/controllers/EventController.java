package pl.bialek.runnersthymeleafproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bialek.runnersthymeleafproject.DTO.EventDTO;
import pl.bialek.runnersthymeleafproject.entity.Event;
import pl.bialek.runnersthymeleafproject.entity.UserEntity;
import pl.bialek.runnersthymeleafproject.security.SecurityUtil;
import pl.bialek.runnersthymeleafproject.service.EventService;
import pl.bialek.runnersthymeleafproject.service.UserService;

import java.util.List;

@Controller
public class EventController {
    private final EventService eventService;
    private final UserService userService;

    public EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("/events")
    public String eventList(Model model) {
        UserEntity user = new UserEntity();
        List<EventDTO> events = eventService.findAllEvents();
        String username = SecurityUtil.getSesionUser();
        if (username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user",user);
        }
        model.addAttribute("user",user);
        model.addAttribute("events", events);
        return "events-list";
    }


    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") Long clubID,
                                  Model model) {
        Event event = new Event();
        model.addAttribute("clubID", clubID);
        model.addAttribute("event", event);
        return "events-create";
    }

    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId,
                              @ModelAttribute("event") EventDTO eventDTO,
                              Model model,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("event", eventDTO);
            return "clubs-create";
        }

        eventService.createEvent(clubId, eventDTO);
        return "redirect:/clubs/" + clubId;
    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") Long eventId, Model model) {
        UserEntity user = new UserEntity();
        EventDTO event = eventService.findByEventId(eventId);
        String username = SecurityUtil.getSesionUser();
        if (username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user",user);
        }
        model.addAttribute("club",event);
        model.addAttribute("user",user);
        model.addAttribute("event", event);
        return "events-detail";
    }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") Long eventId, Model model) {
        EventDTO event = eventService.findByEventId(eventId);
        model.addAttribute("event", event);
        return "events-edit";
    }

    @PostMapping("/events/{eventId}/edit")
    public String editEvent(@PathVariable("eventId") Long eventId,
                            @ModelAttribute EventDTO event,
                            Model model,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("event", event);
            return "events-edit";
        }
        //Lazy loading - do wydarzenia przypisujemy id, oraz
        EventDTO eventDTO = eventService.findByEventId(eventId);
        event.setId(eventId);
        event.setClub(eventDTO.getClub());
        eventService.updateEvent(event);
        return "redirect:/events" + eventId;
    }

    //    hard delete
    @GetMapping("/events/{eventId}/delete")

    public String deleteEvent(@PathVariable("eventId") Long eventId) {
        eventService.delteteEvent(eventId);
        return "redirect:/events";
    }


}
