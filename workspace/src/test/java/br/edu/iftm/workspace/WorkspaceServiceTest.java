package br.edu.iftm.workspace;

import br.edu.iftm.workspace.dto.WorkspaceForm;
import br.edu.iftm.workspace.entity.Base;
import br.edu.iftm.workspace.entity.Collaborator;
import br.edu.iftm.workspace.entity.User;
import br.edu.iftm.workspace.entity.Workspace;
import br.edu.iftm.workspace.enums.Access;
import br.edu.iftm.workspace.exception.NotFoundException;
import br.edu.iftm.workspace.message.Message;
import br.edu.iftm.workspace.repository.BaseRepository;
import br.edu.iftm.workspace.repository.WorkspaceRepository;
import br.edu.iftm.workspace.service.UserService;
import br.edu.iftm.workspace.service.WorkspaceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.Optional;

public class WorkspaceServiceTest {

    private static final String ID = "1L";
    private static final String EMAIL = "teste@gmail.com";
    private static final String NAME = "Neto";

    @Mock
    private WorkspaceRepository workspaceRepository;

    @Mock
    private UserService userService;

    @Mock
    private BaseRepository baseRepository;

    @Mock
    private Message message;

    @InjectMocks
    private WorkspaceService workspaceService;


    private User user;
    private Collaborator collaborator;
    private Workspace workspace;
    private Base firstBase;
    private Base secondBase;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        config();
    }

    @Test
    void createWorkspace(){
        //action
        Mockito.when(userService.findById(Mockito.anyString())).thenReturn(user);
        Mockito.when(workspaceRepository.save(new Workspace("WorkspaceTest", Arrays.asList(collaborator), Arrays.asList()))).thenReturn(workspace);
        Workspace currentWorkspace = workspaceService.save(new WorkspaceForm("WorkspaceTest", "1L"));

        //Assertions
        Mockito.verify(userService).findById("1L");
        Mockito.verify(workspaceRepository).save(new Workspace("WorkspaceTest", Arrays.asList(collaborator), Arrays.asList()));

        Assertions.assertEquals(workspace, currentWorkspace);
    }

    @Test
    void findById() {
        Mockito.when(workspaceRepository.findById(Mockito.anyString())).thenReturn(Optional.of(workspace));
        Workspace currentWorkspace = workspaceService.findById("1L");

        Assertions.assertEquals(workspace, currentWorkspace);
        Assertions.assertEquals(workspace.getId(), currentWorkspace.getId());
    }

    @Test
    void findByIdException(){
        Mockito.when(workspaceRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());

        //Assertions
        Assertions.assertThrows(NotFoundException.class, () -> workspaceService.findById("2L"), "Workspace no Exist!");
    }

    @Test
    void deleteWorkspace() {
        Mockito.when(workspaceRepository.findById(Mockito.anyString())).thenReturn(Optional.of(workspace));
        workspaceService.delete("1L");

        Mockito.verify(workspaceRepository, Mockito.times(1)).deleteById(ArgumentMatchers.any());
        Mockito.verify(baseRepository, Mockito.times(2)).deleteById(ArgumentMatchers.any());
    }

    public void config(){
        user = new User(ID, EMAIL, NAME, null);
        collaborator = new Collaborator(user, Access.OWNER);
        firstBase = new Base("1L","Base-1", Arrays.asList());
        secondBase = new Base("2L","Base-2", Arrays.asList());
        workspace = new Workspace("1L", "WorkspaceTest", Arrays.asList(collaborator), Arrays.asList(firstBase, secondBase));
    }
}
