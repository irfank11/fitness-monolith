package com.project.fitness.dtos;

import com.project.fitness.model.ActivityType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityResponse {
    private String id;
    private String user_id;
    private ActivityType type;
    private Map<String,Object> additionalMetrics;
    private  Integer duration;
    private  Integer caloriesBurned;
    private LocalDateTime startTime;
    private LocalDateTime createdTime;
    private LocalDateTime updatedAt;
}
