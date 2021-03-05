package net.focik.scopegasconnectionservice.infrastructure.inMemory;

import lombok.extern.java.Log;
import net.focik.scopegasconnectionservice.domain.port.IScopeGasConnectionRepository;
import net.focik.scopegasconnectionservice.domain.share.TaskType;
import net.focik.scopegasconnectionservice.infrastructure.dto.ScopeGasConnectionDbDto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//@Component()
//@Primary
@Log
class InMemoryScopeGasConnectionRepositoryAdapter implements IScopeGasConnectionRepository {
    private HashMap<Integer, ScopeGasConnectionDbDto> gasConnectionDbDtoHashMap = new HashMap<>();


    @Override
    public Integer add(ScopeGasConnectionDbDto dbDto) {
        int i=0;
    log.info("Try add into inMemoryDb clientDbDto: "+dbDto.toString());
        if(dbDto == null)
            throw new NullPointerException("ClientDbDto cannot be null");
        Integer id = gasConnectionDbDtoHashMap.size() + 1;
        dbDto.setId(id);
        gasConnectionDbDtoHashMap.put(id,dbDto);
        log.info("Succssec id = " + id);
        return id;
    }


    @Override
    public Optional<ScopeGasConnectionDbDto> findById(Integer id) {
        return Optional.ofNullable(gasConnectionDbDtoHashMap.get(id));
    }

    @Override
    public List<ScopeGasConnectionDbDto> findByIdTaskAndTaskType(Integer id, TaskType taskType) {
        return null;
    }
}
