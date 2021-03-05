package net.focik.scopegasconnectionservice.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.focik.scopegasconnectionservice.domain.ScopeGasConnectionFacade;
import net.focik.scopegasconnectionservice.domain.dto.ScopeGasConnectionDto;
import net.focik.scopegasconnectionservice.domain.share.TaskType;
import net.focik.scopegasconnectionservice.infrastructure.dto.ScopeGasConnectionDbDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/scopegasconnection")
class ScopeGasConnectionController {

    private ScopeGasConnectionFacade scopeGasConnectionFacade;

    @PostMapping
    public Integer addScopeGasConnection(@RequestBody ScopeGasConnectionDbDto scopeGasConnectionDbDto){
        return scopeGasConnectionFacade.addScopeGasConnection(scopeGasConnectionDbDto);
    }

    @GetMapping("/{id}")
    List<ScopeGasConnectionDto> getScopeGasConnection(@PathVariable Integer id, @RequestParam(name = "type", defaultValue = "GAS_CONNECTION") TaskType taskType){
        int i=0;
        return scopeGasConnectionFacade.getGasConnectionDto(id, taskType);
    }

}
