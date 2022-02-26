package net.focik.scopework.scopegasconnection.infrastructure.dto;

import net.focik.scopework.scopegasconnection.domain.share.SdrType;

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
