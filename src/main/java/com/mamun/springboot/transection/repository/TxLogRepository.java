package com.mamun.springboot.transection.repository;

import com.mamun.springboot.transection.entity.TxLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxLogRepository extends JpaRepository<TxLog,Long> {
}
