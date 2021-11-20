package com.cardiff.service;

import com.cardiff.domain.UserDto;
import com.cardiff.entity.User;
import com.cardiff.exception.UserAlreadyExistException;

public interface IUserService {

    User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException;

}
