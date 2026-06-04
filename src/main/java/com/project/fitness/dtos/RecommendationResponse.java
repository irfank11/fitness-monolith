package com.project.fitness.dtos;

import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationResponse {
    private String id;

    private String type;
//    @Column(length = 2000)
    private String recommendation;

//    @JdbcTypeCode(SqlTypes.JSON)
//    @Column(columnDefinition = "json")
    private List<String> improvements;
//    @JdbcTypeCode(SqlTypes.JSON)
//    @Column(columnDefinition = "json")
    private List<String> suggestions;
//    @JdbcTypeCode(SqlTypes.JSON)
//    @Column(columnDefinition = "json")
    private List<String> safety;
    private LocalDateTime createdTime;
    private LocalDateTime updatedAt;
    private String userID;
    private String activityID;
}
