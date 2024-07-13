package pl.bialek.runnersthymeleafproject.service;

import pl.bialek.runnersthymeleafproject.DTO.EventDTO;

import java.util.List;

public interface EventService {
    void createEvent(Long clubId, EventDTO eventDTO);

    List<EventDTO> findAllEvents();

    EventDTO findByEventId(Long eventId);

    void updateEvent(EventDTO eventDTO);

    void delteteEvent(Long eventId);
}
