package iot.fei.mapper;

import iot.fei.client.CSDeviceData;
import iot.fei.client.CSGatheredData;
import iot.fei.client.CSPlug;
import iot.fei.core.domain.DeviceData;
import iot.fei.core.domain.GatheredData;
import iot.fei.core.domain.Plug;

public interface DeviceMapper {

	CSDeviceData mapCSDeviceData(DeviceData deviceData);

	DeviceData mapDeviceData(CSDeviceData csDeviceData);

	CSGatheredData mapCSGatheredData(GatheredData deviceData);

	GatheredData mapGatheredData(CSGatheredData csDeviceData);

	CSPlug mapCSPlug(Plug setOptionsForPlug);

	Plug mapPlug(CSPlug csPlug);

}
