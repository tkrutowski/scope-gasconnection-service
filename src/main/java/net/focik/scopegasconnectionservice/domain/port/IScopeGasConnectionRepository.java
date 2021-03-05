package net.focik.scopegasconnectionservice.domain.port;

import net.focik.scopegasconnectionservice.domain.share.TaskType;
import net.focik.scopegasconnectionservice.infrastructure.dto.ScopeGasConnectionDbDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IScopeGasConnectionRepository {

    Integer add(ScopeGasConnectionDbDto scopeGasConnectionDbDto);

    Optional<ScopeGasConnectionDbDto> findById(Integer id);

    List<ScopeGasConnectionDbDto> findByIdTaskAndTaskType(Integer id, TaskType taskType);
//
//    List<Client> findAll();
//
//    void delete(Long id);
//
//    Optional<Client> edit(Client author);
//
//    Optional<Client> findByNip(String nip);
}
