package com.edemirkirkan.homework3.cus.converter;

import com.edemirkirkan.homework3.cus.dto.CusCustomerDto;
import com.edemirkirkan.homework3.cus.dto.CusCustomerSaveRequestDto;
import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import com.edemirkirkan.homework3.sec.jwt.SecUserDetails;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-20T00:36:44+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class CusCustomerMapperImpl extends CusCustomerMapper {

    @Override
    public CusCustomerDto convertToCusCustomerDto(CusCustomer cusCustomer) {
        if ( cusCustomer == null ) {
            return null;
        }

        CusCustomerDto cusCustomerDto = new CusCustomerDto();

        cusCustomerDto.setId( cusCustomer.getId() );
        cusCustomerDto.setFirstName( cusCustomer.getFirstName() );
        cusCustomerDto.setLastName( cusCustomer.getLastName() );
        cusCustomerDto.setUsername( cusCustomer.getUsername() );
        cusCustomerDto.setPassword( cusCustomer.getPassword() );

        return cusCustomerDto;
    }

    @Override
    public CusCustomer convertToCusCustomer(SecUserDetails secUserDetails) {
        if ( secUserDetails == null ) {
            return null;
        }

        CusCustomer cusCustomer = new CusCustomer();

        cusCustomer.setId( secUserDetails.getId() );
        cusCustomer.setFirstName( secUserDetails.getFirstName() );
        cusCustomer.setLastName( secUserDetails.getLastName() );
        cusCustomer.setUsername( secUserDetails.getUsername() );
        cusCustomer.setPassword( secUserDetails.getPassword() );

        return cusCustomer;
    }

    @Override
    public CusCustomer convertToCusCustomer(CusCustomerSaveRequestDto cusCustomerSaveRequestDto) {
        if ( cusCustomerSaveRequestDto == null ) {
            return null;
        }

        CusCustomer cusCustomer = new CusCustomer();

        cusCustomer.setFirstName( cusCustomerSaveRequestDto.getFirstName() );
        cusCustomer.setLastName( cusCustomerSaveRequestDto.getLastName() );
        cusCustomer.setUsername( cusCustomerSaveRequestDto.getUsername() );
        cusCustomer.setPassword( cusCustomerSaveRequestDto.getPassword() );

        return cusCustomer;
    }
}
