package com.mobileactionbootcamp.homework1.review.controller;

import com.mobileactionbootcamp.homework1.review.dao.ReviewDao;
import com.mobileactionbootcamp.homework1.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewDao reviewDao;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviewList = reviewDao.findAll();
        return ResponseEntity.ok(reviewList);
    }

    @PostMapping
    public ResponseEntity<Review> saveReview(@RequestBody Review review) {
        review = reviewDao.save(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        if (id == null) {
            throw new RuntimeException("Review not found with id: " + id);
        }
        reviewDao.deleteById(id);
    }

    @PatchMapping("/update/{id}/{newComment}")
    public ResponseEntity<Review> updateReviewComment(@PathVariable Long id, @PathVariable String newComment) {
        Review review = reviewDao.findById(id).orElseThrow();
        review.setComment(newComment);
        review = reviewDao.save(review);
        return ResponseEntity.ok(review);
    }

}
