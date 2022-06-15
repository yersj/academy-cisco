package academycisco.demo.controllers;

import academycisco.demo.dto.UserDto;
import academycisco.demo.entities.User;
import academycisco.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllStudentsController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/students")
    public List<User> AllStudents() {
        return userService.getAllStudents();
    }
}
