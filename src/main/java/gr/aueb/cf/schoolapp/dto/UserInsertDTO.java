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
public class UserInsertDTO {

    @NotNull(message = "Το username δεν μπορεί να είναι κενό.")
    @Size(min = 2, max = 20, message = "Το username πρέπει να είναι μεταξύ 2 - 20 χαρακτήρες.")
    private String username;

    @NotNull(message = "Το password δεν μπορεί να είναι null.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])^.{8,}$",
            message = "Το password πρέπει να περιέχει τουλάχιστον 1 πεζό, 1 κεφαλαίο, 1 ψηφίο και 1 ειδικό χαρακτήρα χωρίς κενά.")
    private String password;

//    @NotNull(message = "Ο ρόλος δεν μπορεί να είναι κενός")
//    private String role;

    @NotNull(message = "Ο ρόλος δεν μπορεί να είναι κενός")
    private Long roleId;
}
