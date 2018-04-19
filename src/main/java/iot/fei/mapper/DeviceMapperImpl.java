package iot.fei.mapper;

import iot.fei.client.*;
import iot.fei.core.domain.*;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class DeviceMapperImpl implements DeviceMapper {
	private final static MapperFacade mapper;

	static {
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalTime.class));
		mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDateTime.class));
		mapperFactory.classMap(DeviceData.class, CSDeviceData.class) //
				.byDefault() //
				.register();

		mapperFactory.classMap(GatheredData.class, CSGatheredData.class) //
				.byDefault() //
				.register();
		
		mapperFactory.classMap(Plug.class, CSPlug.class) //
				.byDefault() //
				.register();

		mapperFactory.classMap(Timer.class, CSTimer.class) //
				.byDefault() //
				.register();

		mapper = mapperFactory.getMapperFacade();
	}

	@Override
	public DeviceData mapDeviceData(CSDeviceData csDeviceData) {
		return mapper.map(csDeviceData, DeviceData.class);
	}

	@Override
	public CSDeviceData mapCSDeviceData(DeviceData deviceData) {
		return mapper.map(deviceData, CSDeviceData.class);
	}

	@Override
	public GatheredData mapGatheredData(CSGatheredData csDeviceData) {
		return mapper.map(csDeviceData, GatheredData.class);
	}

	@Override
	public CSGatheredData mapCSGatheredData(GatheredData deviceData) {
		return mapper.map(deviceData, CSGatheredData.class);
	}

	@Override
	public CSPlug mapCSPlug(Plug plug) {
		return mapper.map(plug, CSPlug.class);
	}
	
	@Override
	public Plug mapPlug(CSPlug csPlug) {
		return mapper.map(csPlug, Plug.class);
	}

	@Override
	public List<CSConsumption> mapAsCSConsumptionList(List<Consumption> consumptionBetweenDate) {
		return mapper.mapAsList(consumptionBetweenDate, CSConsumption.class);
	}

	@Override
	public List<CSTemperature> mapAsCSTemperatureList(List<Temperature> temperatureForDevice) {
		return mapper.mapAsList(temperatureForDevice, CSTemperature.class);
	}

	@Override
	public CSDeviceDataSimple mapCSDeviceDataSimple(DeviceData optionsDataForDevice) {
		return mapper.map(optionsDataForDevice, CSDeviceDataSimple.class);
	}

	@Override
	public Timer mapTimer(CSTimer timer) {
		return mapper.map(timer, Timer.class);
	}

	@Override
	public CSTimer mapCSTimer(Timer timer) {
		return mapper.map(timer, CSTimer.class);
	}

	@Override
	public List<CSTimer> mapAsCSTimersList(List<Timer> timers) {
		return mapper.mapAsList(timers, CSTimer.class);
	}
}
