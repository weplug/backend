package iot.fei.core.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import iot.fei.client.CSDateBetween;
import iot.fei.core.domain.*;
import iot.fei.core.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	@Autowired
	TemperatureRepository temperatureRepository;

	@Autowired
	TimerRepository timerRepository;

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
	public List<Temperature> findTemperatureForDeviceBetween(CSDateBetween dateBetween, String deviceId, Long accountId) {
		return temperatureRepository.findByDeviceIdAndTimeBetween(deviceId, dateBetween.getFrom(), dateBetween.getTo());
	}

	@Override
	public Timer setTimerForPlug(Timer timer, String deviceId, Long accountId, Long plugId) throws Exception {
		Plug plug = plugRepository.findOne(plugId);
		setVersion(plug);
		if(plug == null) {
			throw new Exception("plug not found");
		}
		timer.setModes(plug.getModes());
		return timerRepository.save(timer);
	}

    @Override
    public boolean deleteTimerForPlug(Long id, String deviceId, Long accountId, Long plugId) {
        timerRepository.delete(id);
        return true;
    }

    @Override
	public Plug setOptionsForPlug(Plug plug) {
		Plug oldPlug = plugRepository.findOne(plug.getId());
		setVersion(oldPlug);
		plug.setDevice(oldPlug.getDevice());
		plug.getModes().setTimers(oldPlug.getModes().getTimers());
		plug.setPlugOrder(oldPlug.getPlugOrder());
		return plugRepository.save(plug);
	}

	private void setVersion(Plug plug) {
		DeviceData deviceData = deviceDataRepository.findOne(plug.getDevice().getId());
		if(deviceData.getVersion() == null)
			deviceData.setVersion(0);
		deviceData.setVersion(deviceData.getVersion()+1);
	}

	@Override
	public List<String> getDeviceListForAccount(Long id) {
		return deviceDataRepository.findIdByAccountId(id);
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
		for(Plug plug : plugList)
			if(plug.getId() == id)
            	return consumptionRepository.findFirstByPlugIdOrderByDateDesc(plug.getId());
		throw new Exception("Plug ID is not in Device");
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
