package com.digitekno.digimedic.repository;

import com.digitekno.digimedic.model.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, String> {
    List<TransactionLog> findByClientIdAndCreatedAtBetween(String clientId, LocalDateTime start, LocalDateTime end);
    List<TransactionLog> findByServiceTypeAndStatus(String serviceType, String status);
}