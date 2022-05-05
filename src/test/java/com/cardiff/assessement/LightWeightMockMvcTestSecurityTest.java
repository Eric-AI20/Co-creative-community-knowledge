//package com.cardiff.assessement;
//
//
//import com.cardiff.controller.CaseStudyController;
//import com.cardiff.controller.PostController;
//import com.cardiff.service.CaseStudyService;
//import com.cardiff.service.FragmentService;
//import com.cardiff.service.PostService;
//import com.sun.security.auth.UserPrincipal;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(CaseStudyController.class)
//@AutoConfigureTestDatabase
//public class LightWeightMockMvcTestSecurityTest {
//
//    // @Autowired
//    private MockMvc mockMvc;
//
//    /*
//    @MockBean
//    private PostService postService;
//    */
//
//    @MockBean
//    private CaseStudyService caseStudyService;
//
//    @MockBean
//    private FragmentService fragmentService;
//
//    @MockBean
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//
//    @BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//
//    @Test
//    public void forumCreatePostLoggedInUser() throws Exception {
//        /*
//        this.mockMvc.perform(post("/forum/createPost")
//                        .principal(new UserPrincipal("test"))
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("communityId", "2")
//                        .param("body", "abc")
//                        .param("title", "sads"))
//                .andDo(print())
//                .andExpect(status().is(302))
//                .andExpect(redirectedUrl("/forum/home"));
//        */
//        this.mockMvc.perform(post("/createCaseStudy/communityId")
//                        .principal(new UserPrincipal("test"))
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("communityId", "2")
//                        .param("Id", "2")
//                        .param("title", "abc")
//                        .param("caseIntruduction", "sads")
//                        .param("caseEvaluation", "sads")
//                        .param("caseSolutions", "sads")
//                        .param("implementations", "sads")
//                        .param("conclusion", "sads")
//
//                )
//                .andDo(print())
//                .andExpect(status().is(302))
//                .andExpect(redirectedUrl("/viewCaseStudy/communityId"));
//    }
//
//    /*
//    @Test
//    public void forumCreatePostWhenUserIsLoggedIn() throws Exception {
//
//        this.mockMvc.perform(post("/forum/createPost")
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("communityId", "2")
//                        .param("body", "abc")
//                        .param("title", "sads"))
//                .andDo(print())
//                .andExpect(status().is(302))
//                .andExpect(redirectedUrl("/forum/home?message=Unable+to+create+Post"));
//
//    }
//     */
//
//
//}
