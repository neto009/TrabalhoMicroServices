package br.edu.iftm.bridge.controller.impl;

import br.edu.iftm.bridge.controller.BridgeController;
import br.edu.iftm.bridge.dto.WorkspaceDTO;
import br.edu.iftm.bridge.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bridge")
public class BridgeControllerImpl implements BridgeController {

    @Autowired
    private BridgeService bridgeService;

    @GetMapping
    @Override
    public List<WorkspaceDTO> findWorkspaceById() {
        List<WorkspaceDTO> retorno = bridgeService.findWorkspaceById();
        return retorno;
    }
}
