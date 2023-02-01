package com.example.matzip.controller;


import com.example.matzip.dto.ReviewDTO;
import com.example.matzip.dao.ReviewDAO;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/review")
public class ReviewCtrl {
    @Autowired
    private ReviewDAO reviewDAO;

    @PostMapping("/saveReview")
    public void saveReview(@RequestBody ReviewDTO reviewDTO) {
        String id = reviewDTO.getId();
        System.out.println(id);
        if (id == null) {
            UUID uuid = UUID.randomUUID();
            String uuidStr = uuid.toString();
            System.out.println(uuid);
            reviewDTO.setId(uuidStr);
        }
        reviewDAO.saveReview(reviewDTO);
    }

    @GetMapping("/getReviews")
    public List<ReviewDTO> getReviews() {
        return reviewDAO.getReviews();
    }

    @DeleteMapping("/deleteReview")
    public void deleteReview(@RequestParam(value = "id", required = true) String id){
        reviewDAO.deleteReview(id);
    }
}
