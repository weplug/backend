package iot.fei.core.service;

import java.util.List;

import iot.fei.client.CSPlug;
import iot.fei.core.domain.Account;
import iot.fei.core.domain.DeviceData;
import iot.fei.core.domain.LogIn;
import iot.fei.core.domain.Plug;

public interface AccountService {

	Account createAccount(Account mapAsAccount);

	Account logIn(LogIn mapAsLogIn);

	Account getAccount(Long id);

	boolean deleteAccount(Long id);

	DeviceData getDeviceData(Long id, String deviceId);

	Plug setOptionsForPlug(CSPlug plug);

	List<String> getDeviceListForAccount(Long id);

	Account registerDeviceToAccount(Long id);
}
