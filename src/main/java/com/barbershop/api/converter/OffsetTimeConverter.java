package com.barbershop.api.converter;

import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OffsetTimeConverter implements AttributeConverter<OffsetTime, String> {

    @Override
    public String convertToDatabaseColumn(OffsetTime offsetTime) {
        return offsetTime != null ? offsetTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")) : null;
    }

    @Override
    public OffsetTime convertToEntityAttribute(String dbData) {
        if(dbData != null){
            if(dbData.matches("^\\d{2}:\\d{2}:\\d{2}$")){
                return OffsetTime.parse(dbData + "+00:00", DateTimeFormatter.ISO_OFFSET_TIME);
            }else{
                return OffsetTime.parse(dbData, DateTimeFormatter.ISO_TIME);
            }
        } else {
            return null;
        }
    }
}
