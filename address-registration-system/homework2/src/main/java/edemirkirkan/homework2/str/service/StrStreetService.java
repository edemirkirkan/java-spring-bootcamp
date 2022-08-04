package edemirkirkan.homework2.str.service;

import edemirkirkan.homework2.str.converter.StrStreetMapper;
import edemirkirkan.homework2.str.dto.StrStreetDto;
import edemirkirkan.homework2.str.dto.StrStreetSaveDto;
import edemirkirkan.homework2.str.entity.StrStreet;
import edemirkirkan.homework2.str.service.entityservice.StrStreetEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StrStreetService {
    private final StrStreetEntityService strStreetEntityService;
    private final StrStreetMapper strStreetMapper;

    public StrStreetDto updateStreetName(String name, Long id) {
        StrStreet strStreet = strStreetEntityService.findById(id);
        strStreet.setName(name);
        strStreet = strStreetEntityService.save(strStreet);
        StrStreetDto strStreetDto = strStreetMapper.convertToStrStreetDto(strStreet);
        return strStreetDto;
    }

    public StrStreetDto saveStreet(StrStreetSaveDto strStreetSaveDto) {
        StrStreet strStreet = strStreetMapper.convertToStrStreet(strStreetSaveDto);
        strStreet = strStreetEntityService.save(strStreet);
        StrStreetDto strStreetDto = strStreetMapper.convertToStrStreetDto(strStreet);
        return strStreetDto;
    }

    public List<StrStreetDto> findAllStreets(Long quarterId) {
        List<StrStreet> strStreetList = strStreetEntityService.findAll();
        List<StrStreetDto> strStreetDtoList = strStreetMapper.convertToStrStreetDtoList(strStreetList);
        List<StrStreetDto> strStreetDtoListCity = new ArrayList<>();
        for (StrStreetDto strStreetDto : strStreetDtoList) {
            if (Objects.equals(strStreetDto.getDistrictId(), quarterId)) {
                strStreetDtoListCity.add(strStreetDto);
            }
        }
        return strStreetDtoListCity;
    }
}
