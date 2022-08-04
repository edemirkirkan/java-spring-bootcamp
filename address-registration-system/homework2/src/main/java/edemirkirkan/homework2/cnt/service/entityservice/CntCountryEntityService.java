package edemirkirkan.homework2.cnt.service.entityservice;

import edemirkirkan.homework2.cnt.dao.CntCountryDao;
import edemirkirkan.homework2.cnt.entity.CntCountry;
import edemirkirkan.homework2.gen.service.entityservice.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CntCountryEntityService extends BaseEntityService<CntCountry, CntCountryDao> {

    public CntCountryEntityService(CntCountryDao cntCountryDao) {
        super(cntCountryDao);
    }

    public CntCountry findByCode(String code) {
        return getDao().findByCode(code);
    }
}
