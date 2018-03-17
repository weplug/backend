package iot.fei.core.repository;

import iot.fei.core.domain.Consumption;
import iot.fei.core.domain.Temperature;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TemperatureRepository extends CrudRepository<Temperature, Long> {
    List<Temperature> findByDeviceIdAndTimeBetween(String id, LocalDateTime from, LocalDateTime to);
}
