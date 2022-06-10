package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import org.wecancoeit.reviews.model.Hashtags;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.repository.HashtagsRepository;
import org.wecancoeit.reviews.repository.ReviewRepository;

import java.util.Collection;

@Controller
public class HomeController {

    @Resource
    private ReviewRepository reviewRepo;

    @Resource
    private HashtagsRepository hashtagRepo;

//    @GetMapping("/")
//    public String displayHomePage(Model model) {
//        model.addAttribute("review", reviewRepo.findAllReviews());
//        return ("home-template");
//    }

    @GetMapping("/tags/{hashId}")
    public String displayOneHashtag(@PathVariable Long hashId, Model model) {
        model.addAttribute("singleTag", hashtagRepo.findOneHashtag(hashId));
        return ("home-template");
    }

    @GetMapping("/")
    public String displayAllHashtags(Model model) {
        model.addAttribute("allTags", hashtagRepo.findAllHashtags());
        return ("home-template");
    }

    @PostMapping("/addReview")
    public String addReview(@RequestParam Long id, @RequestParam String title, @RequestParam String imgURL, @RequestParam String content, @RequestParam String category, Model model) {
        Long updateId = (id+6);
        Review reviewToAdd = new Review(updateId, title, imgURL, content, category);
        reviewRepo.addReview(reviewToAdd);
        model.addAttribute("oneReview", reviewToAdd);
        model.addAttribute("addAllTags", hashtagRepo.findAllHashtags());
        return ("redirect:/all-reviews");
    }
}
