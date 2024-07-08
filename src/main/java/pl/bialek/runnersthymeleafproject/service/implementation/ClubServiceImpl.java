package pl.bialek.runnersthymeleafproject.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bialek.runnersthymeleafproject.DTO.ClubDTO;
import pl.bialek.runnersthymeleafproject.models.Club;
import pl.bialek.runnersthymeleafproject.repository.ClubRepository;
import pl.bialek.runnersthymeleafproject.service.ClubService;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;
    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDTO> findAll() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(this::mapToClubDTO).collect(Collectors.toList()); // Mapping to DTO for future to provide   convince
    }

    @Override
    public Club saveClub(ClubDTO clubDto) {
        Club club = maptoClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDTO findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDTO(club);
    }

    @Override
    public void updateClub(ClubDTO clubDTO) {
        Club club = maptoClub(clubDTO);
        clubRepository.save(club);
    }

    @Override
    public void deleteClub(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDTO> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(this::mapToClubDTO).collect(Collectors.toList());
    }

    private Club maptoClub(ClubDTO clubDTO) {
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


    ClubDTO mapToClubDTO(Club club){
        return ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoURL(club.getPhotoURL())
                .content(club.getContent())
                .createdTime(club.getCreatedTime())
                .updateTime(club.getUpdateTime())
                .build();
    }
}
