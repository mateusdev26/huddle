package br.com.huddle.controller;

import br.com.huddle.domain.User;
import br.com.huddle.request.UserPostRequestBody;
import br.com.huddle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("huddle/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService ;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping(path = "/find")
    public ResponseEntity<User> findByName(@PathVariable String name){
        return ResponseEntity.ok(userService.findByName(name));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable long id){
        return ResponseEntity.ok(userService.findByIdOrThrowBadRequestException(id));
    }
    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserPostRequestBody userPostRequestBody){
        return new ResponseEntity<>(userService.save(userPostRequestBody),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
