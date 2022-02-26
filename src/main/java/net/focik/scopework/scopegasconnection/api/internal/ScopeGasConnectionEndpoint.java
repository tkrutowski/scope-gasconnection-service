package net.focik.scopework.scopegasconnection.api.internal;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.scopework.scopegasconnection.domain.ScopeGasConnection;
import net.focik.scopework.scopegasconnection.port.primary.GetScopeGasConnectionUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Log4j2
@Component
public class ScopeGasConnectionEndpoint {

    private GetScopeGasConnectionUseCase getScopeGasConnectionUseCase;

    public String getScopeGasConnection(Integer id, String taskType) {
        log.info("SCOPEWORK-INTERNAL-SERVICE: Try find scopeGasConnection for  id = " + id + " and TaskType = " + taskType);
        List<ScopeGasConnection> scopes = getScopeGasConnectionUseCase.getScopeGasConnectionByIdAndType(id, taskType);
        log.info(!scopes.isEmpty() ? "SCOPEWORK-INTERNAL-SERVICE: Found scopeGasConnection for id = " + id +
                " and TaskType = " + taskType : "SCOPEWORK-INTERNAL-SERVICE: Not found scopeGasConnection for id = " + id + " and TaskType = " + taskType);

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (ScopeGasConnection scope : scopes) {
            builder.append(scope.toJsonString());
            builder.append(",");
        }
        int index = builder.lastIndexOf(",");
        if (index != -1) {
            builder.deleteCharAt(index);
        }
        builder.append("]");
        String s = builder.toString();

        return s;
    }
}
