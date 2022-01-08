package net.focik.scopework.domain.scopegasconnection.port;

import net.focik.scopework.domain.scopegasconnection.ScopeGasConnection;
import net.focik.scopework.domain.share.TaskType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Component
public interface IScopeGasConnectionRepository {

    Integer add(ScopeGasConnection scopeGasConnection);

    Optional<ScopeGasConnection> findById(Integer id);

    List<ScopeGasConnection> findByIdTaskAndTaskType(Integer id, TaskType taskType);
}
