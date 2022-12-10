package br.edu.iftm.bridge.controller;

import br.edu.iftm.bridge.dto.WorkspaceDTO;

import java.util.List;

public interface BridgeController {
    public List<WorkspaceDTO> findWorkspaceById();
}
