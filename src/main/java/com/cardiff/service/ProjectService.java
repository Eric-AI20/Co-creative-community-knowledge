package com.cardiff.service;

import com.cardiff.entity.Project;
import com.cardiff.repository.ProjectRepository;
import com.cardiff.service.iface.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService {


    private ProjectRepository projectRepository;

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;

    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.getById(id);
    }

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }


}