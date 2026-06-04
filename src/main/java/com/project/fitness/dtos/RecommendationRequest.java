package com.project.fitness.dtos;

import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationRequest {
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
    private String userID;
    private String activityID;
}
