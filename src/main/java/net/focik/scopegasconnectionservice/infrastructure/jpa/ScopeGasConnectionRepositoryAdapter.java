package net.focik.scopegasconnectionservice.infrastructure.jpa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.focik.scopegasconnectionservice.domain.port.IScopeGasConnectionRepository;
import net.focik.scopegasconnectionservice.domain.share.TaskType;
import net.focik.scopegasconnectionservice.infrastructure.dto.ScopeGasConnectionDbDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@NoArgsConstructor
class ScopeGasConnectionRepositoryAdapter implements IScopeGasConnectionRepository {

    private IScopeGasConnectionDtoRepository scopeGasConnectionDtoRepository;

    @Override
    public Integer add(ScopeGasConnectionDbDto scopeGasConnectionDbDto) {
        return scopeGasConnectionDtoRepository.save(scopeGasConnectionDbDto).getId();
    }

    @Override
    public Optional<ScopeGasConnectionDbDto> findById(Integer id) {
        return scopeGasConnectionDtoRepository.findById(id);
    }

//    @Override
//    public List<ScopeGasConnectionDbDto> findByIdTaskAndTaskType(Integer id, TaskType taskType) {
//        return scopeGasConnectionDtoRepository.findAllByIdTaskAndAndTypeOfTask(id, taskType.getDbValue());
//    }
}
