package iot.fei.core.service;

import iot.fei.core.domain.DeviceData;
import iot.fei.core.domain.GatheredData;

public interface DeviceService {

	DeviceData getOptionsDataForDevice(String id);

	void createGatheredData(GatheredData mapGatheredData, String id);
}
