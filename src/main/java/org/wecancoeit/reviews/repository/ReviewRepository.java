package org.wecancoeit.reviews.repository;

import org.springframework.stereotype.Repository;
import org.wecancoeit.reviews.model.Review;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

@Repository
public class ReviewRepository {

    // Map
    Map<Long, Review> reviewList = new HashMap<>();

    // Constructor
    public ReviewRepository() {
    }

    // Constructor + Method + Var(args)
    public ReviewRepository(Review...reviewToAdd) {
        for (Review reviewIndex : reviewToAdd) {
            reviewList.put(reviewIndex.getId(), reviewIndex);
        }
    }

    // Methods
    public Review findOneReview(Long reviewIdToFind) {
        return reviewList.get(reviewIdToFind);
    }

    public Collection<Review> findAllReviews() {
        return reviewList.values();
    }

    public void addReview(Review reviewToAdd) {
        reviewList.put(reviewToAdd.getId(), reviewToAdd);
    }

    public void bulkAddReview(Review...reviewToAdd) {
        for (Review reviewIndex : reviewToAdd) {
            reviewList.put(reviewIndex.getId(), reviewIndex);
        }
    }

    public void removeReview(Long reviewToRemove) {
        reviewList.remove(reviewToRemove);
    }
}
