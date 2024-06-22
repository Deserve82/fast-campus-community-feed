package org.fastcampus.community_feed.user.repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.fastcampus.community_feed.user.application.interfaces.UserRelationRepository;
import org.fastcampus.community_feed.user.domain.User;

public class FakeUserRelationRepository implements UserRelationRepository {

    private final Set<Relation> store = new HashSet<>();


    @Override
    public boolean isAlreadyFollow(User user, User targetUser) {
        return store.contains(new Relation(user.getId(), targetUser.getId()));
    }

    @Override
    public void save(User user, User targetUser) {
        store.add(new Relation(user.getId(), targetUser.getId()));
    }

    @Override
    public void delete(User user, User targetUser) {
        store.remove(new Relation(user.getId(), targetUser.getId()));
    }
}

class Relation {
    private final Long userId;
    private final Long targetUserId;

    public Relation(Long userId, Long targetUserId) {
        this.userId = userId;
        this.targetUserId = targetUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Relation relation = (Relation) o;
        return Objects.equals(userId, relation.userId) && Objects.equals(
                targetUserId, relation.targetUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, targetUserId);
    }
}