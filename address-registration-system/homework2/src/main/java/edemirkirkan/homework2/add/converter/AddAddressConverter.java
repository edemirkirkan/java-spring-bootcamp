package edemirkirkan.homework2.add.converter;

import edemirkirkan.homework2.add.dto.AddAddressDto;
import edemirkirkan.homework2.add.entity.AddAddress;
import edemirkirkan.homework2.cnt.entity.CntCountry;
import edemirkirkan.homework2.cty.entity.CtyCity;
import edemirkirkan.homework2.dis.entity.DisDistrict;
import edemirkirkan.homework2.qua.entity.QuaQuarter;
import edemirkirkan.homework2.str.entity.StrStreet;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddAddressConverter {

    public static AddAddressDto convertToAddAddressDto(AddAddress addAddress){

        AddAddressDto addAddressDto = new AddAddressDto();
        StrStreet strStreet = addAddress.getStrStreet();
        QuaQuarter quaQuarter = strStreet.getQuaQuarter();
        DisDistrict disDistrict = quaQuarter.getDisDistrict();
        CtyCity ctyCity = disDistrict.getCtyCity();
        CntCountry cntCountry = ctyCity.getCntCountry();

        addAddressDto.setId(addAddress.getId());
        addAddressDto.setStreetName(strStreet.getName());
        addAddressDto.setQuarterName(quaQuarter.getName());
        addAddressDto.setDistrictName(disDistrict.getName());
        addAddressDto.setPostalCode(disDistrict.getPostalCode());
        addAddressDto.setCityName(ctyCity.getName());
        addAddressDto.setCountryName(cntCountry.getName());
        addAddressDto.setCountryCode(cntCountry.getCode());
        addAddressDto.setBuildingNo(addAddress.getBuildingNo());
        addAddressDto.setFlatNo(addAddress.getFlatNo());
        addAddressDto.setCityCode(ctyCity.getCode());

        return addAddressDto;
    }
}
