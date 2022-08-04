package com.edemirkirkan.homework3.sec.auth.service;

import com.edemirkirkan.homework3.cus.dto.CusCustomerDto;
import com.edemirkirkan.homework3.cus.dto.CusCustomerSaveRequestDto;
import com.edemirkirkan.homework3.cus.service.CusCustomerService;
import com.edemirkirkan.homework3.sec.auth.dto.AuthenticationLoginRequestDto;
import com.edemirkirkan.homework3.sec.auth.enums.AuthenticationConstant;
import com.edemirkirkan.homework3.sec.jwt.SecTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final CusCustomerService cusCustomerService;
    private final SecTokenGenerator secTokenGenerator;

    public CusCustomerDto register(CusCustomerSaveRequestDto cusCustomerSaveRequestDto) {
        return cusCustomerService.save(cusCustomerSaveRequestDto);
    }

    public String login(AuthenticationLoginRequestDto authenticationLoginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationLoginRequestDto.getUsername(), authenticationLoginRequestDto.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = secTokenGenerator.generateJwtToken(authentication);

        String fullToken = AuthenticationConstant.BEARER.getConstant() + token;

        return fullToken;
    }

}
