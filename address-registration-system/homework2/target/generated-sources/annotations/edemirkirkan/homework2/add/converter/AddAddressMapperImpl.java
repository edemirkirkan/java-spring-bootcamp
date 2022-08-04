package edemirkirkan.homework2.add.converter;

import edemirkirkan.homework2.add.dto.AddAddressSaveDto;
import edemirkirkan.homework2.add.entity.AddAddress;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-16T20:50:47+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class AddAddressMapperImpl extends AddAddressMapper {

    @Override
    public AddAddress convertToEntity(AddAddressSaveDto addAddressSaveDto) {
        if ( addAddressSaveDto == null ) {
            return null;
        }

        AddAddress addAddress = new AddAddress();

        addAddress.setBuildingNo( addAddressSaveDto.getBuildingNo() );
        addAddress.setFlatNo( addAddressSaveDto.getFlatNo() );

        addAddress.setStrStreet( strStreetEntityService.findById(addAddressSaveDto.getStreetId()) );

        return addAddress;
    }
}
