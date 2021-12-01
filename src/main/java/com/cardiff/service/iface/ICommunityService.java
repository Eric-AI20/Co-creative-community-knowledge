package com.cardiff.service.iface;

import com.cardiff.entity.Community;

import java.util.List;

public interface ICommunityService {
    Community getCommunityById(Long id);

    Community createCommunity(Community community);
}
