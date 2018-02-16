package iot.fei.core.service;

import java.util.ArrayList;
import java.util.List;

import iot.fei.core.domain.*;
import iot.fei.core.repository.ConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import iot.fei.core.repository.AccountRepository;
import iot.fei.core.repository.DeviceDataRepository;
import iot.fei.core.repository.PlugRepository;

@Component
public class AccountServiceImpl implements AccountService {

	@Autowired
	DeviceDataRepository deviceDataRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	PlugRepository plugRepository;

	@Autowired
    ConsumptionRepository consumptionRepository;

	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account logIn(LogIn logIn) throws Exception {
		Account account = accountRepository.findByEmailAndPassword(logIn.getEmail(), logIn.getPassword());
		if (account == null) {
			throw new Exception("account not found");
		}
		return account;
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
	public Plug setOptionsForPlug(Plug plug) {
		Plug oldPlug = plugRepository.findOne(plug.getId());
		plug.setDevice(oldPlug.getDevice());
		return plugRepository.save(plug);
	}

	@Override
	public List<String> getDeviceListForAccount(Long id) {
		List<String> var = deviceDataRepository.findIdByAccountId(id);
		return var;
	}

	@Override
	public Account registerDeviceToAccount(Long id, String deviceId) {
		Account account = accountRepository.findOne(id);
		DeviceData device = new DeviceData();
		device.setAccount(account);
		device.setId(deviceId);
		List<Plug> plugs = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Plug plug = new Plug();
			plug.setDevice(device);
			plug.setModes(new Modes());
			plugs.add(plug);
		}
		device.setPlugs(plugs);
		account.getDevices().add(device);
		// deviceDataRepository.save(device);
		return accountRepository.save(account);
	}

	@Override
	public Consumption getLast(String deviceId, Long id) throws Exception {
        List<Plug> plugList = deviceDataRepository.findOne(deviceId).getPlugs();
        Plug plug = plugList.stream().filter(e -> e.getId() == id).findFirst().get();
        if(plug != null) {
            return consumptionRepository.findFirstByPlugIdOrderByDateDesc(plug.getId());
        } else {
            throw new Exception("Plug ID is not in Device");
        }
	}
}
