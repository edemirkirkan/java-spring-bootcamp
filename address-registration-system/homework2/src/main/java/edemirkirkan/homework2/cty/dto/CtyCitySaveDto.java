package edemirkirkan.homework2.cty.dto;

import lombok.Data;

@Data
public class CtyCitySaveDto {
    private String name;
    private String code;
    private Long countryId;
}
