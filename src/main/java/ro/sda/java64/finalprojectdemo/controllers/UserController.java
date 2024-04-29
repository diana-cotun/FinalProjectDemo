package ro.sda.java64.finalprojectdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.java64.finalprojectdemo.dto.LoginRequest;
import ro.sda.java64.finalprojectdemo.entities.Item;
import ro.sda.java64.finalprojectdemo.entities.User;
import ro.sda.java64.finalprojectdemo.repositories.ItemRepository;
import ro.sda.java64.finalprojectdemo.repositories.UserRepository;
import ro.sda.java64.finalprojectdemo.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User foundUser = userService.get(id);
        if (foundUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateById(id, user);
        if (updatedUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        User deletedUser = userService.deleteById(id);
        if (deletedUser == null) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
//            "User with id " + id + " not found",
        }
        return new ResponseEntity<>(HttpStatus.OK);
//        "User with id " + id + " was deleted"
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
}
