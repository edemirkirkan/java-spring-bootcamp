package com.edemirkirkan.homework3.veh.dao;

import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import com.edemirkirkan.homework3.veh.entity.VehVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehVehicleDao extends JpaRepository<VehVehicle, Long> {
    List<VehVehicle> findAllByBrandAndModelAndCusCustomer(String brand, String model, CusCustomer cusCustomer);
    List<VehVehicle> findAllByCusCustomer(CusCustomer cusCustomer);
}
