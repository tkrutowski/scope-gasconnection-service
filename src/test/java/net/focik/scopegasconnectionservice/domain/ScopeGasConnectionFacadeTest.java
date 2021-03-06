package net.focik.scopegasconnectionservice.domain;

import net.focik.scopegasconnectionservice.domain.dto.ScopeGasConnectionDto;
import net.focik.scopegasconnectionservice.domain.share.GasCabinetProviderType;
import net.focik.scopegasconnectionservice.domain.share.MaterialType;
import net.focik.scopegasconnectionservice.domain.share.SdrType;
import net.focik.scopegasconnectionservice.domain.share.TaskType;
import net.focik.scopegasconnectionservice.infrastructure.dto.ScopeGasConnectionDbDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScopeGasConnectionFacadeTest {

    @Autowired
    private ScopeGasConnectionFacade scopeGasConnectionFacade;
    @Autowired
    ModelMapper mapper;

    @Test
    void should_convert_dbDto_into_Dto() {
        //when
        ScopeGasConnectionDbDto dbDto = new ScopeGasConnectionDbDto();
        dbDto.setId(1);
        dbDto.setDiameter(25);
        dbDto.setGasCabinetPickupDate(LocalDate.of(2020,12,21));
        dbDto.setGasCabinetProvider(GasCabinetProviderType.CUSTOMER);
        dbDto.setIdTask(10);
        dbDto.setLenghtProj(11.2f);
        dbDto.setLenghtWar(22.2f);
        dbDto.setMaterial(MaterialType.PE100RC);
        dbDto.setMessage("test message");
        dbDto.setSdr(SdrType.SDR_17_6);
        dbDto.setTypeOfTask(TaskType.GAS_CONNECTION);

        //given
        ScopeGasConnectionDto dto = mapper.map(dbDto, ScopeGasConnectionDto.class);

        //then
        Assertions.assertEquals(dbDto.getId(),dto.getId());
        Assertions.assertEquals(dbDto.getDiameter(),dto.getDiameter());
        Assertions.assertEquals(dbDto.getGasCabinetProvider().toString(),dto.getGasCabinetProvider());
        Assertions.assertEquals(dbDto.getGasCabinetPickupDate(),dto.getGasCabinetPickupDate());
        Assertions.assertEquals(dbDto.getIdTask(),dto.getIdTask());
        Assertions.assertEquals(dbDto.getLenghtProj(),dto.getLenghtProj());
        Assertions.assertEquals(dbDto.getLenghtWar(),dto.getLenghtWar());
        Assertions.assertEquals(dbDto.getMaterial().toString(),dto.getMaterial());
        Assertions.assertEquals(dbDto.getMessage(),dto.getMessage());
        Assertions.assertEquals(dbDto.getSdr().toString(),dto.getSdr());
        Assertions.assertEquals(dbDto.getTypeOfTask().toString(),dto.getTypeOfTask());
    }

    @Test
    void should_convert_Dto_into_dbDto() {
        //when
        ScopeGasConnectionDto dto = new ScopeGasConnectionDto();
        dto.setId(1);
        dto.setIdTask(10);
        dto.setTypeOfTask(TaskType.GAS_CONNECTION.toString());
        dto.setMessage("test message");
        dto.setDiameter(25);
        dto.setLenghtWar(22.2f);
        dto.setMaterial(MaterialType.PE100RC.toString());
        dto.setSdr(SdrType.SDR_17_6.toString());
        dto.setLenghtProj(11.2f);
        dto.setGasCabinetProvider(GasCabinetProviderType.CUSTOMER.toString());
        dto.setGasCabinetPickupDate(LocalDate.of(2020,12,21));


        //given
        ScopeGasConnectionDbDto dbDto = mapper.map(dto, ScopeGasConnectionDbDto.class);

        //then
        Assertions.assertEquals(dto.getId(),dbDto.getId());
        Assertions.assertEquals(dto.getDiameter(),dbDto.getDiameter());
        Assertions.assertEquals(dto.getGasCabinetProvider(),dbDto.getGasCabinetProvider().toString());
        Assertions.assertEquals(dto.getGasCabinetPickupDate(),dbDto.getGasCabinetPickupDate());
        Assertions.assertEquals(dto.getIdTask(),dbDto.getIdTask());
        Assertions.assertEquals(dto.getLenghtProj(),dbDto.getLenghtProj());
        Assertions.assertEquals(dto.getLenghtWar(),dbDto.getLenghtWar());
        Assertions.assertEquals(dto.getMaterial(),dbDto.getMaterial().toString());
        Assertions.assertEquals(dto.getMessage(),dbDto.getMessage());
        Assertions.assertEquals(dto.getSdr(),dbDto.getSdr().toString());
        Assertions.assertEquals(dto.getTypeOfTask(),dbDto.getTypeOfTask().toString());
    }
}