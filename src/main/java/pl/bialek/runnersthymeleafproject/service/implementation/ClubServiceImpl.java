package pl.bialek.runnersthymeleafproject.service.implementation;

import lombok.AllArgsConstructor;
import pl.bialek.runnersthymeleafproject.DTO.ClubDTO;
import pl.bialek.runnersthymeleafproject.models.Club;
import pl.bialek.runnersthymeleafproject.repository.ClubRepository;
import pl.bialek.runnersthymeleafproject.service.ClubService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;
    @Override
    public List<ClubDTO> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDTO(club)).collect(Collectors.toList()); // Mapping to DTO for future to provide   convince
    }

    //Metoda przyjmująca Club i zwracająca mapDTO
    ClubDTO mapToClubDTO(Club club){
        return ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoURL(club.getPhotoURL())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
    }

}
