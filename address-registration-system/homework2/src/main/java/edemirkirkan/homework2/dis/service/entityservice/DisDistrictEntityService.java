package edemirkirkan.homework2.dis.service.entityservice;

import edemirkirkan.homework2.dis.dao.DisDistrictDao;
import edemirkirkan.homework2.dis.entity.DisDistrict;
import edemirkirkan.homework2.gen.service.entityservice.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class DisDistrictEntityService extends BaseEntityService<DisDistrict, DisDistrictDao> {

    public DisDistrictEntityService(DisDistrictDao disDistrictDao) {
        super(disDistrictDao);
    }
}
