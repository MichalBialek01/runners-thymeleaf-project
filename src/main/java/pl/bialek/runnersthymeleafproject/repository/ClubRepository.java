package pl.bialek.runnersthymeleafproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bialek.runnersthymeleafproject.models.Club;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club,Long> {
    Optional<Club> findByTitle(String url);
}
