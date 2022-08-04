package edemirkirkan.homework2.cnt.converter;

import edemirkirkan.homework2.cnt.dto.CntCountryDto;
import edemirkirkan.homework2.cnt.dto.CntCountrySaveDto;
import edemirkirkan.homework2.cnt.entity.CntCountry;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CntCountryMapper {
    CntCountryMapper INSTANCE = Mappers.getMapper(CntCountryMapper.class);

    CntCountryDto convertToCntCountryDto(CntCountry cntCountry);
    CntCountry convertToCntCountry(CntCountrySaveDto cntCountrySaveDto);
}
