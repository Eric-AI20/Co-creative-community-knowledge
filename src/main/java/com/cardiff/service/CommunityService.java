package com.cardiff.service;

import com.cardiff.entity.Community;
import com.cardiff.repository.CommunityRepository;
import com.cardiff.service.iface.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService implements ICommunityService {

    private CommunityRepository communityRepository;

    @Autowired
    public void setCommunityRepository(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public Community getCommunityById(Long id) {
        return communityRepository.getById(id);
    }

    @Override
    public List<Community> getAllCommunitiesForNavigation() {
        return communityRepository.findAll();

    }

    @Override
    public Community createCommunity(Community community) {
        return communityRepository.save(community);
    }

}

