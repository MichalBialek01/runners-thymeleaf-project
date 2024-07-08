package pl.bialek.runnersthymeleafproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bialek.runnersthymeleafproject.models.Event;
@Repository
public interface EventRepository extends JpaRepository <Event,Long> {
}
