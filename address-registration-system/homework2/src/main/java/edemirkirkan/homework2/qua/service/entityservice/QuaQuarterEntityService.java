package edemirkirkan.homework2.qua.service.entityservice;

import edemirkirkan.homework2.gen.service.entityservice.BaseEntityService;
import edemirkirkan.homework2.qua.dao.QuaQuarterDao;
import edemirkirkan.homework2.qua.entity.QuaQuarter;
import org.springframework.stereotype.Service;

@Service
public class QuaQuarterEntityService extends BaseEntityService<QuaQuarter, QuaQuarterDao> {

    public QuaQuarterEntityService(QuaQuarterDao quaQuarterDao) {
        super(quaQuarterDao);
    }
}
