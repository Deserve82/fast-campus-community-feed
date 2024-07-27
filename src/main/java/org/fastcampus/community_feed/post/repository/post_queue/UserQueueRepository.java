package org.fastcampus.community_feed.post.repository.post_queue;

import org.fastcampus.community_feed.post.repository.entity.post.PostEntity;

public interface UserQueueRepository {
    void publishPostToUserQueue(PostEntity post, Long userId);
    void deletePostToUserQueue(Long userId, Long targetUserId);
}
