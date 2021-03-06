package academycisco.demo.dto;

import academycisco.demo.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String surname;
    private String email;
    private String birthdate;
    private List<Role> roles;


}
