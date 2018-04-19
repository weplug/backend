package iot.fei.core.service;

import java.time.LocalDateTime;
import java.util.List;

import iot.fei.client.CSDateBetween;
import iot.fei.core.domain.*;

public interface AccountService {

	Account createAccount(Account mapAsAccount);

	Account logIn(LogIn mapAsLogIn) throws Exception;

	Account getAccount(Long id);

	boolean deleteAccount(Long id);

	DeviceData getDeviceData(Long id, String deviceId);

	Plug setOptionsForPlug(Plug plug);

	List<String> getDeviceListForAccount(Long id);

	Account registerDeviceToAccount(Long id, String deviceId) throws Exception;

    Consumption getLast(String deviceId, Long id) throws Exception;

    List<Consumption> findConsumptionBetweenDate(String deviceId, Long plugId, LocalDateTime from, LocalDateTime to);

	List<Temperature> findTemperatureForDevice(String deviceId, Long accountId);

    DeviceData updateDeviceData(Long id, String deviceId,DeviceData deviceData) throws Exception;

	Account removeDeviceToAccount(Long id, String deviceId) throws Exception;

    List<Temperature> findTemperatureForDeviceBetween(CSDateBetween dateBetween, String deviceId, Long accountId);

	Timer setTimerForPlug(Timer timer, String deviceId, Long accountId,Long plugId) throws Exception;

	List<Timer> getTimersForPlug(String deviceId, Long accountId, Long plugId) throws Exception;

	boolean deleteTimerForPlug(Long id, String deviceId, Long accountId, Long plugId);
}
