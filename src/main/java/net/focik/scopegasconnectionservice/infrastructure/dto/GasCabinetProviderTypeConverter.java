package net.focik.scopegasconnectionservice.infrastructure.dto;

import net.focik.scopegasconnectionservice.domain.share.GasCabinetProviderType;

import javax.persistence.AttributeConverter;

//@Converter(autoApply = true)
public class GasCabinetProviderTypeConverter implements AttributeConverter<GasCabinetProviderType, String> {
    @Override
    public String convertToDatabaseColumn(GasCabinetProviderType gasCabinetProviderType) {
        return gasCabinetProviderType.getDbValue();
    }

    @Override
    public GasCabinetProviderType convertToEntityAttribute(String s) {
        return GasCabinetProviderType.fromDbValue(s);
    }
}
