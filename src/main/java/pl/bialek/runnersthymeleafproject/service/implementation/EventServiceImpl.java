package pl.bialek.runnersthymeleafproject.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bialek.runnersthymeleafproject.DTO.EventDTO;
import pl.bialek.runnersthymeleafproject.models.Club;
import pl.bialek.runnersthymeleafproject.models.Event;
import pl.bialek.runnersthymeleafproject.repository.ClubRepository;
import pl.bialek.runnersthymeleafproject.repository.EventRepository;
import pl.bialek.runnersthymeleafproject.service.EventService;
@Service
public class EventServiceImpl implements EventService {
    private  ClubRepository clubRepository;
    private  EventRepository eventRepository;
@Autowired
    public EventServiceImpl(ClubRepository clubRepository, EventRepository eventRepository) {
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDTO eventDTO) {
    Club club = clubRepository.findById(clubId).get();
    Event event= mapToEvent(eventDTO);
    event.setClub(club);
    }

    private Event mapToEvent(EventDTO eventDTO) {
        return Event.builder()
                .id(eventDTO.getId())
                .name(eventDTO.getName())
                .startTime(eventDTO.getStartTime())
                .endTime(eventDTO.getEndTime())
                .type(eventDTO.getType())
                .photoURL(eventDTO.getPhotoURL())
                .createdOn(eventDTO.getCreatedOn())
                .updateOn(eventDTO.getUpdateOn())
                .build();
    }
}
