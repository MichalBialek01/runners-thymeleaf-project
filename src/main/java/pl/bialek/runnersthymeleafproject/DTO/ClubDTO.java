package pl.bialek.runnersthymeleafproject.DTO;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class ClubDTO {
    private long id;
    private String title;
    private String photoURL;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;

    public void updateClub(ClubDTO club) {
    }
}
