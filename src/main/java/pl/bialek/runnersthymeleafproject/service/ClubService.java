package pl.bialek.runnersthymeleafproject.service;

import pl.bialek.runnersthymeleafproject.DTO.ClubDTO;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();
}
