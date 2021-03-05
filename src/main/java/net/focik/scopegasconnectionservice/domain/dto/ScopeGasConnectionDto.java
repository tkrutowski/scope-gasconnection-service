package net.focik.scopegasconnectionservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.focik.scopegasconnectionservice.domain.share.GasCabinetProviderType;
import net.focik.scopegasconnectionservice.domain.share.TaskType;

import java.time.LocalDate;
//import net.focik.customers.domain.ClientType;

//
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Entity
//@Table(name = "userbooks")
public class ScopeGasConnectionDto {
    private Integer id;
    private Integer idTask;
    private String typeOfTask;
    private String message;
    private Integer diameter;
    private float lenghtWar;
    private String material;
    private String sdr;
    private float lenghtProj;
    private String gasCabinetProvider;
    private LocalDate fasCabinetPickupDate;
}
