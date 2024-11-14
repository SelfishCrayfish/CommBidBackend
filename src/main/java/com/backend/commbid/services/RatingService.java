package com.backend.commbid.services;

import com.backend.commbid.models.Rating;
import com.backend.commbid.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> findById(Long id) {
        return ratingRepository.findById(id);
    }

    public List<Rating> findByRatedUserId(Long ratedUserId) {
        return ratingRepository.findByRatedUserId(ratedUserId);
    }

    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    public void deleteById(Long id) {
        ratingRepository.deleteById(id);
    }
}
