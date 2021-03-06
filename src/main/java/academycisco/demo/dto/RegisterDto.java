package academycisco.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegisterDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String birthdate;

}
