package iot.fei.core.service;

import java.util.List;

import iot.fei.core.domain.DataLogs;

public interface DataLogsService {

	DataLogs createDataLogs(DataLogs dataLogs);

	List<DataLogs> getAllDataLogs();

}
