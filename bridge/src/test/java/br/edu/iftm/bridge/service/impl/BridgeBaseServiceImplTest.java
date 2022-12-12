package br.edu.iftm.bridge.service.impl;

import br.edu.iftm.bridge.dto.Base;
import br.edu.iftm.bridge.integration.BridgeBaseIntegration;
import br.edu.iftm.bridge.integration.BridgeIntegration;
import br.edu.iftm.bridge.service.BridgeBaseService;
import br.edu.iftm.bridge.service.BridgeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BridgeBaseServiceImplTest {

    private BridgeBaseService bridgeBaseService;

    private BridgeBaseIntegration bridgeBaseIntegration;

    @BeforeEach
    void settings() {
        bridgeBaseService = mock(BridgeBaseServiceImpl.class);
        bridgeBaseIntegration = mock(BridgeBaseIntegration.class);
    }

    @Test
    void findBaseById() {
        when(bridgeBaseIntegration.findBaseId(Mockito.anyString())).thenReturn(new Base());
        when(bridgeBaseService.findBaseId(Mockito.anyString())).thenReturn(new Base());

        Base base = bridgeBaseService.findBaseId("1");

        Assertions.assertNotNull(base);
    }

}