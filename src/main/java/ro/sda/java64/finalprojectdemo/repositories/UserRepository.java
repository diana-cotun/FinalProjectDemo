package ro.sda.java64.finalprojectdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.java64.finalprojectdemo.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

}
