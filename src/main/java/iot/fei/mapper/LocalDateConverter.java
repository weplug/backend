package iot.fei.mapper;

import java.time.LocalDateTime;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class LocalDateConverter extends BidirectionalConverter<LocalDateTime, LocalDateTime> {

	@Override
	public LocalDateTime convertTo(LocalDateTime source, Type<LocalDateTime> destinationType) {
		return (LocalDateTime.from(source));
	}

	@Override
	public LocalDateTime convertFrom(LocalDateTime source, Type<LocalDateTime> destinationType) {
		return (LocalDateTime.from(source));
	}

}