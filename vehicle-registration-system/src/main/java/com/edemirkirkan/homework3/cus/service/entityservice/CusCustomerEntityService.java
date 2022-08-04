package com.edemirkirkan.homework3.cus.service.entityservice;

import com.edemirkirkan.homework3.cus.dao.CusCustomerDao;
import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import com.edemirkirkan.homework3.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CusCustomerEntityService extends BaseEntityService<CusCustomer, CusCustomerDao> {

    public CusCustomerEntityService(CusCustomerDao dao) {
        super(dao);
    }

    public CusCustomer findByUsername(String username){
        return getDao().findByUsername(username);
    }
}
