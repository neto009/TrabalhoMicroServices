package br.edu.iftm.LOG.controller;

import br.edu.iftm.LOG.entity.Log;
import br.edu.iftm.LOG.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/{id}")
    public Optional<Log> findById(@PathVariable String id) {
        return logService.findById(id);
    }

    @GetMapping
    public List<Log> findAll() {
        return logService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<Log> findByUser(@PathVariable String userId) {
        return logService.findByUser(userId);
    }
}