package edemirkirkan.homework2.str.converter;

import edemirkirkan.homework2.cnt.entity.CntCountry;
import edemirkirkan.homework2.cty.entity.CtyCity;
import edemirkirkan.homework2.dis.entity.DisDistrict;
import edemirkirkan.homework2.qua.entity.QuaQuarter;
import edemirkirkan.homework2.str.dto.StrStreetDto;
import edemirkirkan.homework2.str.dto.StrStreetSaveDto;
import edemirkirkan.homework2.str.entity.StrStreet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-16T20:50:46+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class StrStreetMapperImpl extends StrStreetMapper {

    @Override
    public StrStreetDto convertToStrStreetDto(StrStreet strStreet) {
        if ( strStreet == null ) {
            return null;
        }

        StrStreetDto strStreetDto = new StrStreetDto();

        strStreetDto.setQuarterId( strStreetQuaQuarterId( strStreet ) );
        strStreetDto.setDistrictId( strStreetQuaQuarterDisDistrictId( strStreet ) );
        strStreetDto.setCityId( strStreetQuaQuarterDisDistrictCtyCityId( strStreet ) );
        strStreetDto.setCountryId( strStreetQuaQuarterDisDistrictCtyCityCntCountryId( strStreet ) );
        strStreetDto.setId( strStreet.getId() );
        strStreetDto.setName( strStreet.getName() );

        return strStreetDto;
    }

    @Override
    public List<StrStreetDto> convertToStrStreetDtoList(List<StrStreet> strStreetList) {
        if ( strStreetList == null ) {
            return null;
        }

        List<StrStreetDto> list = new ArrayList<StrStreetDto>( strStreetList.size() );
        for ( StrStreet strStreet : strStreetList ) {
            list.add( convertToStrStreetDto( strStreet ) );
        }

        return list;
    }

    @Override
    public StrStreet convertToStrStreet(StrStreetSaveDto strStreetSaveDto) {
        if ( strStreetSaveDto == null ) {
            return null;
        }

        StrStreet strStreet = new StrStreet();

        strStreet.setName( strStreetSaveDto.getName() );

        strStreet.setQuaQuarter( quaQuarterEntityService.findById(strStreetSaveDto.getQuarterId()) );

        return strStreet;
    }

    private Long strStreetQuaQuarterId(StrStreet strStreet) {
        if ( strStreet == null ) {
            return null;
        }
        QuaQuarter quaQuarter = strStreet.getQuaQuarter();
        if ( quaQuarter == null ) {
            return null;
        }
        Long id = quaQuarter.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long strStreetQuaQuarterDisDistrictId(StrStreet strStreet) {
        if ( strStreet == null ) {
            return null;
        }
        QuaQuarter quaQuarter = strStreet.getQuaQuarter();
        if ( quaQuarter == null ) {
            return null;
        }
        DisDistrict disDistrict = quaQuarter.getDisDistrict();
        if ( disDistrict == null ) {
            return null;
        }
        Long id = disDistrict.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long strStreetQuaQuarterDisDistrictCtyCityId(StrStreet strStreet) {
        if ( strStreet == null ) {
            return null;
        }
        QuaQuarter quaQuarter = strStreet.getQuaQuarter();
        if ( quaQuarter == null ) {
            return null;
        }
        DisDistrict disDistrict = quaQuarter.getDisDistrict();
        if ( disDistrict == null ) {
            return null;
        }
        CtyCity ctyCity = disDistrict.getCtyCity();
        if ( ctyCity == null ) {
            return null;
        }
        Long id = ctyCity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long strStreetQuaQuarterDisDistrictCtyCityCntCountryId(StrStreet strStreet) {
        if ( strStreet == null ) {
            return null;
        }
        QuaQuarter quaQuarter = strStreet.getQuaQuarter();
        if ( quaQuarter == null ) {
            return null;
        }
        DisDistrict disDistrict = quaQuarter.getDisDistrict();
        if ( disDistrict == null ) {
            return null;
        }
        CtyCity ctyCity = disDistrict.getCtyCity();
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
