package gr.aueb.cf.schoolapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherReadOnlyDTO {
    private Long id;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
    private Instant createdAt;
    private Instant updatedAt;
    private String uuid;
    private String firstname;
    private String lastname;
    private String vat;
    private String region;
}
