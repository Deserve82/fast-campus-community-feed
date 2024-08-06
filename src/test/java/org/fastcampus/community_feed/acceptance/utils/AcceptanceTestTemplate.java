package org.fastcampus.community_feed.acceptance.utils;

import static org.fastcampus.community_feed.acceptance.post.UserAcceptanceSteps.followUser;

import org.fastcampus.community_feed.user.application.dto.FollowUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AcceptanceTestTemplate {

    @Autowired
    private DatabaseCleanup databaseCleanup;
    @Autowired
    private DataLoader dataLoader;

    public void setUp() {
        databaseCleanup.execute();
        dataLoader.loadData();

        followUser(new FollowUserRequestDto(1L, 2L));
        followUser(new FollowUserRequestDto(2L, 3L));
    }

    public void cleanUp() {
        databaseCleanup.execute();
    }

}
