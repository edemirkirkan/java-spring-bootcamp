package com.edemirkirkan.homework3.veh.service.entityservice;

import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import com.edemirkirkan.homework3.gen.service.BaseEntityService;
import com.edemirkirkan.homework3.veh.dao.VehVehicleDao;
import com.edemirkirkan.homework3.veh.entity.VehVehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehVehicleEntityService extends BaseEntityService<VehVehicle, VehVehicleDao> {
    public VehVehicleEntityService(VehVehicleDao dao) {
        super(dao);
    }

    public List<VehVehicle> findAllByBrandAndModel(String brand, String model, CusCustomer cusCustomer) {
        return getDao().findAllByBrandAndModelAndCusCustomer(brand, model, cusCustomer);
    }

    public List<VehVehicle> findAllByCusCustomer(CusCustomer cusCustomer) {
        return getDao().findAllByCusCustomer(cusCustomer);
    }


}
