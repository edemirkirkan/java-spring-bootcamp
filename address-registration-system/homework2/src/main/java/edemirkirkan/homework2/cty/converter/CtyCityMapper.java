package edemirkirkan.homework2.cty.converter;

import edemirkirkan.homework2.cnt.service.entityservice.CntCountryEntityService;
import edemirkirkan.homework2.cty.dto.CtyCityDto;
import edemirkirkan.homework2.cty.dto.CtyCitySaveDto;
import edemirkirkan.homework2.cty.entity.CtyCity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class CtyCityMapper {
    @Autowired
    CntCountryEntityService cntCountryEntityService;
    @Mapping(target = "countryId", source = "cntCountry.id")
    public abstract CtyCityDto convertToCtyCityDto(CtyCity ctyCity);

    @Mapping(
            target = "cntCountry",
            expression = "java(cntCountryEntityService.findById(ctyCitySaveDto.getCountryId()))")
    public abstract CtyCity convertToCtyCity(CtyCitySaveDto ctyCitySaveDto);

}
