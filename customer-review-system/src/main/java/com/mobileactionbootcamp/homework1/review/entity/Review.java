package com.mobileactionbootcamp.homework1.review.entity;

import com.mobileactionbootcamp.homework1.customer.entity.Customer;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "REVIEW")
public class Review {
    @Id
    @SequenceGenerator(name = "Review", sequenceName = "REVIEW_ID_SEQ")
    @GeneratedValue(generator = "Review")
    private Long id;

    @Column(name="COMMENT", length = 500, nullable = false)
    private String comment;

    @Column(name="CREATED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name="PRODUCT_ID", nullable = false)
    private Long productId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
}