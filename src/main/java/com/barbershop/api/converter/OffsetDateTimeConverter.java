package com.barbershop.api.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class OffsetDateTimeConverter implements AttributeConverter<OffsetDateTime, String> {
    @Override
    public String convertToDatabaseColumn(OffsetDateTime attribute) {
        return attribute != null ? attribute.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.of("America/Sao_Paulo"))) : null;
    }

    @Override
    public OffsetDateTime convertToEntityAttribute(String dbData) {
        if(dbData != null){
            return OffsetDateTime.parse(dbData, DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.of("America/Sao_Paulo")));
        } else {
            return null;
        }
    }
}
