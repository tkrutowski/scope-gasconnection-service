package net.focik.scopework.domain.scopegasconnection.infrastructure.jpa;

import net.focik.scopework.domain.scopegasconnection.ScopeGasConnection;
import net.focik.scopework.domain.scopegasconnection.infrastructure.dto.ScopeGasConnectionDbDto;
import net.focik.scopework.domain.share.GasCabinetProviderType;
import net.focik.scopework.domain.share.MaterialType;
import net.focik.scopework.domain.share.SdrType;
import net.focik.scopework.domain.share.TaskType;

public class JpaMapper {
    public static ScopeGasConnection toDomain(ScopeGasConnectionDbDto dbDto){
        return ScopeGasConnection.builder()
        .id(dbDto.getId())
        .diameter(dbDto.getDiameter())
        .gasCabinetProvider(dbDto.getGasCabinetProvider())
        .gasCabinetPickupDate(dbDto.getGasCabinetPickupDate())
        .idTask(dbDto.getIdTask())
        .lenghtProj(dbDto.getLenghtProj())
        .lenghtWar(dbDto.getLenghtWar())
        .material(dbDto.getMaterial())
        .message(dbDto.getMessage())
        .sdr(dbDto.getSdr())
        .typeOfTask(dbDto.getTypeOfTask())
        .build();
    }

    public static ScopeGasConnectionDbDto toDto(ScopeGasConnection scopeGasConnection){
        ScopeGasConnectionDbDto dto = new ScopeGasConnectionDbDto();

        dto.setId(scopeGasConnection.getId());
        dto.setIdTask(scopeGasConnection.getIdTask());
        dto.setTypeOfTask(scopeGasConnection.getTypeOfTask());
        dto.setDiameter(scopeGasConnection.getDiameter());
        dto.setLenghtWar(scopeGasConnection.getLenghtWar());
        dto.setMaterial(scopeGasConnection.getMaterial());
        dto.setSdr(scopeGasConnection.getSdr());
        dto.setLenghtProj(scopeGasConnection.getLenghtProj());
        dto.setGasCabinetProvider(scopeGasConnection.getGasCabinetProvider());
        dto.setGasCabinetPickupDate(scopeGasConnection.getGasCabinetPickupDate());
        dto.setMessage(scopeGasConnection.getMessage());

        return dto;
    }
}
