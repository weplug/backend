package iot.fei.core.repository;

import org.springframework.data.repository.CrudRepository;

import iot.fei.core.domain.DeviceData;

public interface DeviceDataRepository extends CrudRepository<DeviceData, String> {

}
