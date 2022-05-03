package academycisco.demo.services;

import academycisco.demo.dto.LoginRequestDto;
import academycisco.demo.dto.RegisterDto;
import academycisco.demo.dto.UserDto;
import academycisco.demo.entities.Role;
import academycisco.demo.entities.User;
import academycisco.demo.repositories.RoleRepository;
import academycisco.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email);
        if(user!=null){
            return user;
        }else{
            throw new UsernameNotFoundException("User not found");
        }

    }

    public UserDto login(LoginRequestDto dto){
        User user=(User) loadUserByUsername(dto.getEmailId());
        if(user!=null){

            if(passwordEncoder.matches(dto.getPassword(), user.getPassword())){
                return new UserDto(user.getEmail(),user.getRoles().stream().map(Role::getRole).collect(Collectors.toList()));
            }
        }
        return null;
    }

    public String register(RegisterDto dto){
        User user=userRepository.findByEmail(dto.getEmail());

        if(user==null){
            user=new User();
            user.setFullName(dto.getFullName());
            user.setEmail(dto.getEmail());
            user.setPassword( passwordEncoder.encode(dto.getPassword()));

            Role role=roleRepository.findById(1L).get();
            user.setRoles(Arrays.asList(role));
            userRepository.save(user);
            return "success";
        }else{
            return "error";
        }
    }
}

//RegisterController
//RegisterDto -> fullname email password student
//UserService register method
//user set , save,
//
