package io.security.corespringsecurity.repository;

import io.security.corespringsecurity.domain.entity.MemberAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MemberAccount, Long> {
    MemberAccount findByUsername(String username);
    int countByUsername(String username);
}
