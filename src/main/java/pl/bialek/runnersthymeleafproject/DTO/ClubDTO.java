package pl.bialek.runnersthymeleafproject.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDTO {
    private long id;
    @NotEmpty(message = "Club title should not be empty")
    private String title;
    @NotEmpty(message = "Photo link should not be empty")
    private String photoURL;
    @NotEmpty(message = "Club description should not be empty")
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;
    private List<EventDTO> events;

    public void updateClub(ClubDTO club) {
    }
}
