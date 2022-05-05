package com.cardiff.controller;

import com.cardiff.entity.CaseStudy;
import com.cardiff.entity.Post;
import com.cardiff.entity.User;
import com.cardiff.repository.CaseStudyRepository;
import com.cardiff.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CaseStudyControllerTest {
    @Autowired
    private CaseStudyRepository caseStudyRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    @Disabled
    void setUp() {

        // add principal object to SecurityContextHolder
        User user = new User();
        user.setEmail("test@test.com");
        user.setFirstName("tester");
        user.setId(100L);
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null);
        SecurityContextHolder.getContext().setAuthentication(auth);


    }

    @Test
    void showCaseStudyPage() {
    }

    @Test
    void showCreateCaseStudyPage() throws Exception{
        CaseStudy caseStudy = new CaseStudy();
        caseStudy.setId(10L);
        caseStudy.setTitle("My First post");
        caseStudy.setCaseEvaluation("Body");
        caseStudy.setCaseIntroduction("sdas");
        caseStudy.setCaseSolutions("sdsad");
        caseStudy.setImplementations("sdad");
        caseStudy.setConclusion("sdsad");

    }

    @Test
    void saveCaseStudyForm() {
    }
}