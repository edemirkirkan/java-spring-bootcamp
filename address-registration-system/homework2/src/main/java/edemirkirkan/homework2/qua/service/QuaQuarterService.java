package edemirkirkan.homework2.qua.service;

import edemirkirkan.homework2.qua.converter.QuaQuarterMapper;
import edemirkirkan.homework2.qua.dto.QuaQuarterDto;
import edemirkirkan.homework2.qua.dto.QuaQuarterSaveDto;
import edemirkirkan.homework2.qua.entity.QuaQuarter;
import edemirkirkan.homework2.qua.service.entityservice.QuaQuarterEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class QuaQuarterService {
    private final QuaQuarterEntityService quaQuarterEntityService;
    private final QuaQuarterMapper quaQuarterMapper;
    public QuaQuarterDto updateQuarterName(String name, Long id) {
        QuaQuarter quaQuarter = quaQuarterEntityService.findById(id);
        quaQuarter.setName(name);
        quaQuarter = quaQuarterEntityService.save(quaQuarter);
        QuaQuarterDto quaQuarterDto = quaQuarterMapper.convertToQuaQuarterDto(quaQuarter);
        return quaQuarterDto;
    }

    public QuaQuarterDto saveQuarter(QuaQuarterSaveDto quaQuarterSaveDto) {
        QuaQuarter quaQuarter = quaQuarterMapper.convertToQuaQuarter(quaQuarterSaveDto);
        quaQuarter = quaQuarterEntityService.save(quaQuarter);
        QuaQuarterDto quaQuarterDto = quaQuarterMapper.convertToQuaQuarterDto(quaQuarter);
        return quaQuarterDto;
    }

    public List<QuaQuarterDto> findAllQuarters(Long districtId) {
        List<QuaQuarter> quaQuarterList = quaQuarterEntityService.findAll();
        List<QuaQuarterDto> quaQuarterDtoList = quaQuarterMapper.convertToQuaQuarterDtoList(quaQuarterList);
        List<QuaQuarterDto> quaQuarterDtoListCity = new ArrayList<>();
        for (QuaQuarterDto quaQuarterDto : quaQuarterDtoList) {
            if (Objects.equals(quaQuarterDto.getDistrictId(), districtId)) {
                quaQuarterDtoListCity.add(quaQuarterDto);
            }
        }
        return quaQuarterDtoListCity;
    }
}
