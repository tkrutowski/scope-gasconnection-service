package net.focik.scopework.scopegasconnection.port.primary;

import net.focik.scopework.scopegasconnection.domain.ScopeGasConnection;

import java.util.List;

public interface GetScopeGasConnectionUseCase {
    List<ScopeGasConnection> getScopeGasConnectionByIdAndType(int id, String dtoType);
}
