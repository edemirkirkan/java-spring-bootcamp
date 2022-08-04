package com.mobileactionbootcamp.homework1.customer.dao;

import com.mobileactionbootcamp.homework1.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
