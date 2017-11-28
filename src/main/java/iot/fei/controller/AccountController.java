package iot.fei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import iot.fei.client.CSAccount;
import iot.fei.client.CSDeviceData;
import iot.fei.client.CSLogIn;
import iot.fei.client.CSPlug;
import iot.fei.core.service.AccountService;
import iot.fei.mapper.AccountMapper;
import iot.fei.mapper.DeviceMapper;

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
	public @ResponseBody CSAccount accountLogIn(@RequestBody CSLogIn logIn) {
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

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID, method = RequestMethod.POST)
	public @ResponseBody CSDeviceData setOptionsForPlug(@PathVariable("id") Long id, @PathVariable("device-id") String deviceId, @RequestBody CSPlug plug) {
		return deviceMapper.mapCSPlug(accountService.setOptionsForPlug(plug));
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES, method = RequestMethod.GET)
	public @ResponseBody CSDeviceData getAccountDeviceData(@PathVariable("id") Long id) {
		return null;
	}

	@RequestMapping(value = PathConfiguration.ID + PathConfiguration.DEVICES + PathConfiguration.DEVICE_ID, method = RequestMethod.POST)
	public @ResponseBody CSDeviceData registerDeviceForAccount(@PathVariable("id") Long id, @PathVariable("device-id") String deviceId) {
		return null;
	}
}
