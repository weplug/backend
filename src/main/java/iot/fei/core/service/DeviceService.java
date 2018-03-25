package iot.fei.core.service;

import iot.fei.core.domain.DeviceData;
import iot.fei.core.domain.GatheredData;

public interface DeviceService {

	DeviceData getOptionsDataForDevice(String id);

	DeviceData createGatheredData(GatheredData mapGatheredData, String id) throws Exception;

    DeviceData createDeviceData(DeviceData deviceData);
}
