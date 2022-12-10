package br.edu.iftm.bridge.service.impl;

import br.edu.iftm.bridge.dto.WorkspaceDTO;
import br.edu.iftm.bridge.integration.BridgeIntegration;
import br.edu.iftm.bridge.service.BridgeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.when;

class BridgeServiceImplTest {

    private BridgeService bridgeService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private BridgeIntegration bridgeIntegration;

    @BeforeEach
    void settings() {
        restTemplate = new RestTemplate();
        MockitoAnnotations.initMocks(BridgeServiceImpl.class);
    }


    @Test
    public void findAllWorkspace() {
        when(bridgeService.findWorkspaceById()).thenReturn((List<WorkspaceDTO>) Mockito.any(WorkspaceDTO.class));
        List<WorkspaceDTO> find = bridgeService.findWorkspaceById();

        Assertions.assertNotNull(find);
    }
}