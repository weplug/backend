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
	public void createGatheredData(GatheredData gatheredDatas, String id) {
		DeviceData data = deviceDataRepository.findOne(id);
		Temperature temperature = new Temperature(gatheredDatas.getTemp());
		data.getTemps().add(temperature);
		temperature.setDevice(data);
		for (int i = 0; i < gatheredDatas.geteConsumption().size(); i++) {
			if (data.getPlugs().size() <= i) {
				Plug plug = new Plug();
				plug.setDevice(data);
				data.getPlugs().add(i, plug);
			}
			Consumption consumption = new Consumption(gatheredDatas.geteConsumption().get(i));
			consumption.setPlug(data.getPlugs().get(i));
			data.getPlugs().get(i).geteConsumption().add(consumption);
			data.getPlugs().get(i).setPlugStates(gatheredDatas.getPlugStates().get(i));
		}

		plugRepository.save(data.getPlugs());
	}
}
