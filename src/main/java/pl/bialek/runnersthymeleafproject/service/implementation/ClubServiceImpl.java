package pl.bialek.runnersthymeleafproject.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bialek.runnersthymeleafproject.DTO.ClubDTO;
import pl.bialek.runnersthymeleafproject.mapper.ClubMapper;
import pl.bialek.runnersthymeleafproject.entity.Club;
import pl.bialek.runnersthymeleafproject.repository.ClubRepository;
import pl.bialek.runnersthymeleafproject.service.ClubService;

import java.util.List;
import java.util.stream.Collectors;

import static pl.bialek.runnersthymeleafproject.mapper.ClubMapper.mapToClubDTO;
import static pl.bialek.runnersthymeleafproject.mapper.ClubMapper.maptoClub;

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
        return clubs.stream().map(ClubMapper::mapToClubDTO).collect(Collectors.toList()); // Mapping to DTO for future to provide   convince
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
        return clubs.stream().map(ClubMapper::mapToClubDTO).collect(Collectors.toList());
    }
}
