package net.focik.scopework.scopegasconnection.application;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.scopework.scopegasconnection.domain.ScopeGasConnection;
import net.focik.scopework.scopegasconnection.domain.ScopeGasConnectionFacade;
import net.focik.scopework.scopegasconnection.port.primary.GetScopeGasConnectionUseCase;
import net.focik.scopework.share.TaskType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@AllArgsConstructor
@Service
public class ScopeGasConnectionService implements GetScopeGasConnectionUseCase {

    ScopeGasConnectionFacade scopeGasConnectionFacade;

    @Override
    public List<ScopeGasConnection> getScopeGasConnectionByIdAndType(int id, String dtoType) {
        try {
            TaskType taskType = TaskType.valueOf(dtoType);
            return scopeGasConnectionFacade.getScopeGasConnectionList(id, taskType);
        } catch (IllegalArgumentException e) {
            log.error("Value [ " + dtoType + " ] not supported." + e.getMessage());
        }
        return new ArrayList<>();
    }
}
