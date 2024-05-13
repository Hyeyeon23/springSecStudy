package io.security.corespringsecurity.repository;

import io.security.corespringsecurity.domain.MemberAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long> {

    MemberAccount findByUsername(String username);
}
