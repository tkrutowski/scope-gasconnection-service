package net.focik.scopework.domain.scopegasconnection.infrastructure.inMemory;

import lombok.extern.java.Log;
import net.focik.scopework.domain.scopegasconnection.ScopeGasConnection;
import net.focik.scopework.domain.scopegasconnection.port.IScopeGasConnectionRepository;
import net.focik.scopework.domain.share.TaskType;
import net.focik.scopework.domain.scopegasconnection.infrastructure.dto.ScopeGasConnectionDbDto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//@Component()
//@Primary
@Log
class InMemoryScopeGasConnectionRepositoryAdapter implements IScopeGasConnectionRepository {
    private HashMap<Integer, ScopeGasConnection> gasConnectionDbDtoHashMap = new HashMap<>();


    @Override
    public Integer add(ScopeGasConnection dbDto) {
        int i=0;
    log.info("Try add into inMemoryDb clientDbDto: "+dbDto.toString());
        if(dbDto == null)
            throw new NullPointerException("ScopeGasConnection cannot be null");
        Integer id = gasConnectionDbDtoHashMap.size() + 1;
        ScopeGasConnection scopeGasConnection = ScopeGasConnection.builder()
                .typeOfTask(dbDto.getTypeOfTask())
                .sdr(dbDto.getSdr())
                .message(dbDto.getMessage())
                .material(dbDto.getMaterial())
                .lenghtWar(dbDto.getLenghtWar())
                .lenghtProj(dbDto.getLenghtProj())
                .diameter(dbDto.getDiameter())
                .gasCabinetPickupDate(dbDto.getGasCabinetPickupDate())
                .gasCabinetProvider(dbDto.getGasCabinetProvider())
                .id(id)
                .idTask(dbDto.getIdTask())
                .build();
        gasConnectionDbDtoHashMap.put(id,scopeGasConnection);
        log.info("Succssec id = " + id);
        return id;
    }


    @Override
    public Optional<ScopeGasConnection> findById(Integer id) {
        return Optional.ofNullable(gasConnectionDbDtoHashMap.get(id));
    }

    @Override
    public List<ScopeGasConnection> findByIdTaskAndTaskType(Integer id, TaskType taskType) {
        return null;
    }
}
