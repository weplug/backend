package iot.fei.core.repository;

import iot.fei.core.domain.Consumption;
import iot.fei.core.domain.Plug;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ConsumptionRepository extends CrudRepository<Consumption, Long> {
    List<Consumption> findByPlugIdAndDateBetween(Long id, Date from, Date to);

    Consumption findFirstByPlugIdOrderByDateDesc(Long id);
}
