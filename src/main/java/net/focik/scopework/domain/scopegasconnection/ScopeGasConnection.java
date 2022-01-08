package net.focik.scopework.domain.scopegasconnection;

import lombok.Builder;
import lombok.Getter;
import net.focik.scopework.domain.share.GasCabinetProviderType;
import net.focik.scopework.domain.share.MaterialType;
import net.focik.scopework.domain.share.SdrType;
import net.focik.scopework.domain.share.TaskType;

import java.time.LocalDate;

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
}
