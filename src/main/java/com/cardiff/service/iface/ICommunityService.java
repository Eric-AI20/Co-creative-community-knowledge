package com.cardiff.service.iface;

import com.cardiff.entity.Community;
import com.cardiff.exception.UserAlreadyExistException;


public interface ICommunityService {
        Community createCommunity(Community community) throws UserAlreadyExistException;
        Community getCommunityById(Long id);
}
