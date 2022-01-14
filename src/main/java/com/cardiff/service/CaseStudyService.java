package com.cardiff.service;

import com.cardiff.entity.CaseStudy;
import com.cardiff.repository.CaseStudyRepository;
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
    //get the elements by id
    public CaseStudy findById(Long id){
        return caseStudyRepository.findById(id).get();
    }
    //save the elements
    public CaseStudy saveCaseStudy(CaseStudy casestudy)  {
        return caseStudyRepository.save(casestudy);
    }


}
