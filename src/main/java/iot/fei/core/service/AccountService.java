package iot.fei.core.service;

import java.util.List;

import iot.fei.core.domain.*;

public interface AccountService {

	Account createAccount(Account mapAsAccount);

	Account logIn(LogIn mapAsLogIn) throws Exception;

	Account getAccount(Long id);

	boolean deleteAccount(Long id);

	DeviceData getDeviceData(Long id, String deviceId);

	Plug setOptionsForPlug(Plug plug);

	List<String> getDeviceListForAccount(Long id);

	Account registerDeviceToAccount(Long id, String deviceId);

    Consumption getLast(String deviceId, Long id) throws Exception;
}
