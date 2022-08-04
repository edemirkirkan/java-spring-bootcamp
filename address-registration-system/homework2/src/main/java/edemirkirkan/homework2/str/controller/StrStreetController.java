package edemirkirkan.homework2.str.controller;

import edemirkirkan.homework2.str.dto.StrStreetDto;
import edemirkirkan.homework2.str.dto.StrStreetSaveDto;
import edemirkirkan.homework2.str.service.StrStreetService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/streets")
@RequiredArgsConstructor
public class StrStreetController {
    private final StrStreetService strStreetService;

    @Operation(tags = "Address Controller")
    @PostMapping
    public ResponseEntity<StrStreetDto> saveStreet(@RequestBody StrStreetSaveDto strStreetSaveDto) {
        StrStreetDto strStreetDto = strStreetService.saveStreet(strStreetSaveDto);
        return ResponseEntity.ok(strStreetDto);
    }


    @Operation(tags = "Address Controller")
    @PatchMapping("update/{name}/{id}")
    public ResponseEntity<StrStreetDto> updateStreetName(@PathVariable String name, @PathVariable Long id) {
        StrStreetDto strStreetDto = strStreetService.updateStreetName(name, id);
        return ResponseEntity.ok(strStreetDto);
    }

    @Operation(tags = "Address Controller")
    @GetMapping("/{quarterId}")
    public ResponseEntity<List<StrStreetDto>> findAllStreets(@PathVariable Long quarterId) {
        List<StrStreetDto> strStreetDtoList = strStreetService.findAllStreets(quarterId);
        return ResponseEntity.ok(strStreetDtoList);
    }


}
