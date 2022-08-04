package edemirkirkan.homework2.dis.dto;

import lombok.Data;

@Data
public class DisDistrictDto {
    private Long id;
    private String name;
    private String postalCode;
    private Long cityId;
    private Long countryId;
}
