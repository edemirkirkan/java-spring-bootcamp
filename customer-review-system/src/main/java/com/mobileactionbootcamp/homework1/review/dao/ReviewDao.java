package com.mobileactionbootcamp.homework1.review.dao;

import com.mobileactionbootcamp.homework1.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDao extends JpaRepository<Review, Long> {

}
