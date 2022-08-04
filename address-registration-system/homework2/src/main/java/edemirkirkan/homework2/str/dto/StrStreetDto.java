package edemirkirkan.homework2.str.dto;

import lombok.Data;

@Data
public class StrStreetDto {
    private Long id;
    private String name;
    private Long quarterId;
    private Long districtId;
    private Long cityId;
    private Long countryId;
}
