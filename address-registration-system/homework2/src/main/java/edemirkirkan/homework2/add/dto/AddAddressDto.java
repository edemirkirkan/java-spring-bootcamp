package edemirkirkan.homework2.add.dto;

import lombok.Data;

@Data
public class AddAddressDto {
    private Long id;
    private String countryName;
    private String countryCode;
    private String cityName;
    private String cityCode;
    private String districtName;
    private String postalCode;
    private String quarterName;
    private String streetName;
    private String buildingNo;
    private String flatNo;
}
