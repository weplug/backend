package iot.fei.mapper;

import iot.fei.client.CSConsumption;
import iot.fei.core.domain.Consumption;
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

		mapperFactory.classMap(CSLogIn.class, LogIn.class) //
				.byDefault() //
				.register();

		// TODO nevyriesene mapovanie casu
		mapperFactory.getConverterFactory().registerConverter(new LocalDateConverter());

		mapper = mapperFactory.getMapperFacade();
	}

	@Override
	public Account mapAsAccount(CSAccount account) {
		return mapper.map(account, Account.class);
	}

	@Override
	public CSAccount mapAsCSAccount(Account createAccount) {
		return mapper.map(createAccount, CSAccount.class);
	}

	@Override
	public LogIn mapAsLogIn(CSLogIn logIn) {
		return mapper.map(logIn, LogIn.class);
	}

	@Override
	public CSConsumption mapAsCSConsumption(Consumption last) {
		return mapper.map(last, CSConsumption.class);
	}
}
