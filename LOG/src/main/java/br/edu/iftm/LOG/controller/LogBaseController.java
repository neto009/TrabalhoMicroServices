package br.edu.iftm.LOG.controller;

import br.edu.iftm.LOG.entity.LogBase;
import br.edu.iftm.LOG.service.LogBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("logBase")
public class LogBaseController {

    @Autowired
    private LogBaseService logBaseService;

    @GetMapping("/{id}")
    public Optional<LogBase> findById(@PathVariable String id) {
        return logBaseService.findById(id);
    }

    @GetMapping
    public List<LogBase> findAll() {
        return logBaseService.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<LogBase> findByUser(@PathVariable String userId) {
        return logBaseService.findByUser(userId);
    }

    @GetMapping("/space/{spaceId}")
    public List<LogBase> findBySpaceId(@PathVariable String spaceId) {
        return logBaseService.findBySpaceId(spaceId);
    }

    @GetMapping("/date/{date}")
    public List<LogBase> findByDate(@PathVariable String date) {
        return logBaseService.findByDate(date);
    }

    @GetMapping("/request/{date}")
    public List<LogBase> findByRequest(@PathVariable String requestType) {
        return logBaseService.findByRequest(requestType);
    }
}
