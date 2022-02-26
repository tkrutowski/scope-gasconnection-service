package net.focik.scopework.scopegasconnection.port.secondary;

import net.focik.scopework.scopegasconnection.domain.ScopeGasConnection;
import net.focik.scopework.share.TaskType;

import java.util.List;
import java.util.Optional;

//@Component
public interface IScopeGasConnectionRepository {

    Integer add(ScopeGasConnection scopeGasConnection);

    Optional<ScopeGasConnection> findById(Integer id);

    List<ScopeGasConnection> findByIdTaskAndTaskType(Integer id, TaskType taskType);
}
