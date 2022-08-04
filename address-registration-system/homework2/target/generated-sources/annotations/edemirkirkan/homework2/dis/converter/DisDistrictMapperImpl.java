package edemirkirkan.homework2.dis.converter;

import edemirkirkan.homework2.cnt.entity.CntCountry;
import edemirkirkan.homework2.cty.entity.CtyCity;
import edemirkirkan.homework2.dis.dto.DisDistrictDto;
import edemirkirkan.homework2.dis.dto.DisDistrictSaveDto;
import edemirkirkan.homework2.dis.entity.DisDistrict;
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
public class DisDistrictMapperImpl extends DisDistrictMapper {

    @Override
    public DisDistrictDto convertToDisDistrictDto(DisDistrict disDistrict) {
        if ( disDistrict == null ) {
            return null;
        }

        DisDistrictDto disDistrictDto = new DisDistrictDto();

        disDistrictDto.setCityId( disDistrictCtyCityId( disDistrict ) );
        disDistrictDto.setCountryId( disDistrictCtyCityCntCountryId( disDistrict ) );
        disDistrictDto.setId( disDistrict.getId() );
        disDistrictDto.setName( disDistrict.getName() );
        disDistrictDto.setPostalCode( disDistrict.getPostalCode() );

        return disDistrictDto;
    }

    @Override
    public List<DisDistrictDto> convertToDisDistrictDtoList(List<DisDistrict> disDistrictList) {
        if ( disDistrictList == null ) {
            return null;
        }

        List<DisDistrictDto> list = new ArrayList<DisDistrictDto>( disDistrictList.size() );
        for ( DisDistrict disDistrict : disDistrictList ) {
            list.add( convertToDisDistrictDto( disDistrict ) );
        }

        return list;
    }

    @Override
    public DisDistrict convertToDisDistrict(DisDistrictSaveDto disDistrictSaveDto) {
        if ( disDistrictSaveDto == null ) {
            return null;
        }

        DisDistrict disDistrict = new DisDistrict();

        disDistrict.setName( disDistrictSaveDto.getName() );
        disDistrict.setPostalCode( disDistrictSaveDto.getPostalCode() );

        disDistrict.setCtyCity( ctyCityEntityService.findById(disDistrictSaveDto.getCityId()) );

        return disDistrict;
    }

    private Long disDistrictCtyCityId(DisDistrict disDistrict) {
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

    private Long disDistrictCtyCityCntCountryId(DisDistrict disDistrict) {
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
