package edemirkirkan.homework2.qua.controller;

import edemirkirkan.homework2.qua.dto.QuaQuarterDto;
import edemirkirkan.homework2.qua.dto.QuaQuarterSaveDto;
import edemirkirkan.homework2.qua.service.QuaQuarterService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quarters")
@RequiredArgsConstructor
public class QuaQuarterController {
    private final QuaQuarterService quaQuarterService;

    @Operation(tags = "Address Controller")
    @PostMapping
    public ResponseEntity<QuaQuarterDto> saveQuarter(@RequestBody QuaQuarterSaveDto quaQuarterSaveDto) {
        QuaQuarterDto quaQuarterDto = quaQuarterService.saveQuarter(quaQuarterSaveDto);
        return ResponseEntity.ok(quaQuarterDto);
    }

    @Operation(tags = "Address Controller")
    @PatchMapping("update/{name}/{id}")
    public ResponseEntity<QuaQuarterDto> updateQuarterName(@PathVariable String name, @PathVariable Long id) {
        QuaQuarterDto quaQuarterDto = quaQuarterService.updateQuarterName(name, id);
        return ResponseEntity.ok(quaQuarterDto);
    }

    @Operation(tags = "Address Controller")
    @GetMapping("/{districtId}")
    public ResponseEntity<List<QuaQuarterDto>> findAllQuarters(@PathVariable Long districtId) {
        List<QuaQuarterDto> quaQuarterDtoList = quaQuarterService.findAllQuarters(districtId);
        return ResponseEntity.ok(quaQuarterDtoList);
    }


}
