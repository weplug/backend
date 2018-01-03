package iot.fei.mapper;

import org.springframework.stereotype.Component;

import iot.fei.client.CSDeviceData;
import iot.fei.client.CSGatheredData;
import iot.fei.client.CSPlug;
import iot.fei.core.domain.DeviceData;
import iot.fei.core.domain.GatheredData;
import iot.fei.core.domain.Plug;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class DeviceMapperImpl implements DeviceMapper {
	private final static MapperFacade mapper;

	static {
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(DeviceData.class, CSDeviceData.class) //
				.byDefault() //
				.register();

		mapperFactory.classMap(GatheredData.class, CSGatheredData.class) //
				.byDefault() //
				.register();
		
		mapperFactory.classMap(Plug.class, CSPlug.class) //
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
}
