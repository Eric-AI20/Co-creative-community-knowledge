
package com.cardiff.controller;
import com.cardiff.entity.CaseStudy;
import com.cardiff.repository.CaseStudyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * mock mvc test
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CaseStudyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired

    private CaseStudyRepository caseStudyRepository;

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