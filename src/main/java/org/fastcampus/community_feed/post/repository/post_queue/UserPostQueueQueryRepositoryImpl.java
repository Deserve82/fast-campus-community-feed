package org.fastcampus.community_feed.post.repository.post_queue;

import java.util.List;
import org.fastcampus.community_feed.post.application.dto.GetPostContentResponseDto;
import org.springframework.stereotype.Repository;

@Repository
public class UserPostQueueQueryRepositoryImpl implements UserPostQueueQueryRepository {

    @Override
    public List<GetPostContentResponseDto> getContentResponse(Long userId, Long lastContentId) {
        return List.of();
    }
}
