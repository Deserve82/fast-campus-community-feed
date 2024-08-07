package org.fastcampus.community_feed.stats.ui;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.fastcampus.community_feed.common.ui.Response;
import org.fastcampus.community_feed.stats.ui.query.DailyRegisterUserResponse;
import org.fastcampus.community_feed.stats.ui.query.UserStatsQueryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
public class UserStatsController {

    private final UserStatsQueryRepository userStatsQueryRepository;

    @GetMapping("/daily-register")
    public Response<List<DailyRegisterUserResponse>> getDailyRegisterUserStats(int beforeDays) {
        return Response.ok(userStatsQueryRepository.getDailyRegisterUserStats(beforeDays));
    }
}
