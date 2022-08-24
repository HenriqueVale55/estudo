package br.com.estudo.estudo.controller;

import br.com.estudo.estudo.model.User;
import br.com.estudo.estudo.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers(){
       return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<User>> getUser(@PathVariable String nome){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(nome));
    }

    @PostMapping()
    public ResponseEntity<User> postUser(@RequestBody User user){
        userService.postUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping()
    public ResponseEntity<User> putUser (@RequestBody User user){
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{nome}")
    public ResponseEntity<User> putUser (@PathVariable String nome){
        userService.deleteUser(nome);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
