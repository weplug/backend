package iot.fei.core.repository;

import org.springframework.data.repository.CrudRepository;

import iot.fei.core.domain.DataLogs;

public interface DataLogsRepository extends CrudRepository<DataLogs, Long> {

}
