package com.example.matzip.controller;


import com.example.matzip.dto.ReviewDTO;
import com.example.matzip.dao.ReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/review")
public class ReviewCtrl {
    @Autowired
    private ReviewDAO reviewDAO;

    @PostMapping("/saveReview")
    public void saveReview(@RequestBody ReviewDTO reviewDTO) {
        String id = UUID.randomUUID().toString();
        reviewDTO.setId(id);
        reviewDAO.saveReview(reviewDTO);
    }
}
