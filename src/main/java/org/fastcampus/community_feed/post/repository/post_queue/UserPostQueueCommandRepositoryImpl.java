package org.fastcampus.community_feed.post.repository.post_queue;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.fastcampus.community_feed.post.domain.Post;
import org.fastcampus.community_feed.post.repository.entity.post.PostEntity;
import org.fastcampus.community_feed.post.repository.jpa.JpaPostRepository;
import org.fastcampus.community_feed.user.repository.entity.UserEntity;
import org.fastcampus.community_feed.user.repository.jpa.JpaUserRelationRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserPostQueueCommandRepositoryImpl implements UserPostQueueCommandRepository {
    private final JpaPostRepository jpaPostRepository;
    private final JpaUserRelationRepository jpaUserRelationRepository;
    private final UserQueueRepository queueRepository;

    public void publishPost(PostEntity postEntity) {
        UserEntity authorEntity = postEntity.getAuthor();
        List<Long> followers = jpaUserRelationRepository.findFollowers(authorEntity.getId());
        followers.forEach(userId -> queueRepository.publishPostToUserQueue(postEntity, userId));
    }

    public void saveFollowPost(Long userId, Long targetId) {
        List<PostEntity> postEntities = jpaPostRepository.findAllPostIdsByAuthorId(targetId);
        postEntities.forEach(postEntity -> {
            queueRepository.publishPostToUserQueue(postEntity, userId);
        });
    }

    public void deleteUnfollowPost(Long userId, Long targetId) {
        queueRepository.deletePostToUserQueue(userId, targetId);
    }
}
