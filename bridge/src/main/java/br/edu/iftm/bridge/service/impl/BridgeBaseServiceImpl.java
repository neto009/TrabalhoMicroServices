package br.edu.iftm.bridge.service.impl;

import br.edu.iftm.bridge.dto.Base;
import br.edu.iftm.bridge.integration.BridgeBaseIntegration;
import br.edu.iftm.bridge.service.BridgeBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BridgeBaseServiceImpl implements BridgeBaseService {

    @Autowired
    private BridgeBaseIntegration bridgeBaseIntegration;

    @Override
    public Base findBaseId(String id) {
        return bridgeBaseIntegration.findBaseId(id);
    }
}
