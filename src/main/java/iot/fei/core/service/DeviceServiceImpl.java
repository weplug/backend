package iot.fei.core.service;

import iot.fei.core.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import iot.fei.core.repository.DeviceDataRepository;
import iot.fei.core.repository.PlugRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	DeviceDataRepository deviceDataRepository;

	@Autowired
	PlugRepository plugRepository;

	@Override
	public DeviceData getOptionsDataForDevice(String id) {
		DeviceData deviceData = deviceDataRepository.findOne(id);
		deviceData.getPlugs().stream().forEach(c -> removeOldTimers(c));
		return deviceData;
	}

	private List<Timer> removeOldTimers(Plug plug) {
		List<Timer> timers = new ArrayList<>();
		for (Timer timer : plug.getModes().getTimers()) {
			if(timer.getDate() == null || timer.getDate().isAfter(LocalDate.now().minusDays(1))) {
				timers.add(timer);
			}
		}
		return timers;
	}

	@Override
	public DeviceData createGatheredData(GatheredData gatheredDatas, String id) throws Exception {
		DeviceData data = deviceDataRepository.findOne(id);
		Temperature temperature = new Temperature(gatheredDatas.getTemp());
		data.getTemps().add(temperature);
		temperature.setDevice(data);
		for(Plug plug: data.getPlugs()) {
			removeOldTimers(plug);
			if (plug.getPlugOrder() < gatheredDatas.geteConsumption().size()) {
				Consumption consumption = new Consumption(gatheredDatas.geteConsumption().get(plug.getPlugOrder()));
				consumption.setPlug(plug);
				data.getPlugs().get(plug.getPlugOrder()).geteConsumption().add(consumption);
				if(!plug.getModes().getManual() && gatheredDatas.getPlugStates().get(plug.getPlugOrder()) != null)
					data.getPlugs().get(plug.getPlugOrder()).setPlugStates(gatheredDatas.getPlugStates().get(plug.getPlugOrder()));
			} else {
				throw new Exception("Plug " + plug.getPlugOrder() + "dont have consumption or state");
			}
		}
		plugRepository.save(data.getPlugs());
		if(gatheredDatas.getVersion() != data.getVersion())
			return  data;
		return null;
	}

	@Override
	public DeviceData createDeviceData(DeviceData deviceData) {
		List<Plug> plugs = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Plug plug = new Plug();
			plug.setPlugOrder(i);
			plug.setDevice(deviceData);
			plug.setModes(new Modes());
			plug.setPlugStates(PlugState.OFF);
			plugs.add(plug);
		}
		deviceData.setPlugs(plugs);
		return  deviceDataRepository.save(deviceData);
	}
}
