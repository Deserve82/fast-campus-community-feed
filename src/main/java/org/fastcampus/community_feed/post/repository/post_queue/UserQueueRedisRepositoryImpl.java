package org.fastcampus.community_feed.post.repository.post_queue;

import java.util.List;
import org.fastcampus.community_feed.post.repository.entity.post.PostEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserQueueRedisRepositoryImpl implements UserQueueRedisRepository {


    @Override
    public void publishPostToUserListQueue(PostEntity post, List<Long> userIdList) {

    }

    @Override
    public void publishPostListToUserQueue(List<PostEntity> postEntities, Long userId) {

    }

    @Override
    public void deletePostToUserQueue(Long userId, Long targetUserId) {

    }
}
