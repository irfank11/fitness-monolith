package com.project.fitness.Controller;

import com.project.fitness.Service.RecommendationService;
import com.project.fitness.dtos.RecommendationRequest;
import com.project.fitness.dtos.RecommendationResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
//@NoArgsConstructor
//@AllArgsConstructor
public class RecommendationController {
    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<RecommendationResponse> generateRecommendation(@RequestBody RecommendationRequest request){
        return ResponseEntity.ok(recommendationService.generateRecom(request));
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<RecommendationResponse>> getUserRecommendation(@PathVariable String user_id){
        return ResponseEntity.ok(recommendationService.getUserRecommendation(user_id));
    }

    @GetMapping("/activity/{activity_id}")
    public ResponseEntity<List<RecommendationResponse>> getActivityRecommendation(@PathVariable String activity_id){
        return ResponseEntity.ok(recommendationService.getActivityRecommendation(activity_id));
    }
}
