package net.focik.scopegasconnectionservice.domain;

import net.focik.scopegasconnectionservice.domain.share.GasCabinetProviderType;
import net.focik.scopegasconnectionservice.domain.share.MaterialType;
import net.focik.scopegasconnectionservice.domain.share.SdrType;
import net.focik.scopegasconnectionservice.domain.share.TaskType;

import java.time.LocalDate;

class ScopeGasConnection {

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
    private LocalDate fasCabinetPickupDate;
}
