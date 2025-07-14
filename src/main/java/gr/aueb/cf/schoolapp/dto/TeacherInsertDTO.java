package gr.aueb.cf.schoolapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherInsertDTO {

    @NotNull(message = "Το όνομα δεν μπορεί να είναι null.")
    @Size(min = 2, message = "Το όνομα πρέπει να περιέχει τουλάχιστον δύο χαρακτήρες.")
    private String firstname;

    @NotNull(message = "Το επώνυμο δεν μπορεί να είναι null.")
    @Size(min = 2, message = "Το επώνυμο πρέπει να περιέχει τουλάχιστον δύο χαρακτήρες.")
    private String lastname;

    @Pattern(regexp = "\\d{9,}", message = "Το ΑΦΜ δεν μπορεί να είναι μικρότερο από εννιά ψηφία.")
    private String vat;

    @NotNull(message = "Η περιοχή δεν μπορεί να είναι null.")
    private Long regionId;
}
