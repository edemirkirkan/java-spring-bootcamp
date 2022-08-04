package com.edemirkirkan.homework3.veh.converter;

import com.edemirkirkan.homework3.cus.service.entityservice.CusCustomerEntityService;
import com.edemirkirkan.homework3.veh.dto.VehVehicleRequestDto;
import com.edemirkirkan.homework3.veh.dto.VehVehicleResponseDto;
import com.edemirkirkan.homework3.veh.dto.VehVehicleUpdateRequestDto;
import com.edemirkirkan.homework3.veh.entity.VehVehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class VehVehicleMapper {

    @Autowired
    CusCustomerEntityService cusCustomerEntityService;

    @Mapping(source = "cusCustomer.id", target = "customerId")
    public abstract VehVehicleResponseDto convertToVehVehicleResponseDto(VehVehicle vehVehicle);

    @Mapping(
            target = "cusCustomer",
            expression = "java(cusCustomerEntityService.findByIdWithControl(vehVehicleRequestDto.getCustomerId()))")
    public abstract VehVehicle convertToVehVehicle(VehVehicleRequestDto vehVehicleRequestDto);

    @Mapping(
            target = "cusCustomer",
            expression = "java(cusCustomerEntityService.findByIdWithControl(vehVehicleUpdateRequestDto.getCustomerId()))")
    public abstract VehVehicle convertToVehVehicle(VehVehicleUpdateRequestDto vehVehicleUpdateRequestDto);

    public abstract List<VehVehicleResponseDto> convertToVehVehicleResponseDtoList(List<VehVehicle> vehVehicleList);
}

