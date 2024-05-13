package io.security.corespringsecurity.service;

import io.security.corespringsecurity.domain.MemberAccount;

public interface UserService {

    void createUser(MemberAccount account);
}
