package org.fastcampus.community_feed.common.utils;

import java.time.LocalDate;

public class TimeCalculator {
    public static LocalDate getDateDaysAgo(int daysAgo) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.minusDays(daysAgo);
    }

}
