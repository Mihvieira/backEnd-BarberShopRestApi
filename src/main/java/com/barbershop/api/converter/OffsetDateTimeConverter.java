package com.barbershop.api.converter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OffsetDateTimeConverter implements AttributeConverter<OffsetDateTime, String> {
    @Override
    public String convertToDatabaseColumn(OffsetDateTime attribute) {
        return attribute != null ? attribute.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : null;
    }

    @Override
    public OffsetDateTime convertToEntityAttribute(String dbData) {
        if(dbData != null){
            if(dbData.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$")){ 
                return OffsetDateTime.parse(dbData.replace(' ', 'T') + "+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            }else{
                return OffsetDateTime.parse(dbData, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            }
        } else {
            return null;
        }
    }
}
