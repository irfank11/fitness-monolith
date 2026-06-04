package com.project.fitness.Controller;

import com.project.fitness.Service.ActivityService;
import com.project.fitness.dtos.ActivityRequest;
import com.project.fitness.dtos.ActivityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request){
        return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities (@RequestHeader(value = "X-User-ID") String userId){
        return ResponseEntity.ok(activityService.getActivities(userId));
    }
}
