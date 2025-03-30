package com.digitekno.digimedic.repository;

import com.digitekno.digimedic.model.ResponseCache;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ResponseCacheRepository extends JpaRepository<ResponseCache, String> {
    Optional<ResponseCache> findByCacheKeyAndServiceType(String cacheKey, String serviceType);
    void deleteByCacheKeyAndServiceType(String cacheKey, String serviceType);
}