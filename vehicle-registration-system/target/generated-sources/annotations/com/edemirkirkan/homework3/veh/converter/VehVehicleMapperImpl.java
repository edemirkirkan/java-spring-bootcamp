package com.edemirkirkan.homework3.veh.converter;

import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import com.edemirkirkan.homework3.veh.dto.VehVehicleRequestDto;
import com.edemirkirkan.homework3.veh.dto.VehVehicleResponseDto;
import com.edemirkirkan.homework3.veh.dto.VehVehicleUpdateRequestDto;
import com.edemirkirkan.homework3.veh.entity.VehVehicle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-20T00:36:44+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class VehVehicleMapperImpl extends VehVehicleMapper {

    @Override
    public VehVehicleResponseDto convertToVehVehicleResponseDto(VehVehicle vehVehicle) {
        if ( vehVehicle == null ) {
            return null;
        }

        VehVehicleResponseDto vehVehicleResponseDto = new VehVehicleResponseDto();

        vehVehicleResponseDto.setCustomerId( vehVehicleCusCustomerId( vehVehicle ) );
        vehVehicleResponseDto.setId( vehVehicle.getId() );
        vehVehicleResponseDto.setBrand( vehVehicle.getBrand() );
        vehVehicleResponseDto.setModel( vehVehicle.getModel() );
        vehVehicleResponseDto.setPlate( vehVehicle.getPlate() );

        return vehVehicleResponseDto;
    }

    @Override
    public VehVehicle convertToVehVehicle(VehVehicleRequestDto vehVehicleRequestDto) {
        if ( vehVehicleRequestDto == null ) {
            return null;
        }

        VehVehicle vehVehicle = new VehVehicle();

        vehVehicle.setBrand( vehVehicleRequestDto.getBrand() );
        vehVehicle.setModel( vehVehicleRequestDto.getModel() );
        vehVehicle.setPlate( vehVehicleRequestDto.getPlate() );

        vehVehicle.setCusCustomer( cusCustomerEntityService.findByIdWithControl(vehVehicleRequestDto.getCustomerId()) );

        return vehVehicle;
    }

    @Override
    public VehVehicle convertToVehVehicle(VehVehicleUpdateRequestDto vehVehicleUpdateRequestDto) {
        if ( vehVehicleUpdateRequestDto == null ) {
            return null;
        }

        VehVehicle vehVehicle = new VehVehicle();

        vehVehicle.setId( vehVehicleUpdateRequestDto.getId() );
        vehVehicle.setBrand( vehVehicleUpdateRequestDto.getBrand() );
        vehVehicle.setModel( vehVehicleUpdateRequestDto.getModel() );
        vehVehicle.setPlate( vehVehicleUpdateRequestDto.getPlate() );

        vehVehicle.setCusCustomer( cusCustomerEntityService.findByIdWithControl(vehVehicleUpdateRequestDto.getCustomerId()) );

        return vehVehicle;
    }

    @Override
    public List<VehVehicleResponseDto> convertToVehVehicleResponseDtoList(List<VehVehicle> vehVehicleList) {
        if ( vehVehicleList == null ) {
            return null;
        }

        List<VehVehicleResponseDto> list = new ArrayList<VehVehicleResponseDto>( vehVehicleList.size() );
        for ( VehVehicle vehVehicle : vehVehicleList ) {
            list.add( convertToVehVehicleResponseDto( vehVehicle ) );
        }

        return list;
    }

    private Long vehVehicleCusCustomerId(VehVehicle vehVehicle) {
        if ( vehVehicle == null ) {
            return null;
        }
        CusCustomer cusCustomer = vehVehicle.getCusCustomer();
        if ( cusCustomer == null ) {
            return null;
        }
        Long id = cusCustomer.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
