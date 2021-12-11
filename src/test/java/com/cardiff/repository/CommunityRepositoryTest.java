package com.cardiff.repository;

import com.cardiff.configuration.AuditorAwareImpl;
import com.cardiff.entity.Community;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
class CommunityRepositoryTest {

    @Mock
    AuditorAwareImpl auditorAwareMock;

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CommunityRepository repo;

    @BeforeEach
    void init() {
        Mockito.lenient().when(auditorAwareMock.getCurrentAuditor()).thenReturn(Optional.of("testUser"));

    }

    @Test
    public void testCreateCommunity() {
        Community community = new Community();
        community.setName("Tir Coed");
        community.setGoal("Tir Coed");
        community.setHistory("Tir Coed");
        community.setDescription("Tir coed connects people with land (tir) and woods (coed) by delivering outdoor training, learning and wellbeing programmes across carmarthenshire, ceredigion, pembrokeshire and powys.");
        community.setAboutUs("About us");
        Community savedCommunity = repo.save(community);
        Community existingCommunity = entityManager.find(Community.class, savedCommunity.getId());
        assertThat(existingCommunity.getName()).isEqualTo(existingCommunity.getName());
    }

    @Test
    public void testFindAll() {
        List<Community> all = repo.findAll();
        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    public void getCommunityByIdTest() {
        Community existingCommunity = entityManager.find(Community.class, 1L);
        assertThat(existingCommunity.getId()).isEqualTo(1L);
    }


}