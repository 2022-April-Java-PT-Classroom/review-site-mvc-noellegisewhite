package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Collection;

@WebMvcTest(ReviewController.class)
public class ReviewControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewRepository reviewRepo;

    @Mock
    private Review reviewA;

    @Mock
    private Review reviewB;

    @Test
    public void willReturnOkForAllReviews() throws Exception {
        mockMvc.perform(get("/all-reviews")).andExpect(status().isOk())
                .andExpect(view().name("all-reviews-template"));
    }

    @Test
    public void willReturnAllCourses() throws Exception {
        Collection<Review> allReviews = Arrays.asList(reviewA, reviewB);
        when(reviewRepo.findAllReviews()).thenReturn(allReviews);
        mockMvc.perform(get("/all-reviews"))
                .andExpect(model().attribute("allReviewsModel", allReviews));
    }

    @Test
    public void willReturnOkForSingleReviewOne() throws Exception {
        mockMvc.perform(get("/single-review/1")).andExpect(status().isOk())
                .andExpect(view().name("single-review-template"));
    }

    @Test
    public void willReturnReviewA() throws Exception {
        Long reviewAId = 1L;
        when(reviewRepo.findOneReview(reviewAId)).thenReturn(reviewA);
        mockMvc.perform(get("/single-review/1"))
                .andExpect(model().attribute("singleReviewModel", reviewA));
    }
}
