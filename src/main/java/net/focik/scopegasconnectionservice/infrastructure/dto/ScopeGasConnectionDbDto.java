package net.focik.scopegasconnectionservice.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.focik.scopegasconnectionservice.domain.share.GasCabinetProviderType;
import net.focik.scopegasconnectionservice.domain.share.TaskType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Zakres_przylacze")
public class ScopeGasConnectionDbDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zakresu")
    private Integer id;
    @Column(name = "id_zadania")
    private Integer idTask;
    @Column(name = "rodzaj_zadania")
    @Convert(converter = TaskTypeConverter.class)
    private TaskType typeOfTask;
    @Column(name = "inne")
    private String message;
    @Column(name = "srednica")
    private Integer diameter;
    @Column(name = "dlugosc")
    private float lenghtWar;
    @Column(name = "material")
    private String material;
    @Column(name = "sdr")
    private String sdr;
    @Column(name = "dlugosc_proj")
    private float lenghtProj;
    @Convert(converter = GasCabinetProviderTypeConverter.class)
    @Column(name = "szafke_dostarcza")
    private GasCabinetProviderType gasCabinetProvider;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "szafka_data_odbioru")
    private LocalDate fasCabinetPickupDate;
}
