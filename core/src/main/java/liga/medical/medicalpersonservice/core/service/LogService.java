package liga.medical.medicalpersonservice.core.service;

import liga.medical.medicalpersonservice.core.mapping.LogMapper;
import liga.medical.medicalpersonservice.core.model.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogMapper logMapper;

    public void addLog(Log log) {
        logMapper.addLog(log);
    }
}
