package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import org.wecancoeit.reviews.repository.HashtagsRepository;


@Controller
public class HashtagController {

    @Resource
    private HashtagsRepository hashtagRepo;

    @RequestMapping("/add-hashtags")
    public String displayAllHashtags(Model model) {
        model.addAttribute("allHashtags", hashtagRepo.findAllHashtags());
        return ("redirect:/");
    }
}
