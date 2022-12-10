package br.edu.iftm.bridge.service.impl;

import br.edu.iftm.bridge.dto.WorkspaceDTO;
import br.edu.iftm.bridge.integration.BridgeIntegration;
import br.edu.iftm.bridge.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BridgeServiceImpl implements BridgeService {

    @Autowired
    private BridgeIntegration bridgeIntegration;

    @Override
    public List<WorkspaceDTO> findWorkspaceById() {
        return bridgeIntegration.findWorkspaceById();
    }
}
