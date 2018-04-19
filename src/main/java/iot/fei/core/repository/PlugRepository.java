package iot.fei.core.repository;

import iot.fei.core.domain.Consumption;
import iot.fei.core.domain.Temperature;
import iot.fei.core.domain.Timer;
import org.springframework.data.repository.CrudRepository;

import iot.fei.core.domain.Plug;

import java.util.List;

public interface PlugRepository extends CrudRepository<Plug, Long> {
}
