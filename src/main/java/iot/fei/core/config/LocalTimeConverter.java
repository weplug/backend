package iot.fei.core.config;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

    @Override
    public Time convertToDatabaseColumn(LocalTime locDateTime) {
        return (locDateTime == null ? null : Time.valueOf(locDateTime));
    }

    @Override
    public LocalTime convertToEntityAttribute(Time sqlTimestamp) {
        return (sqlTimestamp == null ? null : sqlTimestamp.toLocalTime());
    }
}



