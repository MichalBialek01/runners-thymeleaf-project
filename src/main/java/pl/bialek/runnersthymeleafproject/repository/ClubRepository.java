package pl.bialek.runnersthymeleafproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bialek.runnersthymeleafproject.models.Club;

import javax.swing.text.html.Option;
import java.util.Optional;
@Repository
public interface ClubRepository extends JpaRepository<Club,Long> {
    Optional<Club> findByTitle(String url);
}
