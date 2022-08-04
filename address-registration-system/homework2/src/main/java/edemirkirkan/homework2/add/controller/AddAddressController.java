package edemirkirkan.homework2.add.controller;

import edemirkirkan.homework2.add.dto.AddAddressDto;
import edemirkirkan.homework2.add.dto.AddAddressSaveDto;
import edemirkirkan.homework2.add.service.AddAddressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddAddressController {

    private final AddAddressService addAddressService;

    @Operation(tags = "Address Controller")
    @GetMapping("/{id}")
    public ResponseEntity<AddAddressDto> findAddressById(@PathVariable Long id) {
        AddAddressDto addAddressDto = addAddressService.findAddressById(id);
        return ResponseEntity.ok(addAddressDto);
    }

    @Operation(tags = "Address Controller")
    @PostMapping
    public ResponseEntity<AddAddressDto> saveAddress(@RequestBody AddAddressSaveDto addAddressSaveDto) {
        AddAddressDto addAddressDto = addAddressService.saveAddress(addAddressSaveDto);
        return ResponseEntity.ok(addAddressDto);
    }

    @Operation(tags = "Address Controller")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAddress(@PathVariable Long id) {
        addAddressService.deleteAddress(id);
        return ResponseEntity.ok().build();
    }

}
