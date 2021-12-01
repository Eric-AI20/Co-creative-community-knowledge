package com.cardiff.service;

import com.cardiff.entity.CaseStudy;
import com.cardiff.entity.Community;
import com.cardiff.repository.CaseStudyRepository;
import com.cardiff.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    display the case study in the url
 */
@Service
public class CaseStudyService {
    private CaseStudyRepository caseStudyRepository;

    @Autowired
    public void setCaseStudyRepository(CaseStudyRepository caseStudyRepository) {
        this.caseStudyRepository = caseStudyRepository;
    }

    public CaseStudy findById(Long id){
        return caseStudyRepository.findById(id).get();
    }
}
