package io.security.corespringsecurity.service.impl;

import io.security.corespringsecurity.domain.dto.AccountDTO;
import io.security.corespringsecurity.domain.entity.MemberAccount;
import io.security.corespringsecurity.domain.entity.Role;
import io.security.corespringsecurity.repository.RoleRepository;
import io.security.corespringsecurity.repository.UserRepository;
import io.security.corespringsecurity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void createUser(MemberAccount account) {

        Role role = roleRepository.findByRoleName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setUserRoles(roles);
        userRepository.save(account);

    }

    @Transactional
    @Override
    public void modifyUser(AccountDTO accountDTO) {

        ModelMapper modelMapper = new ModelMapper();
        MemberAccount account = modelMapper.map(accountDTO, MemberAccount.class);

        if(accountDTO.getRoles() != null){
            Set<Role> roles = new HashSet<>();
            accountDTO.getRoles().forEach(role -> {
                Role r = roleRepository.findByRoleName(role);
                roles.add(r);
            });
            account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
            userRepository.save(account);
        }

    }


    @Override
    public List<MemberAccount> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public AccountDTO getUser(Long id) {
        MemberAccount account = userRepository.findById(id).orElse(new MemberAccount());
        ModelMapper modelMapper = new ModelMapper();
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);

        List<String> roles = account.getUserRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toList());

        accountDTO.setRoles(roles);

        return accountDTO;
    }

    @Override
    public void deleteUser(Long idx) {
        userRepository.deleteById(idx);

    }
}
