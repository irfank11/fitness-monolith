package com.project.fitness.dtos;

import com.project.fitness.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ActivityRequest {
    private String user_id;
    private ActivityType type;
    private Map<String ,Object> additionalMetrics;
    private  Integer duration;
    private  Integer caloriesBurned;
    private LocalDateTime startTime;
}
