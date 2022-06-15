package academycisco.demo.repositories;

import academycisco.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    @Query(value = "Select * from users join users_roles on id=user_id where roles_id=:id",nativeQuery = true)
    List<User> findAllByRolesId(Long id);

}
