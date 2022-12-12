package br.edu.iftm.bridge.controller.impl;

import br.edu.iftm.bridge.controller.BridgeBaseController;
import br.edu.iftm.bridge.dto.Base;
import br.edu.iftm.bridge.service.BridgeBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bridge/base")
public class BridgeBaseControllerImpl implements BridgeBaseController {

    @Autowired
    private BridgeBaseService bridgeBaseService;

    @GetMapping("/{id}")
    @Override
    public Base findBaseId(@PathVariable String id) {
        return bridgeBaseService.findBaseId(id);
    }
}
