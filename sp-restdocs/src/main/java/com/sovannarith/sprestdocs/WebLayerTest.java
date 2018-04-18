package com.sovannarith.sprestdocs;

import com.google.gson.Gson;
import com.sovannarith.sprestdocs.RestController.UserController;
import com.sovannarith.sprestdocs.RestController.restDoc.RestDocController;
import com.sovannarith.sprestdocs.UserService.UserService;
import com.sovannarith.sprestdocs.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;

import javax.jnlp.UnavailableServiceException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

@RunWith(SpringRunner.class)
@WebMvcTest(RestDocController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private RestDocController restDocController;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/{id}", 1L)).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello World")))
                .andDo(document("get user by id", responseFields(
                    fieldWithPath("id").type(Long.TYPE).description("The id of user.")
                            ,fieldWithPath("name").description("The name of user.")
                            ,fieldWithPath("gender").description("The gender of user.")
                        )));

    }
    @Test
    public void deleteBatch() throws Exception {
        this.mockMvc.perform(delete("/users/{lst}", new Long[]{2L,1L}))
                .andDo(print()).andExpect(status().isOk())
                .andDo(document("delete user by array of id"));
    }

    @Test
    public void updateUser() throws Exception {
        User user = userService.getUserById(1L);
        Mockito.when(user).thenReturn(null);
        this.mockMvc.perform(put("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(new User(1L, "lele", "bun phum"))
                )).andDo(document("{class-name}/{method-name}"));
    }
}