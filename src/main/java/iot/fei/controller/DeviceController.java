package iot.fei.controller;

import iot.fei.client.CSDeviceDataSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import iot.fei.client.CSDeviceData;
import iot.fei.client.CSGatheredData;
import iot.fei.controller.configuration.PathConfiguration;
import iot.fei.core.service.DeviceService;
import iot.fei.mapper.DeviceMapper;

@CrossOrigin
@Controller
@RequestMapping("/devices")
public class DeviceController {
	@Autowired
	DeviceService deviceService;

	@Autowired
	DeviceMapper deviceMapper;

	@RequestMapping(value = PathConfiguration.DEVICE_ID, method = RequestMethod.POST)
	public @ResponseBody void createGatheredData(@PathVariable("device-id") String id, @RequestBody CSGatheredData gData) throws Exception {
		deviceService.createGatheredData(deviceMapper.mapGatheredData(gData), id);
	}

	@RequestMapping(value = PathConfiguration.DEVICE_ID, method = RequestMethod.GET)
	public @ResponseBody CSDeviceDataSimple getDeviceData(@PathVariable("device-id") String id) {
		return deviceMapper.mapCSDeviceDataSimple(deviceService.getOptionsDataForDevice(id));
	}

}
