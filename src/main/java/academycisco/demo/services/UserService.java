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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

    public Long login(LoginRequestDto dto){
        User user=(User) userRepository.findByEmail(dto.getEmail());
        if(user!=null){

            if(passwordEncoder.matches(dto.getPassword(), user.getPassword())){
                return user.getId();
            }
        }
            return 777L;



    }



    public String register(RegisterDto dto){
        User user=userRepository.findByEmail(dto.getEmail());

        if(user==null){
            user=new User();
            user.setName(dto.getName());
            user.setSurname(dto.getSurname());
            user.setEmail(dto.getEmail());
            user.setPassword( passwordEncoder.encode(dto.getPassword()));
            user.setBirthdate(dto.getBirthdate());


            Role role=roleRepository.findById(1L).get();
            user.setRoles(Arrays.asList(role));
            userRepository.save(user);
            return "success";
        }else{
            return "error";
        }
    }
    
    public List<User> getAllStudents(){
        return  userRepository.findAllByRolesId(1L);
    }








    public User getUser(Long id){
             return  userRepository.findById(id).orElse(null);
    }
}

//RegisterController
//RegisterDto -> fullname email password student
//UserService register method
//user set , save,
//
