package dev.sternschnuppe.thirdbasic.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {
    public String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
