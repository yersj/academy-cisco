package academycisco.demo.controllers;

import academycisco.demo.dto.LoginRequestDto;
import academycisco.demo.dto.ProfileDto;
import academycisco.demo.dto.RegisterDto;
import academycisco.demo.dto.UserDto;
import academycisco.demo.entities.Role;
import academycisco.demo.entities.User;
import academycisco.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ProfileController {

    @Autowired
    private UserService userService;
    @GetMapping(value = "/profile/{id}")
    public  ResponseEntity<UserDto> profile(@PathVariable("id") Long id) {
        UserDto userDto=new UserDto();
        User user=(User) userService.getUser(id);
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());
        userDto.setBirthdate(user.getBirthdate());
        userDto.setRoles(user.getRoles());

        return ResponseEntity.ok(userDto);
    }

}
