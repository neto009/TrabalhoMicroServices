package br.edu.iftm.workspace.controller;

import br.edu.iftm.workspace.dto.UserForm;
import br.edu.iftm.workspace.dto.UserUpdateForm;
import br.edu.iftm.workspace.entity.User;
import br.edu.iftm.workspace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserForm userForm) {
        return new ResponseEntity<>(userService.save(userForm), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> update (@RequestBody UserUpdateForm userUpdateForm) {
        return new ResponseEntity<>(userService.update(userUpdateForm.getId(), userUpdateForm.getName()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable String id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
