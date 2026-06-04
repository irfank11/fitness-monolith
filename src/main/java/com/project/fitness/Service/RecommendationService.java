package com.project.fitness.Service;

import com.project.fitness.Repository.ActivityRepository;
import com.project.fitness.Repository.RecommendationRepository;
import com.project.fitness.Repository.UserRepository;
import com.project.fitness.dtos.RecommendationRequest;
import com.project.fitness.dtos.RecommendationResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    public RecommendationResponse generateRecom(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserID()).orElseThrow(() -> new RuntimeException("Invalid user : "+request.getUserID()));
        Activity activity = activityRepository.findById(request.getActivityID()).orElseThrow(() -> new RuntimeException("Invalid activity : "+request.getActivityID()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .type(request.getType())
                .recommendation(request.getRecommendation())
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();

        Recommendation savedRecommendation = recommendationRepository.save(recommendation);

        return mapToResponse(savedRecommendation);
    }

    private RecommendationResponse mapToResponse(Recommendation savedRecommendation) {
        RecommendationResponse response = new RecommendationResponse();
        response.setId(savedRecommendation.getId());
        response.setType(savedRecommendation.getType());
        response.setSafety(savedRecommendation.getSafety());
        response.setRecommendation(savedRecommendation.getRecommendation());
        response.setImprovements(savedRecommendation.getImprovements());
        response.setSuggestions(savedRecommendation.getSuggestions());
        response.setCreatedTime(savedRecommendation.getCreatedTime());
        response.setUpdatedAt(savedRecommendation.getUpdatedAt());
        response.setUserID(savedRecommendation.getUser().getId());
        response.setActivityID(savedRecommendation.getActivity().getId());

        return response;
    }

    public List<RecommendationResponse>getUserRecommendation(String user_id){
        List<Recommendation> recommendations = recommendationRepository.findByUser_Id(user_id);

        return recommendations.stream()
                .map(this :: mapToResponse)
                .collect(Collectors.toList());
    }

    public List<RecommendationResponse> getActivityRecommendation(String activityId){
        List<Recommendation> recommendations = recommendationRepository.findByActivity_Id(activityId);

        return recommendations.stream()
                .map(this :: mapToResponse)
                .collect(Collectors.toList());
    }
}
