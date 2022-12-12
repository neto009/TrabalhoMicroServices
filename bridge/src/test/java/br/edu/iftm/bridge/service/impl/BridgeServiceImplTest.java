package br.edu.iftm.bridge.service.impl;

import br.edu.iftm.bridge.dto.WorkspaceDTO;
import br.edu.iftm.bridge.integration.BridgeIntegration;
import br.edu.iftm.bridge.service.BridgeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BridgeServiceImplTest {


    private BridgeService bridgeService;

    private BridgeIntegration bridgeIntegration;

    @BeforeEach
    void settings() {
        bridgeService = mock(BridgeServiceImpl.class);
        bridgeIntegration = mock(BridgeIntegration.class);
    }


    @Test
    public void findAllWorkspace() {
        List<WorkspaceDTO> workspaceDTOS = new ArrayList<>();
        WorkspaceDTO workspaceDTO = new WorkspaceDTO();
        workspaceDTOS.add(workspaceDTO);
        workspaceDTOS.add(workspaceDTO);

        when(bridgeIntegration.findWorkspaceById()).thenReturn(workspaceDTOS);
        when(bridgeService.findWorkspaceById()).thenReturn(workspaceDTOS);
        List<WorkspaceDTO> find = bridgeService.findWorkspaceById();

        Assertions.assertNotNull(find);
    }
}