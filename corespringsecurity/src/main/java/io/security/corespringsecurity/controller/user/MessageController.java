package io.security.corespringsecurity.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {

    @GetMapping("/messages")
    public String mypage() throws Exception {
        return "user/message";
    }

    @GetMapping("/api/messages")
    @ResponseBody
    public String apiMessage(){
        return "messages ok! ";
    }
}
