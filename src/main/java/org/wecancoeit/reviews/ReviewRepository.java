package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

@Repository
public class ReviewRepository {

    // Map
    Map<Long, Review> reviewList = new HashMap<>();

    // Constructor + Populator
    public ReviewRepository() {
        Review reviewOne = new Review(1L, "title 1", "image 1", "lorem ipsum lorem 1", "category 1");
        Review reviewTwo = new Review(2L, "title 2", "image 2", "lorem ipsum lorem 2", "category 2");
        Review reviewThree = new Review(3L, "title 3", "image 3", "lorem ipsum lorem 3", "category 3");

        reviewList.put(reviewOne.getId(), reviewOne);
        reviewList.put(reviewTwo.getId(), reviewTwo);
        reviewList.put(reviewThree.getId(), reviewThree);
    }

    // Constructor + Method + Var(args)
    public ReviewRepository(Review...reviewToAdd) {
        for (Review reviewIndex : reviewToAdd) {
            reviewList.put(reviewIndex.getId(), reviewIndex);
        }
    }

    // Methods
    public Review findOneReview(long reviewIdToFind) {
        return reviewList.get(reviewIdToFind);
    }

    public Collection<Review> findAllReviews() {
        return reviewList.values();
    }
}
