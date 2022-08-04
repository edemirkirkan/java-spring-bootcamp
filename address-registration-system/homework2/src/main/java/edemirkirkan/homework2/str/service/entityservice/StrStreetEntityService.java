package edemirkirkan.homework2.str.service.entityservice;

import edemirkirkan.homework2.gen.service.entityservice.BaseEntityService;
import edemirkirkan.homework2.str.dao.StrStreetDao;
import edemirkirkan.homework2.str.entity.StrStreet;
import org.springframework.stereotype.Service;

@Service
public class StrStreetEntityService extends BaseEntityService<StrStreet, StrStreetDao> {

    public StrStreetEntityService(StrStreetDao strStreetDao) {
        super(strStreetDao);
    }
}
