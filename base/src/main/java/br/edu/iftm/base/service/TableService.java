package br.edu.iftm.base.service;

import br.edu.iftm.base.entity.Table;
import br.edu.iftm.base.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public Table findById(String id) {
        return tableRepository.findById(id).orElseThrow(()-> new RuntimeException("No Exist"));
    }

    public Table save(Table table) {
        return tableRepository.save(table);
    }

}
