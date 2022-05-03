package academycisco.demo.controllers;

import academycisco.demo.dto.RegisterDto;
import academycisco.demo.dto.UserDto;
import academycisco.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        return ResponseEntity.ok(userService.register(registerDto));
    }
}
