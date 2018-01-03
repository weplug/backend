package iot.fei.core.repository;

import org.springframework.data.repository.CrudRepository;

import iot.fei.core.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	Account findByEmailAndPassword(String email, String password);

}
