package io.security.corespringsecurity.service.impl;

import io.security.corespringsecurity.domain.MemberAccount;
import io.security.corespringsecurity.repository.MemberAccountRepository;
import io.security.corespringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private MemberAccountRepository memberAccountRepository;

    @Transactional
    @Override
    public void createUser(MemberAccount account) {

        memberAccountRepository.save(account);

    }
}
