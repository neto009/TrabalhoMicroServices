package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.dto.UserForm;
import br.edu.iftm.workspace.entity.User;
import br.edu.iftm.workspace.exception.NotFoundException;
import br.edu.iftm.workspace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById (String id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User no Exist!"));
    }

    public User update (String id, String name) {
        User currentUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User no Exist!"));
        currentUser.setName(name);
        return userRepository.save(currentUser);
    }

    public User save (UserForm userForm) {
        User user = new User(userForm.getEmail(), userForm.getName(), userForm.getAddress());
        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
