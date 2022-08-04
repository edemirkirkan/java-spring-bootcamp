package edemirkirkan.homework2.cty.converter;

import edemirkirkan.homework2.cnt.entity.CntCountry;
import edemirkirkan.homework2.cty.dto.CtyCityDto;
import edemirkirkan.homework2.cty.dto.CtyCitySaveDto;
import edemirkirkan.homework2.cty.entity.CtyCity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-16T20:50:47+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class CtyCityMapperImpl extends CtyCityMapper {

    @Override
    public CtyCityDto convertToCtyCityDto(CtyCity ctyCity) {
        if ( ctyCity == null ) {
            return null;
        }

        CtyCityDto ctyCityDto = new CtyCityDto();

        ctyCityDto.setCountryId( ctyCityCntCountryId( ctyCity ) );
        ctyCityDto.setId( ctyCity.getId() );
        ctyCityDto.setName( ctyCity.getName() );
        ctyCityDto.setCode( ctyCity.getCode() );

        return ctyCityDto;
    }

    @Override
    public CtyCity convertToCtyCity(CtyCitySaveDto ctyCitySaveDto) {
        if ( ctyCitySaveDto == null ) {
            return null;
        }

        CtyCity ctyCity = new CtyCity();

        ctyCity.setName( ctyCitySaveDto.getName() );
        ctyCity.setCode( ctyCitySaveDto.getCode() );

        ctyCity.setCntCountry( cntCountryEntityService.findById(ctyCitySaveDto.getCountryId()) );

        return ctyCity;
    }

    private Long ctyCityCntCountryId(CtyCity ctyCity) {
        if ( ctyCity == null ) {
            return null;
        }
        CntCountry cntCountry = ctyCity.getCntCountry();
        if ( cntCountry == null ) {
            return null;
        }
        Long id = cntCountry.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
