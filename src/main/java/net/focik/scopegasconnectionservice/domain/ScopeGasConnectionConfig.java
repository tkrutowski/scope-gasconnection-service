package net.focik.scopegasconnectionservice.domain;

import net.focik.scopegasconnectionservice.domain.dto.ScopeGasConnectionDto;
import net.focik.scopegasconnectionservice.domain.share.GasCabinetProviderType;
import net.focik.scopegasconnectionservice.infrastructure.dto.ScopeGasConnectionDbDto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ScopeGasConnectionConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addConverter(scopeDtoDbToDtoCalendarConverter);
        return mapper;
    }


    public Converter<ScopeGasConnectionDbDto, ScopeGasConnectionDto> scopeDtoDbToDtoCalendarConverter = new Converter<>() {
        public ScopeGasConnectionDto convert(MappingContext<ScopeGasConnectionDbDto, ScopeGasConnectionDto> context) {

            ScopeGasConnectionDbDto dbDto = context.getSource();
            ScopeGasConnectionDto dto = new ScopeGasConnectionDto();// context.getDestination();

            dto.setId(dbDto.getId());
            dto.setDiameter(dbDto.getDiameter());
            dto.setGasCabinetProvider(dbDto.getGasCabinetProvider().getDbValue());
            dto.setGasCabinetPickupDate(dbDto.getGasCabinetPickupDate());
            dto.setIdTask(dbDto.getIdTask());
            dto.setLenghtProj(dbDto.getLenghtProj());
            dto.setLenghtWar(dbDto.getLenghtWar());
            dto.setMaterial(dbDto.getMaterial().toString());
            dto.setMessage(dbDto.getMessage());
            dto.setSdr(dbDto.getSdr().toString());
            dto.setTypeOfTask(dbDto.getTypeOfTask().toString());

            return dto;
//                return context.getSource() == null ? null : context.getSource().toUpperCase();
        }
    };
}
