package com.edemirkirkan.homework3.cus.service;

import com.edemirkirkan.homework3.cus.dto.CusCustomerDto;
import com.edemirkirkan.homework3.cus.dto.CusCustomerSaveRequestDto;
import com.edemirkirkan.homework3.cus.dto.CusCustomerUpdateRequestDto;
import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import com.edemirkirkan.homework3.cus.enums.CusErrorMessage;
import com.edemirkirkan.homework3.cus.converter.CusCustomerMapper;
import com.edemirkirkan.homework3.cus.service.entityservice.CusCustomerEntityService;
import com.edemirkirkan.homework3.gen.enums.ErrorMessage;
import com.edemirkirkan.homework3.gen.exceptions.BusinessException;
import com.edemirkirkan.homework3.sec.jwt.SecUserDetails;
import com.edemirkirkan.homework3.sec.jwt.SecUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CusCustomerService {

    private final CusCustomerEntityService cusCustomerEntityService;
    private final PasswordEncoder passwordEncoder;
    private final SecUserDetailsService secUserDetailsService;
    private final CusCustomerMapper cusCustomerMapper;


    public CusCustomerDto save(CusCustomerSaveRequestDto cusCustomerSaveRequestDto) {

        if (cusCustomerSaveRequestDto == null){
            throw new BusinessException(ErrorMessage.PARAMETER_CANNOT_BE_NULL);
        }

        CusCustomer cusCustomer = cusCustomerMapper.convertToCusCustomer(cusCustomerSaveRequestDto);

        String password = passwordEncoder.encode(cusCustomer.getPassword());
        cusCustomer.setPassword(password);
        try {
            cusCustomer = cusCustomerEntityService.save(cusCustomer);
        } catch (DataIntegrityViolationException ex) {
                throw new BusinessException(CusErrorMessage.DUPLICATE_USERNAME);
        }


        CusCustomerDto cusCustomerDto = cusCustomerMapper.convertToCusCustomerDto(cusCustomer);

        return cusCustomerDto;
    }

    public void delete(Long id) {

        CusCustomer cusCustomer = cusCustomerEntityService.findByIdWithControl(id);

        cusCustomerEntityService.delete(cusCustomer);
    }

    public CusCustomerDto changePassword(CusCustomerUpdateRequestDto cusCustomerUpdateRequestDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecUserDetails userDetails = (SecUserDetails) secUserDetailsService.loadUserByUsername(((SecUserDetails) authentication.getPrincipal()).getUsername());

        if (!Objects.equals(cusCustomerUpdateRequestDto.getNewPassword(), cusCustomerUpdateRequestDto.getNewPasswordAgain())) {
            throw new BusinessException(CusErrorMessage.PASSWORDS_NOT_MATCHING);
        }

        if (!passwordEncoder.matches(cusCustomerUpdateRequestDto.getPassword(), userDetails.getPassword())) {
            throw new BusinessException(CusErrorMessage.WRONG_PASSWORD);
        }

        CusCustomer cusCustomer = cusCustomerMapper.convertToCusCustomer(userDetails);

        String newPassword = passwordEncoder.encode(cusCustomerUpdateRequestDto.getNewPassword());
        cusCustomer.setPassword(newPassword);

        try {
            cusCustomer = cusCustomerEntityService.save(cusCustomer);
        } catch (DataIntegrityViolationException ex) {
            throw new BusinessException(CusErrorMessage.PASSWORD_LENGTH);
        }

        CusCustomerDto cusCustomerDto = cusCustomerMapper.convertToCusCustomerDto(cusCustomer);

        return cusCustomerDto;
    }
}