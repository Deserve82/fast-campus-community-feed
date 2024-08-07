package org.fastcampus.community_feed.common.ui;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.fastcampus.community_feed.stats.ui.query.DailyRegisterUserResponse;
import org.fastcampus.community_feed.stats.ui.query.UserStatsQueryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class HealthcheckController {

  private final UserStatsQueryRepository userStatsQueryRepository;

  @GetMapping
  public String healthcheck() {
    return "OK";
  }


  //메인 페이지
  @GetMapping("/index")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");

    List<DailyRegisterUserResponse> result = userStatsQueryRepository.getDailyRegisterUserStats(7);
    modelAndView.addObject("result", result);
    return modelAndView;
  }
}
