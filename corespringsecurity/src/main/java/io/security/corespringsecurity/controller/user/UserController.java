package io.security.corespringsecurity.controller.user;

import io.security.corespringsecurity.domain.dto.AccountDTO;
import io.security.corespringsecurity.domain.entity.MemberAccount;
import io.security.corespringsecurity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/mypage")
    public String mypage() {
        return "user/mypage";
    }

    @GetMapping("/users")
    public String createUser(){
        return "user/login/register";
    }

    @PostMapping("/users")
    public String createUser(AccountDTO accountDTO){

        ModelMapper mapper = new ModelMapper();

        MemberAccount account = mapper.map(accountDTO, MemberAccount.class);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        userService.createUser(account);

        return "redirect:/";


    }
}
