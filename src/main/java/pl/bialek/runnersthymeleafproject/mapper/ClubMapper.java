package pl.bialek.runnersthymeleafproject.mapper;

import pl.bialek.runnersthymeleafproject.DTO.ClubDTO;
import pl.bialek.runnersthymeleafproject.entity.Club;

import java.util.stream.Collectors;

public class ClubMapper {
    public static Club maptoClub(ClubDTO clubDTO) {
        Club club = Club.builder()
                .id(clubDTO.getId())
                .title(clubDTO.getTitle())
                .photoURL(clubDTO.getPhotoURL())
                .content(clubDTO.getContent())
                .createdTime(clubDTO.getCreatedTime())
                .updateTime(clubDTO.getUpdateTime())
                .build();

        return club;
    }


    public static ClubDTO mapToClubDTO(Club club){
        return ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoURL(club.getPhotoURL())
                .content(club.getContent())
                .createdTime(club.getCreatedTime())
                .updateTime(club.getUpdateTime())
                .events(club.getEvents().stream().map(EventMapper::mapToEventDTO).collect(Collectors.toList()))
                .build();
    }
}
