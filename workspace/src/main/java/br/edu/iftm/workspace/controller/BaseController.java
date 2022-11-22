package br.edu.iftm.workspace.controller;

import br.edu.iftm.workspace.dto.BaseForm;
import br.edu.iftm.workspace.entity.Base;
import br.edu.iftm.workspace.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @GetMapping("/{id}")
    public ResponseEntity<Base> findById(@PathVariable String id) {
        return new ResponseEntity<>(baseService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Base> save(@Valid @RequestBody BaseForm baseForm) {
        return new ResponseEntity<>(baseService.save(baseForm), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        baseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
