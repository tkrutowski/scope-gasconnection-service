package net.focik.scopework.scopegasconnection.domain;

import lombok.AllArgsConstructor;
import net.focik.scopework.scopegasconnection.port.secondary.IScopeGasConnectionRepository;
import net.focik.scopework.share.TaskType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScopeGasConnectionFacade {

    private IScopeGasConnectionRepository scopeGasConnectionRepository;

    public Integer addScopeGasConnection(ScopeGasConnection scopeGasConnection) {
        int i = 0;
        return scopeGasConnectionRepository.add(scopeGasConnection);
    }

    public List<ScopeGasConnection> getScopeGasConnectionList(Integer idTask, TaskType taskType) {
        int i = 0;
        return scopeGasConnectionRepository.findByIdTaskAndTaskType(idTask, taskType);
    }
}
