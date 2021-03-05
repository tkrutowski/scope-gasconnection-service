package net.focik.scopegasconnectionservice.infrastructure.jpa;

import net.focik.scopegasconnectionservice.domain.share.GasCabinetProviderType;
import net.focik.scopegasconnectionservice.domain.share.MaterialType;
import net.focik.scopegasconnectionservice.domain.share.SdrType;
import net.focik.scopegasconnectionservice.domain.share.TaskType;
import net.focik.scopegasconnectionservice.infrastructure.dto.ScopeGasConnectionDbDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScopeGasConnectionRepositoryAdapterTest {

    @Autowired
    private IScopeGasConnectionDtoRepository scopeGasConnectionDtoRepository;

    @Test
    void should_return_added_scope_id() {
        //when
        ScopeGasConnectionDbDto dto = createDbDto();

        //given
        Integer resultId = scopeGasConnectionDtoRepository.save(dto).getId();

        //then
        Assertions.assertTrue(resultId > 0);

    }

    @Test
    void should_return_list_3_scope_when_3_added_with_same_idTask() {
        //when
        final Integer TASK_ID = 2;
        final TaskType TASK_TYPE = TaskType.GAS_CONNECTION;
        scopeGasConnectionDtoRepository.save(createDbDto1());
        scopeGasConnectionDtoRepository.save(createDbDto2());
        scopeGasConnectionDtoRepository.save(createDbDto3());

        //given
        List<ScopeGasConnectionDbDto> result = scopeGasConnectionDtoRepository.findAllByIdTaskAndAndTypeOfTask(TASK_ID, TASK_TYPE.getDbValue());
        //then
        Assertions.assertTrue(result.size() == 3);

    }

    @Test
    void should_return_added_scope() {
        //when
        ScopeGasConnectionDbDto dto = new ScopeGasConnectionDbDto();
        dto.setDiameter(25);
        dto.setGasCabinetPickupDate(LocalDate.of(2020,12,21));
        dto.setGasCabinetProvider(GasCabinetProviderType.CUSTOMER);
        dto.setIdTask(10);
        dto.setLenghtProj(11.2f);
        dto.setLenghtWar(22.2f);
        dto.setMaterial(MaterialType.PE100RC);
        dto.setMessage("test message");
        dto.setSdr(SdrType.SDR_17_6);
        dto.setTypeOfTask(TaskType.GAS_CONNECTION);

        //given
        ScopeGasConnectionDbDto result = scopeGasConnectionDtoRepository.save(dto);

        //then
        Assertions.assertEquals(dto.getDiameter(),result.getDiameter());
        Assertions.assertEquals(dto.getGasCabinetProvider(),result.getGasCabinetProvider());
        Assertions.assertEquals(dto.getGasCabinetPickupDate(),result.getGasCabinetPickupDate());
        Assertions.assertEquals(dto.getIdTask(),result.getIdTask());
        Assertions.assertEquals(dto.getLenghtProj(),result.getLenghtProj());
        Assertions.assertEquals(dto.getLenghtWar(),result.getLenghtWar());
        Assertions.assertEquals(dto.getMaterial(),result.getMaterial());
        Assertions.assertEquals(dto.getMessage(),result.getMessage());
        Assertions.assertEquals(dto.getSdr(),result.getSdr());
        Assertions.assertEquals(dto.getTypeOfTask(),result.getTypeOfTask());
    }

    private ScopeGasConnectionDbDto createDbDto() {
        ScopeGasConnectionDbDto dto = new ScopeGasConnectionDbDto();
        dto.setIdTask(2);
        dto.setGasCabinetProvider(GasCabinetProviderType.CUSTOMER);
        dto.setTypeOfTask(TaskType.GAS_CONNECTION);
        dto.setSdr(SdrType.SDR_17_6);
        dto.setMaterial(MaterialType.PE100);

        return dto;
    }

    private ScopeGasConnectionDbDto createDbDto1() {
        ScopeGasConnectionDbDto dto = new ScopeGasConnectionDbDto();
        dto.setIdTask(2);
        dto.setGasCabinetProvider(GasCabinetProviderType.CUSTOMER);
        dto.setTypeOfTask(TaskType.GAS_CONNECTION);
        dto.setSdr(SdrType.SDR_17_6);
        dto.setMaterial(MaterialType.PE100);
        return dto;
    }

    private ScopeGasConnectionDbDto createDbDto2() {
        ScopeGasConnectionDbDto dto = new ScopeGasConnectionDbDto();
        dto.setIdTask(2);
        dto.setGasCabinetProvider(GasCabinetProviderType.COMPANY);
        dto.setTypeOfTask(TaskType.GAS_CONNECTION);
        dto.setSdr(SdrType.SDR_17_6);
        dto.setMaterial(MaterialType.PE100);
        return dto;
    }

    private ScopeGasConnectionDbDto createDbDto3() {
        ScopeGasConnectionDbDto dto = new ScopeGasConnectionDbDto();
        dto.setIdTask(2);
        dto.setGasCabinetProvider(GasCabinetProviderType.COMPANY);
        dto.setTypeOfTask(TaskType.GAS_CONNECTION);
        dto.setSdr(SdrType.SDR_11);
        dto.setMaterial(MaterialType.PE100RC);
        return dto;
    }
}