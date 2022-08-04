package edemirkirkan.homework2.add.service;

import edemirkirkan.homework2.add.converter.AddAddressConverter;
import edemirkirkan.homework2.add.converter.AddAddressMapper;
import edemirkirkan.homework2.add.dto.AddAddressDto;
import edemirkirkan.homework2.add.dto.AddAddressSaveDto;
import edemirkirkan.homework2.add.entity.AddAddress;
import edemirkirkan.homework2.add.service.entityservice.AddAddressEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddAddressService {
    private final AddAddressEntityService addAddressEntityService;
    private final AddAddressMapper addAddressMapper;

    public AddAddressDto findAddressById(Long id) {
        AddAddress addAddress = addAddressEntityService.findById(id);
        AddAddressDto addAddressDto = AddAddressConverter.convertToAddAddressDto(addAddress);
        return addAddressDto;
    }

    public AddAddressDto saveAddress(AddAddressSaveDto addAddressSaveDto) {
        AddAddress addAddress = addAddressMapper.convertToEntity(addAddressSaveDto);
        addAddress.setBuildingNo(addAddressSaveDto.getBuildingNo());
        addAddress.setFlatNo(addAddressSaveDto.getFlatNo());
        addAddress = addAddressEntityService.save(addAddress);
        AddAddressDto addAddressDto = AddAddressConverter.convertToAddAddressDto(addAddress);
        return addAddressDto;
    }

    public void deleteAddress(Long id) {
        AddAddress addAddress = addAddressEntityService.findById(id);
        addAddressEntityService.delete(addAddress);
    }
}
