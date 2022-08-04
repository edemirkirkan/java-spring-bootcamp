package edemirkirkan.homework2.cnt.converter;

import edemirkirkan.homework2.cnt.dto.CntCountryDto;
import edemirkirkan.homework2.cnt.dto.CntCountrySaveDto;
import edemirkirkan.homework2.cnt.entity.CntCountry;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-16T20:50:46+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class CntCountryMapperImpl implements CntCountryMapper {

    @Override
    public CntCountryDto convertToCntCountryDto(CntCountry cntCountry) {
        if ( cntCountry == null ) {
            return null;
        }

        CntCountryDto cntCountryDto = new CntCountryDto();

        cntCountryDto.setId( cntCountry.getId() );
        cntCountryDto.setName( cntCountry.getName() );
        cntCountryDto.setCode( cntCountry.getCode() );

        return cntCountryDto;
    }

    @Override
    public CntCountry convertToCntCountry(CntCountrySaveDto cntCountrySaveDto) {
        if ( cntCountrySaveDto == null ) {
            return null;
        }

        CntCountry cntCountry = new CntCountry();

        cntCountry.setName( cntCountrySaveDto.getName() );
        cntCountry.setCode( cntCountrySaveDto.getCode() );

        return cntCountry;
    }
}
