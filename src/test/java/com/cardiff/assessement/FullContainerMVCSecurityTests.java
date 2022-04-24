package com.cardiff.assessement;

import com.cardiff.controller.PostController;
import com.cardiff.service.FragmentService;
import com.cardiff.service.PostService;
import com.sun.security.auth.UserPrincipal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
@AutoConfigureTestDatabase
public class FullContainerMVCSecurityTests {

    // @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @MockBean
    private FragmentService fragmentService;

    @MockBean
    private UserDetailsService userDetailsService;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }



    @Test
    public void forumCreatePostLoggedInUser() throws Exception {

        this.mockMvc.perform(post("/forum/createPost")
                        .principal(new UserPrincipal("test"))
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("communityId", "2")
                        .param("body", "abc")
                        .param("title", "sads"))
                .andDo(print())
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/forum/home"));

    }


}
