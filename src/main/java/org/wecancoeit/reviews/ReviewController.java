package org.wecancoeit.reviews;

import org.springframework.stereotype.Controller;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


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
}
