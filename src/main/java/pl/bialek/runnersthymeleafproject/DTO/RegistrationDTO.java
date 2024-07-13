package pl.bialek.runnersthymeleafproject.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegistrationDTO {
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
