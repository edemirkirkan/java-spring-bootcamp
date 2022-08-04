package com.mobileactionbootcamp.homework1.customer.controller;

import com.mobileactionbootcamp.homework1.customer.dao.CustomerDao;
import com.mobileactionbootcamp.homework1.customer.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerDao customerDao;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = customerDao.findAll();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerDao.findById(id).orElseThrow();
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        customer = customerDao.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        if (!customerDao.existsById(customer.getId())) {
            throw new RuntimeException("Customer not found");
        }
        customer = customerDao.save(customer);
        return ResponseEntity.ok(customer);
    }

    @PatchMapping("/passive/{id}")
    public ResponseEntity<Customer> makeCustomerPassive(@PathVariable Long id) {
        Customer customer = customerDao.findById(id).orElseThrow();
        customer.setStatus(Boolean.FALSE);
        customer = customerDao.save(customer);
        return ResponseEntity.ok(customer);
    }
}
