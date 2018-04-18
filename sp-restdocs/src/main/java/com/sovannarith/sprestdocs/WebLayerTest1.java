package com.sovannarith.sprestdocs;

import com.sovannarith.sprestdocs.RestController.UserController;
import com.sovannarith.sprestdocs.UserService.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class WebLayerTest1 {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/h")).andDo(print()).andExpect(status().isOk())
                .andDo(document("{class-name}/{method-name}", responseFields(
                        fieldWithPath("str").description("Field named str of Hey Class"),
                        fieldWithPath("strr").description("Field named strr of Hey Class")
                )));

    }
//                        requestFields(fieldWithPath("id").description("The id of user"),
//                                fieldWithPath("name").description("The name of user"),
//                                fieldWithPath("gender").description("The gender of user")
//                                )));


//                .andDo(document("get user by id", responseFields(
//            fieldWithPath("id").type(Long.TYPE).description("The id of user.")
//                            ,fieldWithPath("name").description("The name of user.")
//                            ,fieldWithPath("gender").description("The gender of user.")
//                        )))
}