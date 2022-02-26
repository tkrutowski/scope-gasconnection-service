package net.focik.scopework.scopegasconnection.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.focik.scopework.scopegasconnection.domain.share.GasCabinetProviderType;
import net.focik.scopework.scopegasconnection.domain.share.MaterialType;
import net.focik.scopework.scopegasconnection.domain.share.SdrType;
import net.focik.scopework.share.TaskType;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
public class ScopeGasConnection {

    private Integer id;
    private Integer idTask;
    private TaskType typeOfTask;
    private String message;
    private Integer diameter;
    private float lenghtWar;
    private MaterialType material;
    private SdrType sdr;
    private float lenghtProj;
    private GasCabinetProviderType gasCabinetProvider;
    private LocalDate gasCabinetPickupDate;

    public String toJsonString() {
        return "{" +
                "id=" + id +
                ", idTask=" + idTask +
                ", typeOfTask='" + typeOfTask.toString()+ '\'' +
                ", message='" + message + '\'' +
                ", diameter=" + diameter +
                ", lenghtWar=" + lenghtWar +
                ", material='" + material.toString()+ '\'' +
                ", sdr='" + sdr.getDbValue() + '\'' +
                ", lenghtProj=" + lenghtProj +
                ", gasCabinetProvider='" + gasCabinetProvider.getDbValue()+ '\'' +
                ", gasCabinetPickupDate='" + gasCabinetPickupDate.toString()+ '\'' +
                '}';
    }
}
