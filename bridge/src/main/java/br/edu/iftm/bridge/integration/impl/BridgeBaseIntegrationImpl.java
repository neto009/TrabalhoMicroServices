package br.edu.iftm.bridge.integration.impl;

import br.edu.iftm.bridge.dto.Base;
import br.edu.iftm.bridge.integration.BridgeBaseIntegration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BridgeBaseIntegrationImpl implements BridgeBaseIntegration {

    private RestTemplate restTemplate;

    private String url;

    public BridgeBaseIntegrationImpl(final @Value("${base.url.path}") String url, final RestTemplate restTemplate){
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public Base findBaseId(String id) {
        return restTemplate.getForObject(url, Base.class, id);
    }
}
