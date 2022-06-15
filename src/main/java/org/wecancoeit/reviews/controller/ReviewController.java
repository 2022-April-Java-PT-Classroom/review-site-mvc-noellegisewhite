package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import org.wecancoeit.reviews.repository.ReviewRepository;

@Controller
public class ReviewController {

    @Resource
    private ReviewRepository reviewRepo;

    @RequestMapping("/all-reviews")
    public String displayAllReviews(Model model) {
        model.addAttribute("allReviewsModel", reviewRepo.findAllReviews());
        return ("all-reviews-template");
    }

    @RequestMapping("/single-review/{id}")
    public String displaySingleReview(@PathVariable Long id, Model model) {
        model.addAttribute("singleReviewModel", reviewRepo.findOneReview(id));
        return ("single-review-template");
    }

    @PostMapping("/delete-review")
    public String deleteReview(@RequestParam Long id) {
        reviewRepo.removeReview(id);
        return ("redirect:/all-reviews");
    }
}
