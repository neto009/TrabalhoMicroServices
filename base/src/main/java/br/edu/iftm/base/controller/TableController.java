package br.edu.iftm.base.controller;

import br.edu.iftm.base.dto.LinesForm;
import br.edu.iftm.base.entity.ReferenceAttributes;
import br.edu.iftm.base.entity.Table;
import br.edu.iftm.base.entity.attributes.DateDocument;
import br.edu.iftm.base.entity.attributes.NumberDocument;
import br.edu.iftm.base.entity.attributes.StringDocument;
import br.edu.iftm.base.service.ReferenceAttributesService;
import br.edu.iftm.base.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("table")
public class TableController {

    @Autowired
    private TableService tableService;

    @Autowired
    private ReferenceAttributesService referenceAttributesService;

    @GetMapping("/{id}")
    public ResponseEntity<Table> findById(@PathVariable String id) {
        return new ResponseEntity<>(tableService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save () {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/numberColumn")
    public ResponseEntity<NumberDocument> updateNumberLine(@RequestBody LinesForm linesForm) {
        return new ResponseEntity<>(referenceAttributesService.insertNumberValue(linesForm.getId(),
                linesForm.getLongValue()), HttpStatus.OK);
    }

    @PutMapping("/stringColumn")
    public ResponseEntity<StringDocument> updateStringLine(@RequestBody LinesForm linesForm) {
        return new ResponseEntity<>(referenceAttributesService.insertStringValue(linesForm.getId(),
                linesForm.getStringValue()), HttpStatus.OK);
    }

    @PutMapping("/dateColumn")
    public ResponseEntity<DateDocument> updateDateLine(@RequestBody LinesForm linesForm) {
        return new ResponseEntity<>(referenceAttributesService.insertDateValue(linesForm.getId(),
                LocalDate.now().toString()), HttpStatus.OK);
    }

    @PutMapping("/insertLine/{attributeId}")
    public ResponseEntity<ReferenceAttributes> insertLine(@PathVariable String attributeId) {
        return new ResponseEntity<>(referenceAttributesService.insertLine(attributeId), HttpStatus.OK);
    }
}
