package iot.fei.core.service;

import org.springframework.stereotype.Component;

import iot.fei.client.CSPlug;
import iot.fei.core.domain.Account;
import iot.fei.core.domain.DeviceData;
import iot.fei.core.domain.LogIn;
import iot.fei.core.domain.Plug;

@Component
public class AccountServiceImpl implements AccountService {

	@Override
	public Account createAccount(Account mapAsAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account logIn(LogIn mapAsLogIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAccount(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DeviceData getDeviceData(Long id, String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plug setOptionsForPlug(CSPlug plug) {
		// TODO Auto-generated method stub
		return null;
	}
}
