package io.security.corespringsecurity.security.handler;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
                                                                                                                    throws IOException, ServletException {

        // 로그인 인증 실패시 코드

        String errorMsg = "Invalid Username or Password";

        if (exception instanceof InsufficientAuthenticationException){
            errorMsg = "invalid secrete Key";
        }

        setDefaultFailureUrl("/login?error=true&exception=" + exception.getMessage());

        super.onAuthenticationFailure(request, response, exception);
    }
}
