package com.mycompany.springmvchibernate.Config;


import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author MinhTo
 */
@Component // hỗ trợ dependency Injection
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    private RedirectStrategy redirectStragy=new DefaultRedirectStrategy();

    public RedirectStrategy getRedirectStragy() {
        return redirectStragy;
    }
   }
   
