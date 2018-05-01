package iot.fei.controller;

import java.util.List;

import iot.fei.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import iot.fei.controller.configuration.PathConfiguration;
import iot.fei.core.service.AccountService;
import iot.fei.mapper.AccountMapper;
import iot.fei.mapper.DeviceMapper;

	@CrossOrigin
@Controller
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	AccountService accountService;

	@Autowired
	DeviceMapper deviceMapper;

	@Autowired
	AccountMapper accountMapper;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CSAccount createAccount(@RequestBody CSAccount account) {
		return accountMapper.mapAsCSAccount(accountService.createAccount(accountMapper.mapAsAccount(account)));
	}

	@RequestMapping(value = "/log-in", method = RequestMethod.POST)
	public @ResponseBody CSAccount accountLogIn(@RequestBody CSLogIn logIn) throws Exception {
		return accountMapper.mapAsCSAccount(accountService.logIn(accountMapper.mapAsLogIn(logIn)));
	}

	@RequestMapping(value = PathConfiguration.ID, method = RequestMethod.GET)
	public @ResponseBody CSAccount getAccount(@PathVariable("id") Long id) {
		return accountMapper.mapAsCSAccount(accountService.getAccount(id));
	}

	@RequestMapping(value = PathConfiguration.ID, method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteAccount(@PathVariable("id") Long id) {
		return accountService.deleteAccount(id);
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID, method = RequestMethod.GET)
	public @ResponseBody CSDeviceData getDeviceInfo(@PathVariable("id") Long id, @PathVariable("device-id") String deviceId) {
		return deviceMapper.mapCSDeviceData(accountService.getDeviceData(id, deviceId));
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID + PathConfiguration.INFO, method = RequestMethod.PUT)
	public @ResponseBody CSDeviceData updateDeviceInfo(@PathVariable("id") Long id, @PathVariable("device-id") String deviceId, @RequestBody CSDeviceData deviceData) throws Exception {
		return deviceMapper.mapCSDeviceData(accountService.updateDeviceData(id, deviceId, deviceMapper.mapDeviceData(deviceData)));
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID, method = RequestMethod.PUT)
	public @ResponseBody CSPlug setOptionsForPlug(@PathVariable("id") Long id, @PathVariable("device-id") String deviceId, @RequestBody CSPlug plug) {
		return deviceMapper.mapCSPlug(accountService.setOptionsForPlug(deviceMapper.mapPlug(plug)));
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID + PathConfiguration.PLUG + PathConfiguration.PLUG_ID + PathConfiguration.TIMER, method = RequestMethod.POST)
	public @ResponseBody CSTimer setTimerForPlug(@PathVariable("id") Long accountId, @PathVariable("device-id") String deviceId, @PathVariable("plug-id") Long plugId, @RequestBody CSTimer timer) throws Exception {
		return deviceMapper.mapCSTimer(accountService.setTimerForPlug(deviceMapper.mapTimer(timer), deviceId, accountId, plugId));
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID + PathConfiguration.PLUG + PathConfiguration.PLUG_ID + PathConfiguration.TIMER, method = RequestMethod.GET)
	public @ResponseBody List<CSTimer> getTimersForPlug(@PathVariable("id") Long accountId, @PathVariable("device-id") String deviceId, @PathVariable("plug-id") Long plugId) throws Exception {
		return deviceMapper.mapAsCSTimersList(accountService.getTimersForPlug(deviceId, accountId, plugId));
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID + PathConfiguration.PLUG + PathConfiguration.PLUG_ID + PathConfiguration.TIMER, method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteTimerForPlug(@PathVariable("id") Long accountId, @PathVariable("device-id") String deviceId, @PathVariable("plug-id") Long plugId, @RequestBody CSTimer timer) throws Exception {
		return accountService.deleteTimerForPlug(timer.getId(), deviceId, accountId, plugId);
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES, method = RequestMethod.GET)
	public @ResponseBody List<String> getAccountDeviceList(@PathVariable("id") Long id) {
		return accountService.getDeviceListForAccount(id);
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID + PathConfiguration.REGISTER, method = RequestMethod.POST)
	public @ResponseBody CSAccount registerDeviceForAccount(@PathVariable("id") Long id, @PathVariable("device-id") String deviceId) throws Exception {
		return accountMapper.mapAsCSAccount(accountService.registerDeviceToAccount(id, deviceId));
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID, method = RequestMethod.DELETE)
	public @ResponseBody CSAccount removeDeviceForAccount(@PathVariable("id") Long id, @PathVariable("device-id") String deviceId) throws Exception {
		return accountMapper.mapAsCSAccount(accountService.removeDeviceToAccount(id, deviceId));
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID + PathConfiguration.PLUG + PathConfiguration.PLUG_ID + PathConfiguration.LAST, method = RequestMethod.GET)
	public @ResponseBody CSConsumption getLastConsumptionForPlug(@PathVariable("device-id") String deviceId, @PathVariable("plug-id") Long plugId, @PathVariable("id") Long id) throws Exception {
		return accountMapper.mapAsCSConsumption(accountService.getLast(deviceId, plugId));
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID + PathConfiguration.PLUG + PathConfiguration.PLUG_ID + PathConfiguration.BETWEEN, method = RequestMethod.POST)
	public @ResponseBody List<CSConsumption> getConsumptionForPlugBetween(@RequestBody CSDateBetween dateBetween ,@PathVariable("device-id") String deviceId, @PathVariable("plug-id") Long plugId, @PathVariable("id") Long id) {
		return deviceMapper.mapAsCSConsumptionList(accountService.findConsumptionBetweenDate(deviceId, plugId, dateBetween.getFrom(), dateBetween.getTo()));
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID + PathConfiguration.TEMPERATURE, method = RequestMethod.GET)
	public @ResponseBody List<CSTemperature> getTemperatureForDevice(@PathVariable("device-id") String deviceId, @PathVariable("id") Long accountId) {
		return deviceMapper.mapAsCSTemperatureList(accountService.findTemperatureForDevice(deviceId, accountId));
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID + PathConfiguration.TEMPERATURE + PathConfiguration.BETWEEN, method = RequestMethod.POST)
	public @ResponseBody List<CSTemperature> getTemperatureForDeviceBetween(@RequestBody CSDateBetween dateBetween, @PathVariable("device-id") String deviceId, @PathVariable("id") Long accountId) {
		return deviceMapper.mapAsCSTemperatureList(accountService.findTemperatureForDeviceBetween(dateBetween, deviceId, accountId));
	}
}
