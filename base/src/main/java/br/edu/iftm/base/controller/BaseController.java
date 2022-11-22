package br.edu.iftm.base.controller;

import br.edu.iftm.base.dto.BaseDTO;
import br.edu.iftm.base.dto.CreateTableForm;
import br.edu.iftm.base.dto.TableDTO;
import br.edu.iftm.base.entity.Base;
import br.edu.iftm.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseDTO> findById(@PathVariable String id) {
        return new ResponseEntity<>(baseService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Base> update (@RequestBody Base base) {
        return new ResponseEntity<>(baseService.update(base), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TableDTO> createTable (@RequestBody CreateTableForm createTableForm) {
        return new ResponseEntity<>(baseService.createTable(createTableForm.getBaseId()), HttpStatus.OK);
    }
}
