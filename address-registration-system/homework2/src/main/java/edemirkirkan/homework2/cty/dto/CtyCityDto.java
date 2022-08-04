package edemirkirkan.homework2.cty.dto;

import lombok.Data;

@Data
public class CtyCityDto {
    private Long id;
    private String name;
    private String code;
    private Long countryId;
}
