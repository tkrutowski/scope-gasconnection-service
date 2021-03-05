package net.focik.scopegasconnectionservice.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class ScopeGasConnectionFacade {

    //@Qualifier("inMemoryClientRepositoryAdapter")
    private IScopeGasConnectionRepository scopeGasConnectionRepository;
    private ModelMapper mapper;

//    @Value("${local.server.port}")
//    private int port;

    public Integer addScopeGasConnection(ScopeGasConnectionDbDto scopeDbDto) {
int i=0;
         return scopeGasConnectionRepository.add(scopeDbDto);
    }


    public List<ScopeGasConnectionDto> getGasConnectionDto(Integer id, TaskType taskType) {
        int i=0;
        //List<ScopeGasConnectionDbDto> scopeDbDtoList = scopeGasConnectionRepository.findByIdTaskAndTaskType(id, taskType);

        return null;//mapToDto(scopeDbDtoList);
    }

    private List<ScopeGasConnectionDto> mapToDto(List<ScopeGasConnectionDbDto> scopeDbDtoList) {
        List<ScopeGasConnectionDto> scopeGasConnectionDtos =  new ArrayList<>();

        for (ScopeGasConnectionDbDto dbDto : scopeDbDtoList) {

            scopeGasConnectionDtos.add(mapper.map(dbDto, ScopeGasConnectionDto.class));
        }

        return scopeGasConnectionDtos;
    }
}
