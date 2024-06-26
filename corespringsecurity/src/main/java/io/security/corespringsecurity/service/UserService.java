package io.security.corespringsecurity.service;

import io.security.corespringsecurity.domain.dto.AccountDTO;
import io.security.corespringsecurity.domain.entity.MemberAccount;

import java.util.List;

public interface UserService {

    void createUser(MemberAccount account);

    void modifyUser(AccountDTO accountDTO);

    List<MemberAccount> getUsers();

    AccountDTO getUser(Long id);

    void deleteUser(Long idx);


}
