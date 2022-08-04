package com.edemirkirkan.homework3.sec.jwt;

import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import com.edemirkirkan.homework3.cus.service.entityservice.CusCustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final CusCustomerEntityService cusCustomerEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CusCustomer cusCustomer = cusCustomerEntityService.findByUsername(username);
        return SecUserDetails.build(cusCustomer);
    }
}

