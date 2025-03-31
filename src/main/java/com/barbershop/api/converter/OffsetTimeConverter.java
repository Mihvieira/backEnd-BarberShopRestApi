package com.barbershop.api.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class OffsetTimeConverter implements AttributeConverter<OffsetTime, String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_TIME;

    @Override
    public String convertToDatabaseColumn(OffsetTime offsetTime) {
        return offsetTime != null ? offsetTime.format(FORMATTER) : null;
    }

    @Override
    public OffsetTime convertToEntityAttribute(String dbData) {
        return dbData != null ? OffsetTime.parse(dbData, FORMATTER) : null;
    }
}
