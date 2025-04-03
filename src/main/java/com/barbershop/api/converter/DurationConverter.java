package com.barbershop.api.converter;

import java.time.Duration;

import jakarta.persistence.AttributeConverter;

public class DurationConverter implements AttributeConverter<Duration, Long> {

    @Override
    public Long convertToDatabaseColumn(Duration duration) {
        return duration != null ? duration.toMinutes() : null;
    }

    @Override
    public Duration convertToEntityAttribute(Long minutes) {
        return minutes != null ? Duration.ofMinutes(minutes) : null;
    }

}
