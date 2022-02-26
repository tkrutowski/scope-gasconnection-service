package net.focik.scopework.scopegasconnection.infrastructure.jpa;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import net.focik.scopework.scopegasconnection.domain.ScopeGasConnection;
import net.focik.scopework.scopegasconnection.port.secondary.IScopeGasConnectionRepository;
import net.focik.scopework.share.TaskType;
import net.focik.scopework.scopegasconnection.infrastructure.dto.ScopeGasConnectionDbDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Log
class ScopeGasConnectionRepositoryAdapter implements IScopeGasConnectionRepository {

    private IScopeGasConnectionDtoRepository scopeGasConnectionDtoRepository;

    @Override
    public Integer add(ScopeGasConnection scopeGasConnection) {
        Integer id = scopeGasConnectionDtoRepository.save(JpaMapper.toDto(scopeGasConnection)).getId();
        log.info("Add into Db scopeGasConnectionDbDto: " + scopeGasConnection.toString());
        return id;
    }

    @Override
    public Optional<ScopeGasConnection> findById(Integer id) {
        log.info("Try findById from Db scopeGasConnectionDbDto: ID = " + id);
        Optional<ScopeGasConnectionDbDto> byId = scopeGasConnectionDtoRepository.findById(id);

        if (byId.isPresent())
            log.info("Found scopeGasConnectionDbDto: " + byId.get().toString());
        else
            log.info("Not found scopeGasConnectionDbDto: ID = " + id);
        return Optional.of(JpaMapper.toDomain(byId.get()));
    }

    @Override
    public List<ScopeGasConnection> findByIdTaskAndTaskType(Integer idTask, TaskType taskType) {
        log.info("Try find scopeGasConnectionDbDtos by ID_TASK = " + idTask + " and TASK_TYPE = " + taskType.getDbValue());
        List<ScopeGasConnectionDbDto> dtoList = scopeGasConnectionDtoRepository.findAllByIdTaskAndAndTypeOfTask(idTask, taskType.getDbValue());
        if (dtoList.size() > 0)
            log.info("Found " + dtoList.size() + " scopeGasConnectionDbDto.");
        else
            log.info("Not found scopeGasConnectionDbDto: ID_TASK = " + idTask + " and TASK_TYPE = " + taskType.getDbValue());
        return dtoList.stream()
                .map(dbDto -> JpaMapper.toDomain(dbDto))
                .collect(Collectors.toList());
    }


}
