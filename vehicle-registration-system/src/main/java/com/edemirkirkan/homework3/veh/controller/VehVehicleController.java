package com.edemirkirkan.homework3.veh.controller;

import com.edemirkirkan.homework3.gen.response.RestResponse;
import com.edemirkirkan.homework3.veh.dto.VehVehicleRequestDto;
import com.edemirkirkan.homework3.veh.dto.VehVehicleResponseDto;
import com.edemirkirkan.homework3.veh.dto.VehVehicleUpdateRequestDto;
import com.edemirkirkan.homework3.veh.service.VehVehicleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/vehicles")
public class VehVehicleController {
    private final VehVehicleService vehVehicleService;

    @Operation(tags = "Vehicle Controller", description = "Save new vehicle")
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody VehVehicleRequestDto vehVehicleRequestDto){
        VehVehicleResponseDto vehicleResponseDto = vehVehicleService.save(vehVehicleRequestDto);
        return ResponseEntity.ok(RestResponse.of(vehicleResponseDto));
    }

    @Operation(tags = "Vehicle Controller", description = "Retrieve all vehicles belonging to user")
    @GetMapping
    public ResponseEntity findAll() {
        List<VehVehicleResponseDto> vehVehicleResponseDtoList = vehVehicleService.findAll();
        return ResponseEntity.ok(RestResponse.of(vehVehicleResponseDtoList));
    }

    @Operation(tags = "Vehicle Controller", description = "Retrieve vehicles by brand and model belonging to user")
    @GetMapping("/{brand}/{model}")
    public ResponseEntity findAllByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
        List<VehVehicleResponseDto> vehVehicleResponseDtoList = vehVehicleService.findAllByBrandAndModel(brand, model);
        return ResponseEntity.ok(RestResponse.of(vehVehicleResponseDtoList));
    }

    @Operation(tags = "Vehicle Controller", description = "Modify vehicle information")
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody VehVehicleUpdateRequestDto vehVehicleUpdateRequestDto){
        VehVehicleResponseDto vehicleResponseDto = vehVehicleService.update(vehVehicleUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.of(vehicleResponseDto));
    }

    @Operation(tags = "Vehicle Controller", description = "Delete vehicle")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        vehVehicleService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }


}
