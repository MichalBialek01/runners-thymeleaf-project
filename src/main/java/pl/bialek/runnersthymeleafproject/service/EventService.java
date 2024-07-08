package pl.bialek.runnersthymeleafproject.service;

import pl.bialek.runnersthymeleafproject.DTO.EventDTO;

public interface EventService {
    void createEvent(Long clubId, EventDTO eventDTO);
}
