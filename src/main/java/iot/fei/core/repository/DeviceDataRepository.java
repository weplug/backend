package iot.fei.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import iot.fei.core.domain.DeviceData;

public interface DeviceDataRepository extends CrudRepository<DeviceData, String> {

	@Query("SELECT id FROM DeviceData dt WHERE dt.account.id = :id")
	List<String> findIdByAccountId(@Param("id") Long id);
}
