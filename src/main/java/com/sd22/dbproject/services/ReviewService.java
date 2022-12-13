package com.sd22.dbproject.services;

import com.sd22.dbproject.entities.Review;
import com.sd22.dbproject.repositories.ReviewRepository;
import com.sd22.dbproject.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviews() {
        List<Review> reviews = new ArrayList<>();
        reviewRepository.findAll().forEach(reviews::add);
        return reviews;
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review findReviewById(int id) {
        return reviewRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteReviewById(int id) {
        reviewRepository.deleteById(id);
    }

    public Review updateReview(Review review){
        return reviewRepository.save(review);
    }
}
