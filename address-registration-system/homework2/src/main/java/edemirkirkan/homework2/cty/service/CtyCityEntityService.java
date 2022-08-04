package edemirkirkan.homework2.cty.service;

import edemirkirkan.homework2.cty.dao.CtyCityDao;
import edemirkirkan.homework2.cty.entity.CtyCity;
import edemirkirkan.homework2.gen.service.entityservice.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CtyCityEntityService extends BaseEntityService<CtyCity, CtyCityDao> {

    public CtyCityEntityService(CtyCityDao ctyCityDao) {
        super(ctyCityDao);
    }

    public CtyCity findByCode(String code) {
        return getDao().findByCode(code);
    }
}
