package iot.fei.core.service;

import java.time.LocalDateTime;
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
		Account account = accountRepository.findOne(id);
		for(DeviceData deviceData : account.getDevices()){
			deviceData.setAccount(null);
			deviceDataRepository.save(deviceData);
		}
		accountRepository.delete(id);
		return true;
	}

	@Override
	public DeviceData getDeviceData(Long id, String deviceId) {
		return deviceDataRepository.findOne(deviceId);
	}

	@Override
	public DeviceData updateDeviceData(Long id, String deviceId, DeviceData deviceData) throws Exception {
		DeviceData deviceDataLoaded = deviceDataRepository.findOne(deviceId);
		if(deviceData == null) {
			throw new Exception("device not found");
		}
		deviceDataLoaded.setName(deviceData.getName());
		deviceDataLoaded.setNote(deviceData.getNote());
		return deviceDataRepository.save(deviceDataLoaded);
	}

	@Override
	public Account removeDeviceToAccount(Long id, String deviceId) throws Exception {
		DeviceData device = deviceDataRepository.findOne(deviceId);
		if(device.getAccount().getId() == id) {
			device.setAccount(null);
			deviceDataRepository.save(device);
		}
		else
			throw new Exception("you are trying delete device from different account");
		Account account = accountRepository.findOne(id);
		if (account == null) {
			throw new Exception("account not found");
		}
		return account;
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
	public Account registerDeviceToAccount(Long id, String deviceId) throws Exception {
		Account account = accountRepository.findOne(id);
		if (account == null) {
			throw new Exception("account not found");
		}
		DeviceData device = deviceDataRepository.findOne(deviceId);
		if(device == null) {
			throw new Exception("device not found");
		}
		device.setAccount(account);
//		account.getDevices().add(device);
		deviceDataRepository.save(device);
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

    @Override
    public List<Consumption> findConsumptionBetweenDate(String deviceId, Long plugId, LocalDateTime from, LocalDateTime to) {
        return consumptionRepository.findByPlugIdAndDateBetween(plugId, from, to);
    }

	@Override
	public List<Temperature> findTemperatureForDevice(String deviceId, Long accountId) {
		DeviceData deviceData = deviceDataRepository.findOne(deviceId);
		return deviceData.getTemps();
	}
}
