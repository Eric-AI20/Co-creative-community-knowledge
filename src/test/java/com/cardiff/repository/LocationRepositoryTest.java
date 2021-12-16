package com.cardiff.repository;

import com.cardiff.configuration.AuditorAwareImpl;
import com.cardiff.entity.Community;
import com.cardiff.entity.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
class LocationRepositoryTest {
    @Mock
    AuditorAwareImpl auditorAwareMock;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LocationRepository repo;


    @BeforeEach
    void init() {
        Mockito.lenient().when(auditorAwareMock.getCurrentAuditor()).thenReturn(Optional.of("testUser"));

    }

    @Test
    public void testCreateLocation_Success() {
        Location location = new Location();
        location.setName("Tir Coed");
        location.setLatitude(BigDecimal.valueOf(31.764));
        location.setLatitude(BigDecimal.valueOf(31.764));
        Location savedLocation = repo.save(location);
        Location existingLocation = entityManager.find(Location.class, savedLocation.getId());
        assertThat(existingLocation.getName()).isEqualTo(savedLocation.getName());
        repo.delete(existingLocation);
    }

    @Test
    public void testCreateLocation_Failure() {
        Location location = new Location();
        location.setLatitude(BigDecimal.valueOf(31.764));
        location.setLatitude(BigDecimal.valueOf(31.764));

        //since the required parameter name is missing the location will not be saved and null will be returned
        Location savedLocation = repo.save(location);
        assertNull(savedLocation);

    }

}