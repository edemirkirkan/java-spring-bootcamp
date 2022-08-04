package edemirkirkan.homework2.add.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddAddressSaveDto {
    private String buildingNo;
    private String flatNo;
    private Long streetId;
}
