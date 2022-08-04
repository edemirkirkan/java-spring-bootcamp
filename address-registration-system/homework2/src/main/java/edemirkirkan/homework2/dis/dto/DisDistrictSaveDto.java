package edemirkirkan.homework2.dis.dto;

import lombok.Data;

@Data
public class DisDistrictSaveDto {
    private String name;
    private String postalCode;
    private Long cityId;
}
