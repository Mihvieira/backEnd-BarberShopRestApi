package com.barbershop.api.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class OffsetTimeConverter implements AttributeConverter<OffsetTime, String> {

    @Override
    public String convertToDatabaseColumn(OffsetTime offsetTime) {
        return offsetTime != null ? offsetTime.format(DateTimeFormatter.ISO_OFFSET_TIME.withZone(ZoneId.of("America/Sao_Paulo"))) : null;
    }

    @Override
    public OffsetTime convertToEntityAttribute(String dbData) {
        if(dbData != null){
            return OffsetTime.parse(dbData, DateTimeFormatter.ISO_OFFSET_TIME.withZone(ZoneId.of("America/Sao_Paulo")));
        } else {
            return null;
        }
    }
}
