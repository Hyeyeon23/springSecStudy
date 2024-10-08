package io.security.corespringsecurity.security.service;

import io.security.corespringsecurity.domain.entity.MemberAccount;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


@Getter
@Setter
public class AccountContext extends User {

    private MemberAccount account;

    public AccountContext(MemberAccount account, Collection<? extends GrantedAuthority> authorities) {
        super(account.getUsername(), account.getPassword(), authorities);
        this.account = account;
    }


}
