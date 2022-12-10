package br.edu.iftm.bridge.integration;

import br.edu.iftm.bridge.dto.WorkspaceDTO;

import java.util.List;

public interface BridgeIntegration {
    public List<WorkspaceDTO> findWorkspaceById();
}
