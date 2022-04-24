package com.cardiff;


import com.cardiff.controller.PostController;
import com.cardiff.service.FragmentService;
import com.cardiff.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
@AutoConfigureTestDatabase
public class MockMVCTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @MockBean
    private FragmentService fragmentService;

    @MockBean
    private UserDetailsService userDetailsService;


    @Test
    public void forumHomeTest() throws Exception {
        this.mockMvc.perform(get("/forum/home")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Forum")));
    }

    @Test
    public void getPostByCommunityId() throws Exception {
        this.mockMvc.perform(get("/forum/sortByCommunityId/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Forum")));
    }
}
