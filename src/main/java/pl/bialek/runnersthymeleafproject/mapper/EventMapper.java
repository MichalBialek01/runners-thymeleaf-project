package pl.bialek.runnersthymeleafproject.mapper;

import pl.bialek.runnersthymeleafproject.DTO.EventDTO;
import pl.bialek.runnersthymeleafproject.entity.Event;

public class EventMapper {
    public static Event mapToEvent(EventDTO eventDTO) {
        return Event.builder()
                .id(eventDTO.getId())
                .name(eventDTO.getName())
                .startTime(eventDTO.getStartTime())
                .endTime(eventDTO.getEndTime())
                .type(eventDTO.getType())
                .photoURL(eventDTO.getPhotoURL())
                .createdOn(eventDTO.getCreatedOn())
                .updateOn(eventDTO.getUpdateOn())
                .club(eventDTO.getClub())
                .build();
    }
    public static EventDTO mapToEventDTO(Event event){
        return EventDTO.builder()
                .id(event.getId())
                .name(event.getName())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .photoURL(event.getPhotoURL())
                .createdOn(event.getCreatedOn())
                .updateOn(event.getUpdateOn())
                .club(event.getClub())
                .build();
    }
}
