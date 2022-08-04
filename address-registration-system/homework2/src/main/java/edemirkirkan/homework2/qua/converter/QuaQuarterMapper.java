package edemirkirkan.homework2.qua.converter;

import edemirkirkan.homework2.dis.service.entityservice.DisDistrictEntityService;
import edemirkirkan.homework2.qua.dto.QuaQuarterDto;
import edemirkirkan.homework2.qua.dto.QuaQuarterSaveDto;
import edemirkirkan.homework2.qua.entity.QuaQuarter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class QuaQuarterMapper {

    @Autowired
    DisDistrictEntityService disDistrictEntityService;

    @Mapping(target = "districtId", source = "disDistrict.id")
    @Mapping(target = "cityId", source = "disDistrict.ctyCity.id")
    @Mapping(target = "countryId", source = "disDistrict.ctyCity.cntCountry.id")
    public abstract QuaQuarterDto convertToQuaQuarterDto(QuaQuarter quaQuarter);

    public abstract List<QuaQuarterDto> convertToQuaQuarterDtoList(List<QuaQuarter> quaQuarterList);

    @Mapping(target = "disDistrict", expression = "java(disDistrictEntityService.findById(quaQuarterSaveDto.getDistrictId()))")
    public abstract QuaQuarter convertToQuaQuarter(QuaQuarterSaveDto quaQuarterSaveDto);
}
