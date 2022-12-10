package br.edu.iftm.bridge.service;

import br.edu.iftm.bridge.dto.WorkspaceDTO;

import java.util.List;

public interface BridgeService {

    public List<WorkspaceDTO> findWorkspaceById();
}
