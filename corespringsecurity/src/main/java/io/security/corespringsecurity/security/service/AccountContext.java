package io.security.corespringsecurity.security.service;

import io.security.corespringsecurity.domain.MemberAccount;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class AccountContext extends User {
    public AccountContext(MemberAccount account, Collection<? extends GrantedAuthority> authorities) {
        super(account.getUsername(), account.getPassword(), authorities);
    }

}
