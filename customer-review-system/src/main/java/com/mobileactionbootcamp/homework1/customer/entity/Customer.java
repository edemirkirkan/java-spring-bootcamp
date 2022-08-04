package com.mobileactionbootcamp.homework1.customer.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
    @GeneratedValue(generator = "Customer")
    private Long id;
    @Column(name="FIRST_NAME", length = 50, nullable = false)
    private String firstName;
    @Column(name="LAST_NAME", length = 50, nullable = false)
    private String lastName;
    @Column(name="EMAIL", length = 50, nullable = false)
    private String email;
    @Column(name="CONTACT_NUMBER", length = 15, nullable = false)
    private String contactNumber;
    @Column(name="BIRTH_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name="STATUS", nullable = false)
    private Boolean status;
}
