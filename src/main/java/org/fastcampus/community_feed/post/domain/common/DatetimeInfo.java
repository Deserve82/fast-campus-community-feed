package org.fastcampus.community_feed.post.domain.common;

import java.time.LocalDateTime;

public class DatetimeInfo {
  private boolean isEdited;
  private LocalDateTime dateTime;

  public DatetimeInfo() {
    this.isEdited = false;
    this.dateTime = LocalDateTime.now();
  }

  public void updateEditDatetime() {
    this.isEdited = true;
    this.dateTime = LocalDateTime.now();
  }
}
