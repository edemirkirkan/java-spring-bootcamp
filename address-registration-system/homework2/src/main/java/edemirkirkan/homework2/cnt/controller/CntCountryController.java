package edemirkirkan.homework2.cnt.controller;

import edemirkirkan.homework2.cnt.converter.CntCountryMapper;
import edemirkirkan.homework2.cnt.dto.CntCountryDto;
import edemirkirkan.homework2.cnt.dto.CntCountrySaveDto;
import edemirkirkan.homework2.cnt.entity.CntCountry;
import edemirkirkan.homework2.cnt.service.entityservice.CntCountryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CntCountryController {
    private final CntCountryService cntCountryService;

    @Operation(tags = "Address Controller")
    @PostMapping
    public ResponseEntity<CntCountryDto> saveCountry(@RequestBody CntCountrySaveDto cntCountrySaveDto) {
        CntCountry cntCountry = cntCountryService.saveCountry(cntCountrySaveDto);
        CntCountryDto cntCountryDto = CntCountryMapper.INSTANCE.convertToCntCountryDto(cntCountry);
        return ResponseEntity.ok(cntCountryDto);
    }

    @Operation(tags = "Address Controller")
    @GetMapping("/{code}")
    public ResponseEntity<CntCountryDto> findCountryByCode(@PathVariable String code) {
        CntCountryDto cntCountryDto = cntCountryService.findCountryDtoByCode(code);
        return ResponseEntity.ok(cntCountryDto);
    }
}
