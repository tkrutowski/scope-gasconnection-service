package net.focik.scopegasconnectionservice.api;

import lombok.AllArgsConstructor;
import net.focik.scopegasconnectionservice.domain.ScopeGasConnectionFacade;
import net.focik.scopegasconnectionservice.domain.dto.ScopeGasConnectionDto;
import net.focik.scopegasconnectionservice.domain.share.TaskType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/scopegasconnection")
class ScopeGasConnectionController {

    private ScopeGasConnectionFacade scopeGasConnectionFacade;

    @PostMapping
    public Integer addScopeGasConnection(@RequestBody ScopeGasConnectionDto scopeGasConnectionDto) {
        return scopeGasConnectionFacade.addScopeGasConnection(scopeGasConnectionDto);
    }

    @GetMapping("/task/{idTask}")
    ResponseEntity<List<ScopeGasConnectionDto>> getScopeGasConnection(@PathVariable Integer idTask, @RequestParam(name = "type", defaultValue = "GAS_CONNECTION") TaskType taskType) {
        int i = 0;
        List<ScopeGasConnectionDto> gasConnectionDtoList = scopeGasConnectionFacade.getScopeGasConnectionDtoList(idTask, taskType);
        return new ResponseEntity<>(gasConnectionDtoList, HttpStatus.OK);
    }

}
