package com.edemirkirkan.homework3.cus.converter;

import com.edemirkirkan.homework3.cus.dto.CusCustomerDto;
import com.edemirkirkan.homework3.cus.dto.CusCustomerSaveRequestDto;
import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import com.edemirkirkan.homework3.sec.jwt.SecUserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class CusCustomerMapper {

    public abstract CusCustomerDto convertToCusCustomerDto(CusCustomer cusCustomer);

    public abstract CusCustomer convertToCusCustomer(SecUserDetails secUserDetails);

    public abstract CusCustomer convertToCusCustomer(CusCustomerSaveRequestDto cusCustomerSaveRequestDto);
}
