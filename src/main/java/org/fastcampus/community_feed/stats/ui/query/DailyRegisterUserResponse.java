package org.fastcampus.community_feed.stats.ui.query;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyRegisterUserResponse {
    private LocalDate date;
    private Long count;
}
