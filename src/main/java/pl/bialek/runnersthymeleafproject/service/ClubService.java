package pl.bialek.runnersthymeleafproject.service;

import pl.bialek.runnersthymeleafproject.DTO.ClubDTO;
import pl.bialek.runnersthymeleafproject.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAll();
    Club saveClub(Club club);

}
