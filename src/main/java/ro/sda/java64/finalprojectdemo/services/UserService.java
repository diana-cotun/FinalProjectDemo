package ro.sda.java64.finalprojectdemo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.sda.java64.finalprojectdemo.entities.User;
import ro.sda.java64.finalprojectdemo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User get(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    public User updateById(Long id, User user) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isEmpty()) {
            return null;
        }
        User updatedUser = foundUser.get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        return userRepository.save(updatedUser);
    }

    public User deleteById(Long id) {
        Optional<User> deletedUser = userRepository.findById(id);
        if (deletedUser.isEmpty()) {
            return null;
        }
        userRepository.delete(deletedUser.get());
        return deletedUser.get();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }


    public User findByEmail(String email) {
        Optional<User> foundUser = userRepository.findByEmail(email);
        if (foundUser.isEmpty()) {
            return null;
        }
        return foundUser.get();
    }
}
