package edemirkirkan.homework2.cty.controller;

import edemirkirkan.homework2.cty.dto.CtyCityDto;
import edemirkirkan.homework2.cty.dto.CtyCitySaveDto;
import edemirkirkan.homework2.cty.service.CtyCityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CtyCityController {
    private final CtyCityService ctyCityService;

    @Operation(tags = "Address Controller")
    @PostMapping
    public ResponseEntity<CtyCityDto> saveCity(@RequestBody CtyCitySaveDto ctyCitySaveDto) {
        CtyCityDto ctyCityDto = ctyCityService.saveCity(ctyCitySaveDto);
        return ResponseEntity.ok(ctyCityDto);
    }

    @Operation(tags = "Address Controller")
    @GetMapping("/{code}")
    public ResponseEntity<CtyCityDto> findCityByCode(@PathVariable String code) {
        CtyCityDto ctyCityDto = ctyCityService.findCityByCode(code);
        return ResponseEntity.ok(ctyCityDto);
    }
}