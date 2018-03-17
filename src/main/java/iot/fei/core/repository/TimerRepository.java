package iot.fei.core.repository;

import iot.fei.core.domain.Temperature;
import iot.fei.core.domain.Timer;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TimerRepository extends CrudRepository<Timer, Long> {
}
