package com.edemirkirkan.homework3.cus.dao;

import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CusCustomerDao extends JpaRepository<CusCustomer, Long> {
    CusCustomer findByUsername(String username);


}
