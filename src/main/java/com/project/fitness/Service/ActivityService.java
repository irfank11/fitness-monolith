package com.project.fitness.Service;

import com.project.fitness.Repository.ActivityRepository;
import com.project.fitness.Repository.UserRepository;
import com.project.fitness.dtos.ActivityRequest;
import com.project.fitness.dtos.ActivityResponse;
import com.project.fitness.dtos.UserResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    public ActivityResponse trackActivity(ActivityRequest request) {
        User user = userRepository.findById(request.getUser_id()).orElseThrow(() -> new RuntimeException("Invalid user : "+request.getUser_id()));

        Activity activity = Activity.builder()
                .user(user)
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity savedActivity = activityRepository.save(activity);

        return mapToResponse(savedActivity);

    }

    private ActivityResponse mapToResponse(Activity savedActivity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(savedActivity.getId());
        response.setType(savedActivity.getType());
        response.setDuration(savedActivity.getDuration());
        response.setUser_id(savedActivity.getUser().getId());
        response.setCaloriesBurned(savedActivity.getCaloriesBurned());
        response.setAdditionalMetrics(savedActivity.getAdditionalMetrics());
        response.setCreatedTime(savedActivity.getCreatedTime());
        response.setStartTime(savedActivity.getStartTime());
        response.setUpdatedAt(savedActivity.getUpdatedAt());

        return response;
    }

    public List<ActivityResponse> getActivities(String userId) {
        List<Activity> activityList = activityRepository.findByUserId(userId);

        return activityList.stream()
                .map(this :: mapToResponse)
                .collect(Collectors.toList());
    }
}
