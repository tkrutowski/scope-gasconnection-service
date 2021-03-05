package net.focik.scopegasconnectionservice.infrastructure.jpa;

import net.focik.scopegasconnectionservice.domain.share.TaskType;
import net.focik.scopegasconnectionservice.infrastructure.dto.ScopeGasConnectionDbDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface IScopeGasConnectionDtoRepository extends JpaRepository<ScopeGasConnectionDbDto, Integer> {



    @Query(value = "SELECT * from Zakres_przylacze s WHERE s.id_zadania= ?1 and s.rodzaj_zadania =  ?2", nativeQuery = true)
    List<ScopeGasConnectionDbDto> findAllByIdTaskAndAndTypeOfTask(Integer id, String taskType);
}
