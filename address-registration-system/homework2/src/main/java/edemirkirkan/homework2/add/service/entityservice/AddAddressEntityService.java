package edemirkirkan.homework2.add.service.entityservice;

import edemirkirkan.homework2.add.dao.AddAddressDao;
import edemirkirkan.homework2.add.entity.AddAddress;
import edemirkirkan.homework2.gen.service.entityservice.BaseEntityService;
import org.springframework.stereotype.Service;


@Service
public class AddAddressEntityService extends BaseEntityService<AddAddress, AddAddressDao> {

    public AddAddressEntityService(AddAddressDao addAddressDao) {
        super(addAddressDao);
    }
}
