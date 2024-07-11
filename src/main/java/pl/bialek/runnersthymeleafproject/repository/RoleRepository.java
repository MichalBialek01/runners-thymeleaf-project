package pl.bialek.runnersthymeleafproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bialek.runnersthymeleafproject.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
