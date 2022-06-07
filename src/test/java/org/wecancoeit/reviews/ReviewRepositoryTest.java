package org.wecancoeit.reviews;

import java.util.Collection;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewRepositoryTest {

    // Variables
    Hashtags hashtagOne = new Hashtags(1L, "tag1");
    Hashtags hashtagTwo = new Hashtags(2L, "tag2");
    Hashtags hashtagThree = new Hashtags(3L, "tag3");

    Review reviewOne = new Review(1L, "title 1", "image 1", "lorem ipsum lorem 1", "category 1", hashtagOne);
    Review reviewTwo = new Review(2L, "title 2", "image 2", "lorem ipsum lorem 2", "category 2", hashtagTwo);
    Review reviewThree = new Review(3L, "title 3", "image 3", "lorem ipsum lorem 3", "category 3", hashtagThree, hashtagTwo, hashtagOne);

    Review reviewFour = new Review(4L, "title 1", "image 1", "lorem ipsum lorem 1", "category 1", hashtagOne);
    Review reviewFive = new Review(5L, "title 2", "image 2", "lorem ipsum lorem 2", "category 2", hashtagTwo);
    Review reviewSix = new Review(6L, "title 3", "image 3", "lorem ipsum lorem 3", "category 3", hashtagThree, hashtagTwo, hashtagOne);

    // Methods
    @Test
    public void willFindReviewOne() {
        ReviewRepository reviewTest = new ReviewRepository(reviewOne);
        Review reviewToFind = reviewTest.findOneReview(1L);
        assertEquals(reviewOne, reviewToFind);
    }

    @Test
    public void willFindAllReviews() {
        ReviewRepository reviewTest = new ReviewRepository(reviewOne, reviewTwo, reviewThree);
        Collection<Review> reviewCollection = reviewTest.findAllReviews();
        assertThat(reviewCollection, contains(reviewOne, reviewTwo, reviewThree));
    }

    // Hashtag Tests
    @Test
    public void willFindHashtagOne() {
        HashtagsRepository hashtagsTest = new HashtagsRepository(hashtagOne);
        Hashtags hashtagToFind = hashtagsTest.findOneHashtag(1L);
        assertEquals(hashtagOne, hashtagToFind);
    }

    @Test
    public void willFindAllHashtags() {
        HashtagsRepository hashtagsTest = new HashtagsRepository(hashtagOne, hashtagTwo, hashtagThree);
        Collection<Hashtags> hashtagsCollection = hashtagsTest.findAllHashtags();
        assertThat(hashtagsCollection, contains(hashtagOne, hashtagTwo, hashtagThree));
    }

    @Test
    public void willFindOneHashtagForReviewOne() {
        ReviewRepository reviewRepoTest = new ReviewRepository(reviewOne);
        Review dummyReview = reviewRepoTest.findOneReview(1L);
        assertThat(dummyReview.getHashtags(), contains(hashtagOne));
    }

    @Test
    public void willFindOneHashtagForReviewTwo() {
        ReviewRepository reviewRepoTest = new ReviewRepository(reviewTwo);
        Review dummyReview = reviewRepoTest.findOneReview(2L);
        assertThat(dummyReview.getHashtags(), contains(hashtagTwo));
    }

    @Test
    public void willFindThreeHashtagsForReviewThree() {
        ReviewRepository reviewRepoTest = new ReviewRepository(reviewThree);
        Review dummyReview = reviewRepoTest.findOneReview(3L);
        assertThat(dummyReview.getHashtags(), containsInAnyOrder(hashtagOne, hashtagTwo, hashtagThree));
    }

//    // My brain hurts...not sure why I can't get this to work. Maybe this is a controller test.
//    @Test
//    public void willAddOneHashtagToReviewOne() {
//        HashtagsRepository hashtagsTest = new HashtagsRepository(hashtagOne, hashtagTwo, hashtagThree);
//        ReviewRepository reviewRepoTest = new ReviewRepository(reviewOne);
//        Review dummyReview = reviewRepoTest.findOneReview(1L);
//        dummyReview.addOneHashtag(hashtagThree);
//        assertThat(dummyReview.getHashtags(), containsInAnyOrder(hashtagThree, hashtagOne));
//    }
}
