package org.fastcampus.community_feed.user.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class UserRelationCountTest {

    @Test
    void givenCreatedWhenIncreaseThenCountIsOne() {
        // given
        UserRelationCount count = new UserRelationCount();

        // when
        count.increaseCount();

        // then
        assertEquals(1, count.getCount());
    }

    @Test
    void givenCreatedAndLikedWhenDecreaseThenCountIsOne() {
        // given
        UserRelationCount count = new UserRelationCount();
        count.increaseCount();

        // when
        count.decreaseCount();

        // then
        assertEquals(0, count.getCount());
    }

    @Test
    void givenCreatedWhenUnlikeThenCountIsZero() {
        // given
        UserRelationCount count = new UserRelationCount();

        // when
        count.decreaseCount();

        // then
        assertEquals(0, count.getCount());
    }

}
