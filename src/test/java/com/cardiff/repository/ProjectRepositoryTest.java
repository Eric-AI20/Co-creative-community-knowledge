package com.cardiff.repository;

import com.cardiff.configuration.AuditorAwareImpl;
import com.cardiff.entity.Project;
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
class ProjectRepositoryTest {

    @Mock
    AuditorAwareImpl auditorAwareMock;

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProjectRepository repo;

    @BeforeEach
    void init() {
        Mockito.lenient().when(auditorAwareMock.getCurrentAuditor()).thenReturn(Optional.of("testUser"));

    }

    @Test
    public void testCreateProject(){
        Project project = new Project();
        project.setName("Fire Safety");
        project.setDescription("Fire Safety: Steps, solutions and precautions towards fire hazard casses.");
        project.setObjective("Community Safety");
        project.setAuthor("Timothy");
        project.setAbout("About the Author");
        project.setUrl("Url");
        project.setAddress("Address");
        Project savedProject = repo.save(project);
        Project existingProject = entityManager.find(Project.class, savedProject.getId());
        assertThat(existingProject.getName()).isEqualTo(existingProject.getName());
    }

    @Test
    public void testFindAll() {
        List<Project> all = repo.findAll();
        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    public void getProjectByIdTest() {
        Project existingProject = entityManager.find(Project.class, 1L);
        assertThat(existingProject.getId()).isEqualTo(1L);
    }


}