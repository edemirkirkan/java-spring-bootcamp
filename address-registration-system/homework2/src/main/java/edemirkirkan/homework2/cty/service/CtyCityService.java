package edemirkirkan.homework2.cty.service;

import edemirkirkan.homework2.cty.converter.CtyCityMapper;
import edemirkirkan.homework2.cty.dto.CtyCityDto;
import edemirkirkan.homework2.cty.dto.CtyCitySaveDto;
import edemirkirkan.homework2.cty.entity.CtyCity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CtyCityService {
    private final CtyCityEntityService ctyCityEntityService;
    private final CtyCityMapper ctyCityMapper;

    public CtyCityDto saveCity(CtyCitySaveDto ctyCitySaveDto) {
        CtyCity ctyCity = ctyCityMapper.convertToCtyCity(ctyCitySaveDto);
        ctyCity = ctyCityEntityService.save(ctyCity);
        CtyCityDto ctyCityDto = ctyCityMapper.convertToCtyCityDto(ctyCity);
        return ctyCityDto;
    }

    public CtyCityDto findCityByCode(String code) {
        CtyCity ctyCity = ctyCityEntityService.findByCode(code);
        if (ctyCity == null) {
            throw new RuntimeException("City not found");
        }
        CtyCityDto ctyCityDto = ctyCityMapper.convertToCtyCityDto(ctyCity);
        return ctyCityDto;
    }


}
