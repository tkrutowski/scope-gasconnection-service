package net.focik.scopework.domain.scopegasconnection;

import lombok.AllArgsConstructor;
import net.focik.scopework.domain.scopegasconnection.port.IScopeGasConnectionRepository;
import net.focik.scopework.domain.share.TaskType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScopeGasConnectionFacade {

    //@Qualifier("inMemoryClientRepositoryAdapter")
    private IScopeGasConnectionRepository scopeGasConnectionRepository;

//    @Value("${local.server.port}")
//    private int port;

    public Integer addScopeGasConnection(ScopeGasConnection scopeGasConnection) {
int i=0;

    return scopeGasConnectionRepository.add(scopeGasConnection);
    }


    public List<ScopeGasConnection> getScopeGasConnectionList(Integer idTask, TaskType taskType) {
        int i=0;
        return scopeGasConnectionRepository.findByIdTaskAndTaskType(idTask, taskType);
    }
}
