package br.edu.iftm.bridge.integration.impl;

import br.edu.iftm.bridge.dto.WorkspaceDTO;
import br.edu.iftm.bridge.integration.BridgeIntegration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BridgeIntegrationImpl implements BridgeIntegration {

    private RestTemplate restTemplate;

    private String url;

    public BridgeIntegrationImpl(final @Value("${workspace.url.path}") String url, final RestTemplate restTemplate){
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public List<WorkspaceDTO> findWorkspaceById() {
        return List.of(restTemplate.getForObject(url, WorkspaceDTO[].class));
    }

}
