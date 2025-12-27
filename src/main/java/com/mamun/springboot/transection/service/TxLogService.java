package com.mamun.springboot.transection.service;

import com.mamun.springboot.transection.entity.TxLog;
import com.mamun.springboot.transection.repository.TxLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxLogService {
    @Autowired
    private TxLogRepository txLogRepository;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog(TxLog txLog) {
        txLogRepository.save(txLog);
    }
}
