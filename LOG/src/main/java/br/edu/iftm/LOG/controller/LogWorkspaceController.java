package br.edu.iftm.LOG.controller;

import br.edu.iftm.LOG.entity.LogWorkspace;
import br.edu.iftm.LOG.service.LogWorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("logWorkspace")
public class LogWorkspaceController {

    @Autowired
    private LogWorkspaceService logWorkspaceService;

    @GetMapping("/{id}")
    public Optional<LogWorkspace> findById(@PathVariable String id) {
        return logWorkspaceService.findById(id);
    }

    @GetMapping
    public List<LogWorkspace> findAll() {
        return logWorkspaceService.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<LogWorkspace> findByUser(@PathVariable String userId) {
        return logWorkspaceService.findByUser(userId);
    }

    @GetMapping("/space/{spaceId}")
    public List<LogWorkspace> findBySpaceId(@PathVariable String spaceId) {
        return logWorkspaceService.findBySpaceId(spaceId);
    }

    @GetMapping("/date/{date}")
    public List<LogWorkspace> findByDate(@PathVariable String date) {
        return logWorkspaceService.findByDate(date);
    }
}