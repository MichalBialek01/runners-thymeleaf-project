package pl.bialek.runnersthymeleafproject.service;

import pl.bialek.runnersthymeleafproject.DTO.RegistrationDTO;
import pl.bialek.runnersthymeleafproject.entity.UserEntity;

public interface UserService {
    void saveUser(RegistrationDTO registrationDTO);

    UserEntity findUserByEmail(String userEmail);

    UserEntity findByUsername(String username);
}
