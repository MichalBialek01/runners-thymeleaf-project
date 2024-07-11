package pl.bialek.runnersthymeleafproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bialek.runnersthymeleafproject.entity.Club;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClubRepository extends JpaRepository<Club,Long> {
    Optional<Club> findByTitle(String url);
    @Query("SELECT club from Club club WHERE club.title LIKE CONCAT('%',:query,'%')")
    List<Club> searchClubs(String query);
}
