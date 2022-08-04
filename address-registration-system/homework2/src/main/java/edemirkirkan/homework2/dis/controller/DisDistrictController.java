package edemirkirkan.homework2.dis.controller;

import edemirkirkan.homework2.dis.dto.DisDistrictDto;
import edemirkirkan.homework2.dis.dto.DisDistrictSaveDto;
import edemirkirkan.homework2.dis.service.DisDistrictService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/districts")
@RequiredArgsConstructor
public class DisDistrictController {
    private final DisDistrictService disDistrictService;

    @Operation(tags = "Address Controller")
    @GetMapping("/{cityId}")
    public ResponseEntity<List<DisDistrictDto>> findAllDistricts(@PathVariable Long cityId) {
        List<DisDistrictDto> disDistrictDto = disDistrictService.findAllDistricts(cityId);
        return ResponseEntity.ok(disDistrictDto);
    }

    @Operation(tags = "Address Controller")
    @PostMapping
    public ResponseEntity<DisDistrictDto> saveDistrict(@RequestBody DisDistrictSaveDto disDistrictSaveDto) {
        DisDistrictDto disDistrictDto = disDistrictService.saveDistrict(disDistrictSaveDto);
        return ResponseEntity.ok(disDistrictDto);
    }

}
