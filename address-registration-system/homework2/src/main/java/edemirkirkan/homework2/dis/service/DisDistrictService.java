package edemirkirkan.homework2.dis.service;

import edemirkirkan.homework2.dis.converter.DisDistrictMapper;
import edemirkirkan.homework2.dis.dto.DisDistrictDto;
import edemirkirkan.homework2.dis.dto.DisDistrictSaveDto;
import edemirkirkan.homework2.dis.entity.DisDistrict;
import edemirkirkan.homework2.dis.service.entityservice.DisDistrictEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DisDistrictService {
    private final DisDistrictEntityService disDistrictEntityService;
    private final DisDistrictMapper disDistrictMapper;

    public DisDistrictDto saveDistrict(DisDistrictSaveDto disDistrictSaveDto) {
        DisDistrict disDistrict = disDistrictMapper.convertToDisDistrict(disDistrictSaveDto);
        disDistrict = disDistrictEntityService.save(disDistrict);
        DisDistrictDto disDistrictDto = disDistrictMapper.convertToDisDistrictDto(disDistrict);
        return disDistrictDto;
    }

    public List<DisDistrictDto> findAllDistricts(Long cityId) {
        List<DisDistrict> disDistrictList = disDistrictEntityService.findAll();

        List<DisDistrictDto> disDistrictDtoList = disDistrictMapper.convertToDisDistrictDtoList(disDistrictList);
        List<DisDistrictDto> disDistrictDtoListCity = new ArrayList<>();
        for (DisDistrictDto disDistrictDto : disDistrictDtoList) {
            if (Objects.equals(disDistrictDto.getCityId(), cityId)) {
                disDistrictDtoListCity.add(disDistrictDto);
            }
        }
        return disDistrictDtoListCity;
    }
}
