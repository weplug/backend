package iot.fei.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import iot.fei.core.domain.Consumption;
import iot.fei.core.domain.DeviceData;
import iot.fei.core.domain.GatheredData;
import iot.fei.core.domain.Plug;
import iot.fei.core.domain.Temperature;
import iot.fei.core.repository.DeviceDataRepository;
import iot.fei.core.repository.PlugRepository;

import java.util.Comparator;
import java.util.List;

@Component
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	DeviceDataRepository deviceDataRepository;

	@Autowired
	PlugRepository plugRepository;

	@Override
	public DeviceData getOptionsDataForDevice(String id) {
		return deviceDataRepository.findOne(id);
	}

	@Override
	public void createGatheredData(GatheredData gatheredDatas, String id) throws Exception {
		DeviceData data = deviceDataRepository.findOne(id);
		Temperature temperature = new Temperature(gatheredDatas.getTemp());
		data.getTemps().add(temperature);
		temperature.setDevice(data);
		for(Plug plug: data.getPlugs()) {
			if(plug.getPlugOrder() < gatheredDatas.geteConsumption().size()) {
				Consumption consumption = new Consumption(gatheredDatas.geteConsumption().get(plug.getPlugOrder()));
				consumption.setPlug(plug);
				data.getPlugs().get(plug.getPlugOrder()).geteConsumption().add(consumption);
				data.getPlugs().get(plug.getPlugOrder()).setPlugStates(gatheredDatas.getPlugStates().get(plug.getPlugOrder()));
			} else {
				throw new Exception("Plug " + plug.getPlugOrder() + "dont have consumption or state");
			}
		}
		plugRepository.save(data.getPlugs());
	}
}
