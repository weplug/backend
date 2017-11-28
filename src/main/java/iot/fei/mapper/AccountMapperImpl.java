package iot.fei.mapper;

import org.springframework.stereotype.Component;

import iot.fei.client.CSAccount;
import iot.fei.client.CSLogIn;
import iot.fei.client.CSPlug;
import iot.fei.core.domain.Account;
import iot.fei.core.domain.LogIn;
import iot.fei.core.domain.Plug;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class AccountMapperImpl implements AccountMapper {
	private final static MapperFacade mapper;

	static {
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(CSAccount.class, Account.class) //
				.byDefault() //
				.register();

		mapperFactory.classMap(CSPlug.class, Plug.class) //
				.byDefault() //
				.register();

		mapper = mapperFactory.getMapperFacade();
	}

	@Override
	public Account mapAsAccount(CSAccount account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CSAccount mapAsCSAccount(Account createAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogIn mapAsLogIn(CSLogIn logIn) {
		// TODO Auto-generated method stub
		return null;
	}
}
