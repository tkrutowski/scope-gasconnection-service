package net.focik.scopegasconnectionservice.infrastructure.dto;

import net.focik.scopegasconnectionservice.domain.share.SdrType;

import javax.persistence.AttributeConverter;

public class SdrTypeConverter implements AttributeConverter<SdrType, String> {
    @Override
    public String convertToDatabaseColumn(SdrType sdrType) {
        return sdrType.getDbValue();
    }

    @Override
    public SdrType convertToEntityAttribute(String s) {
        return SdrType.fromDbValue(s);
    }
}
