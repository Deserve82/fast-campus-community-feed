package org.fastcampus.community_feed.user.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.fastcampus.community_feed.common.FakeObjectFactory;
import org.fastcampus.community_feed.user.application.dto.CreateUserRequestDto;
import org.fastcampus.community_feed.user.domain.User;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    private final UserService userService = FakeObjectFactory.getUserService();

    @Test
    void givenUserInfoDtoWhenCreateUserThenCanFindUser() {
        // given
        CreateUserRequestDto dto = new CreateUserRequestDto("John", "www.naver.com");

        // when
        userService.createUser(dto);

        // then
        User user = userService.getUser(1L);
        assertEquals(1L, user.getId());
    }
}
