package edemirkirkan.homework2.add.converter;

import edemirkirkan.homework2.add.dto.AddAddressDto;
import edemirkirkan.homework2.add.dto.AddAddressSaveDto;
import edemirkirkan.homework2.add.entity.AddAddress;
import edemirkirkan.homework2.str.service.entityservice.StrStreetEntityService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class AddAddressMapper {
    @Autowired
    StrStreetEntityService strStreetEntityService;

    @Mapping(target = "strStreet", expression = "java(strStreetEntityService.findById(addAddressSaveDto.getStreetId()))")
    public abstract AddAddress convertToEntity(AddAddressSaveDto addAddressSaveDto);
}
