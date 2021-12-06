package com.cardiff.service;

import com.cardiff.domain.UserDto;
import com.cardiff.entity.CaseStudy;
import com.cardiff.entity.User;
import com.cardiff.exception.UserAlreadyExistException;
import com.cardiff.repository.CaseStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/*
    display the case study in the url
 */
@Service
public class CaseStudyService {
    private CaseStudyRepository caseStudyRepository;

    public CaseStudyService(CaseStudyRepository caseStudyRepository) {
        this.caseStudyRepository = caseStudyRepository;
    }

    public CaseStudy findById(Long id){
        return caseStudyRepository.findById(id).get();
    }

    public CaseStudy saveCaseStudy(CaseStudy casestudy)  {
        return caseStudyRepository.save(casestudy);
    }

//    private User createUserFromDto(UserDto casestudy) {
//        User user = new User();
//        user.setEmail(casestudy.getEmail());
//        user.setFirstName(casestudy.getFirstName());
//        user.setLastName(casestudy.getLastName());
//        user.setPassword(casestudy.getPassword());
//        return user;
//
//    }
}
