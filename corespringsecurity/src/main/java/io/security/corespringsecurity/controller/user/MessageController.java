package io.security.corespringsecurity.controller.user;

import org.apache.tomcat.util.security.Escape;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @GetMapping("/messages")
    public String mypage() throws Exception {
        return "user/message";
    }
}
