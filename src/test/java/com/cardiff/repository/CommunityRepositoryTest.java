package com.cardiff.repository;

import com.cardiff.entity.Community;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
class CommunityRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CommunityRepository repo;

    @Test
    public void testCreateCommunity() {
        Community community = new Community();
        community.setName("Tir Coed");
        community.setDescription("Tir coed connects people with land (tir) and woods (coed) by delivering outdoor training, learning and wellbeing programmes across carmarthenshire, ceredigion, pembrokeshire and powys.");
        community.setAboutUs("About us");
        Community savedCommunity = repo.save(community);
        Community existingCommunity = entityManager.find(Community.class, savedCommunity.getId());
        assertThat(existingCommunity.getName()).isEqualTo(existingCommunity.getName());
        repo.delete(existingCommunity);
    }

}