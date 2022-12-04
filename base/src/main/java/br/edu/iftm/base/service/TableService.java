package br.edu.iftm.base.service;

import br.edu.iftm.base.entity.Table;
import br.edu.iftm.base.message.Message;
import br.edu.iftm.base.message.dto.MessageDTO;
import br.edu.iftm.base.message.dto.ResquestType;
import br.edu.iftm.base.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private Message message;

    public Table findById(String id) {
        return tableRepository.findById(id).orElseThrow(()-> new RuntimeException("No Exist"));
    }

    public Table save(Table table) {
        Table currentTable = tableRepository.save(table);
        //A IDEIA SERIA PEGAR OS DADOS DA SESSÃO DO USUARIO LOGADO (ID E ACESSO)
        message.sendMessage(new MessageDTO(currentTable.getId(), ResquestType.SAVE, "user", "OWNER"));
        return currentTable;
    }

}
