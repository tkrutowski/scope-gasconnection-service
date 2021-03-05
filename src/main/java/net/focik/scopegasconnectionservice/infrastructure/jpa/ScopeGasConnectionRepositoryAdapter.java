package net.focik.scopegasconnectionservice.infrastructure.jpa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import net.focik.scopegasconnectionservice.domain.port.IScopeGasConnectionRepository;
import net.focik.scopegasconnectionservice.domain.share.TaskType;
import net.focik.scopegasconnectionservice.infrastructure.dto.ScopeGasConnectionDbDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Log
class ScopeGasConnectionRepositoryAdapter implements IScopeGasConnectionRepository {

    private IScopeGasConnectionDtoRepository scopeGasConnectionDtoRepository;

    @Override
    public Integer add(ScopeGasConnectionDbDto scopeGasConnectionDbDto) {
        Integer id = scopeGasConnectionDtoRepository.save(scopeGasConnectionDbDto).getId();
        log.info("Add into Db scopeGasConnectionDbDto: " + scopeGasConnectionDbDto.toString());
        return id;
    }

    @Override
    public Optional<ScopeGasConnectionDbDto> findById(Integer id) {
        log.info("Try findById from Db scopeGasConnectionDbDto: ID = " + id);
        Optional<ScopeGasConnectionDbDto> byId = scopeGasConnectionDtoRepository.findById(id);

        if (byId.isPresent())
            log.info("Found scopeGasConnectionDbDto: " + byId.get().toString());
        else
            log.info("Not found scopeGasConnectionDbDto: ID = " + id);
        return byId;
    }

    @Override
    public List<ScopeGasConnectionDbDto> findByIdTaskAndTaskType(Integer id, TaskType taskType) {
        log.info("Try find scopeGasConnectionDbDtos by ID = " + id + " and TASK_TYPE = " + taskType);
        List<ScopeGasConnectionDbDto> dtoList = scopeGasConnectionDtoRepository.findAllByIdTaskAndAndTypeOfTask(id, taskType.getDbValue());
        if (dtoList.size() > 0)
            log.info("Found " + dtoList.size() + " scopeGasConnectionDbDto.");
        else
            log.info("Not found scopeGasConnectionDbDto: ID = " + id + " and TASK_TYPE = " + taskType);
        return dtoList;
    }
}
