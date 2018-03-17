package iot.fei.mapper;

import iot.fei.client.*;
import iot.fei.core.domain.*;

import java.util.List;

public interface DeviceMapper {

	CSDeviceData mapCSDeviceData(DeviceData deviceData);

	DeviceData mapDeviceData(CSDeviceData csDeviceData);

	CSGatheredData mapCSGatheredData(GatheredData deviceData);

	GatheredData mapGatheredData(CSGatheredData csDeviceData);

	CSPlug mapCSPlug(Plug setOptionsForPlug);

	Plug mapPlug(CSPlug csPlug);

    List<CSConsumption> mapAsCSConsumptionList(List<Consumption> consumptionBetweenDate);

	List<CSTemperature> mapAsCSTemperatureList(List<Temperature> temperatureForDevice);

    CSDeviceDataSimple mapCSDeviceDataSimple(DeviceData optionsDataForDevice);

	Timer mapTimer(CSTimer timers);

	CSTimer mapCSTimer(Timer timer);
}
