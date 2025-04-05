package com.digitekno.digimedic.repository;

import com.digitekno.digimedic.model.ClientRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientRegistrationRepository extends JpaRepository<ClientRegistration, String> {
    Optional<ClientRegistration> findByClientId(String clientId);
    Optional<ClientRegistration> findByEmail(String email);
    boolean existsByClientId(String clientId);
    boolean existsByEmail(String email);
}