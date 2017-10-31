package iot.fei.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import iot.fei.core.domain.DataLogs;
import iot.fei.core.repository.DataLogsRepository;

@Component
public class DataLogsServiceImpl implements DataLogsService {
	@Autowired
	DataLogsRepository dataLogsRepository;

	@Override
	public List<DataLogs> getAllDataLogs() {
		return (List<DataLogs>) dataLogsRepository.findAll();
	}

	@Override
	public DataLogs createDataLogs(DataLogs dataLogs) {
		return dataLogsRepository.save(dataLogs);
	}
}
