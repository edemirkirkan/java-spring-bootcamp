package edemirkirkan.homework2.dis.converter;

import edemirkirkan.homework2.cty.service.CtyCityEntityService;
import edemirkirkan.homework2.dis.dto.DisDistrictDto;
import edemirkirkan.homework2.dis.dto.DisDistrictSaveDto;
import edemirkirkan.homework2.dis.entity.DisDistrict;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class DisDistrictMapper {

    @Autowired
    CtyCityEntityService ctyCityEntityService;
    @Mapping(target = "cityId", source = "ctyCity.id")
    @Mapping(target = "countryId", source = "ctyCity.cntCountry.id")
    public abstract DisDistrictDto convertToDisDistrictDto(DisDistrict disDistrict);

    public abstract List<DisDistrictDto> convertToDisDistrictDtoList(List<DisDistrict> disDistrictList);

    @Mapping(target = "ctyCity", expression = "java(ctyCityEntityService.findById(disDistrictSaveDto.getCityId()))")
    public abstract DisDistrict convertToDisDistrict(DisDistrictSaveDto disDistrictSaveDto);
}
