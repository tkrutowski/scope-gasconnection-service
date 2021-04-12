package net.focik.scopegasconnectionservice.domain;

import lombok.AllArgsConstructor;
import net.focik.scopegasconnectionservice.domain.dto.ScopeGasConnectionDto;
import net.focik.scopegasconnectionservice.domain.port.IScopeGasConnectionRepository;
import net.focik.scopegasconnectionservice.domain.share.TaskType;
import net.focik.scopegasconnectionservice.infrastructure.dto.ScopeGasConnectionDbDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScopeGasConnectionFacade {

    //@Qualifier("inMemoryClientRepositoryAdapter")
    private IScopeGasConnectionRepository scopeGasConnectionRepository;
    private ModelMapper mapper;

//    @Value("${local.server.port}")
//    private int port;

    public Integer addScopeGasConnection(ScopeGasConnectionDto scopeDto) {
int i=0;
        ScopeGasConnectionDbDto dbDto = mapper.map(scopeDto, ScopeGasConnectionDbDto.class);
        return scopeGasConnectionRepository.add(dbDto);
    }


    public List<ScopeGasConnectionDto> getGasConnectionDtoList(Integer idTask, TaskType taskType) {
        int i=0;
        List<ScopeGasConnectionDbDto> scopeDbDtoList = scopeGasConnectionRepository.findByIdTaskAndTaskType(idTask, taskType);

        return mapToDto(scopeDbDtoList);
    }

    private List<ScopeGasConnectionDto> mapToDto(List<ScopeGasConnectionDbDto> scopeDbDtoList) {
        List<ScopeGasConnectionDto> scopeGasConnectionDtos =  new ArrayList<>();

        for (ScopeGasConnectionDbDto dbDto : scopeDbDtoList) {

            scopeGasConnectionDtos.add(mapper.map(dbDto, ScopeGasConnectionDto.class));
        }

        return scopeGasConnectionDtos;
    }
}
