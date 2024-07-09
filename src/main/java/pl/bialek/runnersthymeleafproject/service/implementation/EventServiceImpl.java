package pl.bialek.runnersthymeleafproject.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bialek.runnersthymeleafproject.DTO.EventDTO;
import pl.bialek.runnersthymeleafproject.mapper.EventMapper;
import pl.bialek.runnersthymeleafproject.models.Club;
import pl.bialek.runnersthymeleafproject.models.Event;
import pl.bialek.runnersthymeleafproject.repository.ClubRepository;
import pl.bialek.runnersthymeleafproject.repository.EventRepository;
import pl.bialek.runnersthymeleafproject.service.EventService;

import java.util.List;
import java.util.stream.Collectors;

import static pl.bialek.runnersthymeleafproject.mapper.EventMapper.mapToEvent;
import static pl.bialek.runnersthymeleafproject.mapper.EventMapper.mapToEventDTO;

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
    eventRepository.save(event);
    }

    @Override
    public List<EventDTO> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(EventMapper::mapToEventDTO).collect(Collectors.toList());
    }

    @Override
    public EventDTO findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDTO(event);
    }

    @Override
    public void updateEvent(EventDTO eventDTO) {
        Event event = mapToEvent(eventDTO);
        eventRepository.save(event);
    }
}
