package iot.fei.mapper;

import iot.fei.client.CSAccount;
import iot.fei.client.CSConsumption;
import iot.fei.client.CSLogIn;
import iot.fei.core.domain.Account;
import iot.fei.core.domain.Consumption;
import iot.fei.core.domain.LogIn;

public interface AccountMapper {

	Account mapAsAccount(CSAccount account);

	CSAccount mapAsCSAccount(Account createAccount);

	LogIn mapAsLogIn(CSLogIn logIn);

    CSConsumption mapAsCSConsumption(Consumption last);
}
