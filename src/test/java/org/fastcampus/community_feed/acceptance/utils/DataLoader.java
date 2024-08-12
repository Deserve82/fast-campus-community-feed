package org.fastcampus.community_feed.acceptance.utils;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoader {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void loadData() {
        // user 1, 2, 3 생성
        for (int i = 0; i < 3; i++) {
            entityManager
                    .createNativeQuery("insert into community_user (name, profile_image, follower_count, following_count, reg_dt, upd_dt) values ('test', '', 0, 0, now(), now())")
                    .executeUpdate();
        }
    }

    public String getEmailToken(String email) {
        return entityManager.createQuery("SELECT token FROM EmailVerificationEntity WHERE email = :email", String.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public boolean isEmailVerified(String email) {
        return entityManager.createQuery("SELECT isVerified FROM EmailVerificationEntity WHERE email = :email", Boolean.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public Long getUserId(String email) {
        return entityManager.createQuery("SELECT userId FROM UserAuthEntity WHERE email = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}