package academycisco.demo.controllers;


import academycisco.demo.dto.LoginRequestDto;
import academycisco.demo.dto.RegisterDto;
import academycisco.demo.dto.UserDto;
import academycisco.demo.entities.User;
import academycisco.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class LoginController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Long login(@RequestBody LoginRequestDto loginRequestDto){
        return userService.login(loginRequestDto);
    }

}
