package edemirkirkan.homework2.qua.converter;

import edemirkirkan.homework2.cnt.entity.CntCountry;
import edemirkirkan.homework2.cty.entity.CtyCity;
import edemirkirkan.homework2.dis.entity.DisDistrict;
import edemirkirkan.homework2.qua.dto.QuaQuarterDto;
import edemirkirkan.homework2.qua.dto.QuaQuarterSaveDto;
import edemirkirkan.homework2.qua.entity.QuaQuarter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-16T20:50:47+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class QuaQuarterMapperImpl extends QuaQuarterMapper {

    @Override
    public QuaQuarterDto convertToQuaQuarterDto(QuaQuarter quaQuarter) {
        if ( quaQuarter == null ) {
            return null;
        }

        QuaQuarterDto quaQuarterDto = new QuaQuarterDto();

        quaQuarterDto.setDistrictId( quaQuarterDisDistrictId( quaQuarter ) );
        quaQuarterDto.setCityId( quaQuarterDisDistrictCtyCityId( quaQuarter ) );
        quaQuarterDto.setCountryId( quaQuarterDisDistrictCtyCityCntCountryId( quaQuarter ) );
        quaQuarterDto.setId( quaQuarter.getId() );
        quaQuarterDto.setName( quaQuarter.getName() );

        return quaQuarterDto;
    }

    @Override
    public List<QuaQuarterDto> convertToQuaQuarterDtoList(List<QuaQuarter> quaQuarterList) {
        if ( quaQuarterList == null ) {
            return null;
        }

        List<QuaQuarterDto> list = new ArrayList<QuaQuarterDto>( quaQuarterList.size() );
        for ( QuaQuarter quaQuarter : quaQuarterList ) {
            list.add( convertToQuaQuarterDto( quaQuarter ) );
        }

        return list;
    }

    @Override
    public QuaQuarter convertToQuaQuarter(QuaQuarterSaveDto quaQuarterSaveDto) {
        if ( quaQuarterSaveDto == null ) {
            return null;
        }

        QuaQuarter quaQuarter = new QuaQuarter();

        quaQuarter.setName( quaQuarterSaveDto.getName() );

        quaQuarter.setDisDistrict( disDistrictEntityService.findById(quaQuarterSaveDto.getDistrictId()) );

        return quaQuarter;
    }

    private Long quaQuarterDisDistrictId(QuaQuarter quaQuarter) {
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

    private Long quaQuarterDisDistrictCtyCityId(QuaQuarter quaQuarter) {
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

    private Long quaQuarterDisDistrictCtyCityCntCountryId(QuaQuarter quaQuarter) {
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
