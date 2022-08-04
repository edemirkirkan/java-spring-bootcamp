package edemirkirkan.homework2.str.converter;

import edemirkirkan.homework2.qua.service.entityservice.QuaQuarterEntityService;
import edemirkirkan.homework2.str.dto.StrStreetDto;
import edemirkirkan.homework2.str.dto.StrStreetSaveDto;
import edemirkirkan.homework2.str.entity.StrStreet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class StrStreetMapper {

    @Autowired
    QuaQuarterEntityService quaQuarterEntityService;

    @Mapping(target = "quarterId", source = "quaQuarter.id")
    @Mapping(target = "districtId", source = "quaQuarter.disDistrict.id")
    @Mapping(target = "cityId", source = "quaQuarter.disDistrict.ctyCity.id")
    @Mapping(target = "countryId", source = "quaQuarter.disDistrict.ctyCity.cntCountry.id")
    public abstract StrStreetDto convertToStrStreetDto(StrStreet strStreet);

    public abstract List<StrStreetDto> convertToStrStreetDtoList(List<StrStreet> strStreetList);

    @Mapping(target = "quaQuarter", expression = "java(quaQuarterEntityService.findById(strStreetSaveDto.getQuarterId()))")
    public abstract StrStreet convertToStrStreet(StrStreetSaveDto strStreetSaveDto);
}
