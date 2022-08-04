package edemirkirkan.homework2.cnt.service.entityservice;

import edemirkirkan.homework2.cnt.converter.CntCountryMapper;
import edemirkirkan.homework2.cnt.dto.CntCountryDto;
import edemirkirkan.homework2.cnt.dto.CntCountrySaveDto;
import edemirkirkan.homework2.cnt.entity.CntCountry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CntCountryService {
    private final CntCountryEntityService cntCountryEntityService;

    public CntCountry saveCountry(CntCountrySaveDto cntCountrySaveDto) {
        CntCountry cntCountry = CntCountryMapper.INSTANCE.convertToCntCountry(cntCountrySaveDto);
        cntCountry = cntCountryEntityService.save(cntCountry);
        return cntCountry;
    }

    public CntCountryDto findCountryDtoByCode(String code) {
        CntCountry cntCountry = cntCountryEntityService.findByCode(code);
        if (cntCountry == null) {
            throw new RuntimeException("Country not found");
        }
        CntCountryDto cntCountryDto = CntCountryMapper.INSTANCE.convertToCntCountryDto(cntCountry);
        return cntCountryDto;
    }

    public CntCountry findCountryByCode(String code) {
        CntCountry cntCountry = cntCountryEntityService.findByCode(code);
        if (cntCountry == null) {
            throw new RuntimeException("Country not found");
        }
        return cntCountry;
    }
}
