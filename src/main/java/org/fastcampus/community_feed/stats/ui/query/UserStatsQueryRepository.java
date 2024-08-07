package org.fastcampus.community_feed.stats.ui.query;

import java.util.List;

public interface UserStatsQueryRepository {
    List<DailyRegisterUserResponse> getDailyRegisterUserStats(int beforeDays);
}
