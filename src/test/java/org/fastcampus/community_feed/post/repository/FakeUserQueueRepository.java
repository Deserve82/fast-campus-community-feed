package org.fastcampus.community_feed.post.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.fastcampus.community_feed.post.repository.entity.post.PostEntity;
import org.fastcampus.community_feed.post.repository.post_queue.UserQueueRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public class FakeUserQueueRepository implements UserQueueRepository {

    private final Map<Long, Set<PostEntity>> queue = new HashMap<>();

    @Override
    public void publishPostToUserQueue(PostEntity postEntity, Long userId) {
        if (queue.containsKey(userId)) {
            queue.get(userId).add(postEntity);
        } else {
            queue.put(userId, new HashSet<>(List.of(postEntity)));
        }
    }

    @Override
    public void deletePostToUserQueue(Long userId, Long targetUserId) {
        if (queue.containsKey(userId)) {
            queue.get(userId).removeIf(post -> post.getAuthor().getId().equals(targetUserId));
        }
    }

    public List<PostEntity> getPostsByUserId(Long userId) {
        return List.copyOf(queue.get(userId));
    }
}
