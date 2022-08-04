package com.edemirkirkan.homework3.sec.auth.controller;

import com.edemirkirkan.homework3.cus.dto.CusCustomerDto;
import com.edemirkirkan.homework3.cus.dto.CusCustomerSaveRequestDto;
import com.edemirkirkan.homework3.cus.dto.CusCustomerUpdateRequestDto;
import com.edemirkirkan.homework3.gen.response.RestResponse;
import com.edemirkirkan.homework3.sec.auth.dto.AuthenticationLoginRequestDto;
import com.edemirkirkan.homework3.sec.auth.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(tags = "Authentication Controller", description = "Register to an API")
    @PostMapping("/register")
    public ResponseEntity<RestResponse<CusCustomerDto>> register(@Valid @RequestBody CusCustomerSaveRequestDto cusCustomerSaveRequestDto){

        CusCustomerDto cusCustomerDto = authenticationService.register(cusCustomerSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(cusCustomerDto));
    }

    @Operation(tags = "Authentication Controller", description = "Login to get access token")
    @PostMapping("/login")
    public ResponseEntity<RestResponse<String>> login(@RequestBody AuthenticationLoginRequestDto loginRequestDto){

        String login = authenticationService.login(loginRequestDto);

        return ResponseEntity.ok(RestResponse.of(login));
    }
}