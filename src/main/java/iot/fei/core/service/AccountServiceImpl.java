package iot.fei.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import iot.fei.client.CSPlug;
import iot.fei.core.domain.Account;
import iot.fei.core.domain.DeviceData;
import iot.fei.core.domain.LogIn;
import iot.fei.core.domain.Plug;
import iot.fei.core.repository.AccountRepository;
import iot.fei.core.repository.DeviceDataRepository;

@Component
public class AccountServiceImpl implements AccountService {

	@Autowired
	DeviceDataRepository deviceDataRepository;

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account logIn(LogIn mapAsLogIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(Long id) {
		return accountRepository.findOne(id);
	}

	@Override
	public boolean deleteAccount(Long id) {
		accountRepository.delete(id);
		return true;
	}

	@Override
	public DeviceData getDeviceData(Long id, String deviceId) {
		return deviceDataRepository.findOne(deviceId);
	}

	@Override
	public Plug setOptionsForPlug(CSPlug plug) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getDeviceListForAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account registerDeviceToAccount(Long id, String deviceId) {
		Account account = accountRepository.findOne(id);
		DeviceData device = new DeviceData();
		device.setAccount(account);
		device.setId(deviceId);
		List<Plug> plugs = new ArrayList<Plug>();
		for (int i = 0; i < 3; i++) {
			Plug plug = new Plug();
			plug.setDevice(device);
			plugs.add(plug);
		}
		device.setPlugs(plugs);
		account.getDevices().add(device);
		// deviceDataRepository.save(device);
		return accountRepository.save(account);
	}
}
