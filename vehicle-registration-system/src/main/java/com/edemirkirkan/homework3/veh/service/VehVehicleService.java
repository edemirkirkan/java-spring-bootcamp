package com.edemirkirkan.homework3.veh.service;

import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import com.edemirkirkan.homework3.cus.service.entityservice.CusCustomerEntityService;
import com.edemirkirkan.homework3.gen.exceptions.BusinessException;
import com.edemirkirkan.homework3.sec.jwt.SecUserDetails;
import com.edemirkirkan.homework3.sec.jwt.SecUserDetailsService;
import com.edemirkirkan.homework3.veh.dto.VehVehicleRequestDto;
import com.edemirkirkan.homework3.veh.dto.VehVehicleResponseDto;
import com.edemirkirkan.homework3.veh.dto.VehVehicleUpdateRequestDto;
import com.edemirkirkan.homework3.veh.entity.VehVehicle;
import com.edemirkirkan.homework3.veh.enums.VehVehicleErrorMessage;
import com.edemirkirkan.homework3.veh.converter.VehVehicleMapper;
import com.edemirkirkan.homework3.veh.service.entityservice.VehVehicleEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VehVehicleService  {

    private final VehVehicleEntityService vehVehicleEntityService;
    private final VehVehicleMapper vehVehicleMapper;
    private final CusCustomerEntityService cusCustomerEntityService;
    private final SecUserDetailsService secUserDetailsService;

    public VehVehicleResponseDto save(VehVehicleRequestDto vehVehicleRequestDto) {

        CusCustomer cusCustomer = cusCustomerEntityService.findByIdWithControl(vehVehicleRequestDto.getCustomerId());

        if (cusCustomer == null) {
            throw new BusinessException(VehVehicleErrorMessage.VEHICLE_CUSTOMER_DOES_NOT_EXIST);
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecUserDetails userDetails = (SecUserDetails) secUserDetailsService.loadUserByUsername(((SecUserDetails) authentication.getPrincipal()).getUsername());
        if (!Objects.equals(userDetails.getId(), cusCustomer.getId())) {
            throw new BusinessException(VehVehicleErrorMessage.DIFFERENT_CUSTOMER_ACCESS);
        }

        VehVehicle vehVehicle = vehVehicleMapper.convertToVehVehicle(vehVehicleRequestDto);
        vehVehicle = vehVehicleEntityService.save(vehVehicle);
        VehVehicleResponseDto vehVehicleResponseDto = vehVehicleMapper.convertToVehVehicleResponseDto(vehVehicle);
        return  vehVehicleResponseDto;
    }

    public List<VehVehicleResponseDto> findAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecUserDetails userDetails = (SecUserDetails) secUserDetailsService.loadUserByUsername(((SecUserDetails) authentication.getPrincipal()).getUsername());
        CusCustomer cusCustomer = cusCustomerEntityService.findByIdWithControl(userDetails.getId());
        List<VehVehicle> vehVehicleList = vehVehicleEntityService.findAllByCusCustomer(cusCustomer);
        List<VehVehicleResponseDto> vehVehicleResponseDtoList = vehVehicleMapper.convertToVehVehicleResponseDtoList(vehVehicleList);
        return vehVehicleResponseDtoList;
    }

    public List<VehVehicleResponseDto> findAllByBrandAndModel(String brand, String model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecUserDetails userDetails = (SecUserDetails) secUserDetailsService.loadUserByUsername(((SecUserDetails) authentication.getPrincipal()).getUsername());
        CusCustomer cusCustomer = cusCustomerEntityService.findByIdWithControl(userDetails.getId());
        List<VehVehicle> vehVehicleList = vehVehicleEntityService.findAllByBrandAndModel(brand, model, cusCustomer);
        List<VehVehicleResponseDto> vehVehicleResponseDtoList = vehVehicleMapper.convertToVehVehicleResponseDtoList(vehVehicleList);
        return vehVehicleResponseDtoList;
    }


    public VehVehicleResponseDto update(VehVehicleUpdateRequestDto vehVehicleUpdateRequestDto) {
        Long id = vehVehicleUpdateRequestDto.getId();

        boolean isExist = vehVehicleEntityService.existsById(id);
        if (!isExist){
            throw new BusinessException(VehVehicleErrorMessage.VEHICLE_DOES_NOT_EXIST);
        }

        CusCustomer cusCustomer = cusCustomerEntityService.findByIdWithControl(vehVehicleUpdateRequestDto.getCustomerId());
        if (cusCustomer == null) {
            throw new BusinessException(VehVehicleErrorMessage.VEHICLE_CUSTOMER_DOES_NOT_EXIST);
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecUserDetails userDetails = (SecUserDetails) secUserDetailsService.loadUserByUsername(((SecUserDetails) authentication.getPrincipal()).getUsername());
        if (!Objects.equals(userDetails.getId(), cusCustomer.getId())) {
            throw new BusinessException(VehVehicleErrorMessage.DIFFERENT_CUSTOMER_ACCESS);
        }

        VehVehicle vehVehicle = vehVehicleMapper.convertToVehVehicle(vehVehicleUpdateRequestDto);
        vehVehicle = vehVehicleEntityService.save(vehVehicle);
        VehVehicleResponseDto vehVehicleResponseDto = vehVehicleMapper.convertToVehVehicleResponseDto(vehVehicle);
        return  vehVehicleResponseDto;
    }

    public void delete(Long id) {
        VehVehicle cusCustomer = vehVehicleEntityService.findByIdWithControl(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecUserDetails userDetails = (SecUserDetails) secUserDetailsService.loadUserByUsername(((SecUserDetails) authentication.getPrincipal()).getUsername());
        if (!Objects.equals(userDetails.getId(), cusCustomer.getId())) {
            throw new BusinessException(VehVehicleErrorMessage.DIFFERENT_CUSTOMER_ACCESS);
        }
        vehVehicleEntityService.delete(cusCustomer);
    }



}
