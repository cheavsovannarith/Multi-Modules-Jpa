//package com.sovannarith.sprestdocs;
//
//import com.sovannarith.sprestdocs.RestController.UserController;
//import com.sovannarith.sprestdocs.UserService.UserService;
//import com.sovannarith.sprestdocs.model.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.constraints.ConstraintDescriptions;
//import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
//import org.springframework.restdocs.payload.FieldDescriptor;
//import org.springframework.restdocs.snippet.Attributes;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.util.StringUtils;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
//import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.restdocs.mockmvc.RestDocumentationResultHandler.*;
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(UserController.class)
//@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
//public class WebLayerTest2 {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @Test
//    public void getPerson() throws Exception {
//        User user = userService.getUsers(1L);
//
//        when(userService.getUsers(1L)).thenReturn(user);
//        mockMvc.perform(get("/{id}", 1L))
//                .andExpect(status().isNotFound());
//        verify(userService, timeout(1)).getUsers(1L);
//        verifyNoMoreInteractions(userService);
//    }
//
//    @Test
//    public void getUserDoc() throws Exception{
//
////        User user = userService.getUsers(1L);
////
////        when(userService.getUsers(1L)).thenReturn(user);
//        this.mockMvc.perform(
//                get("/id").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(document("subsystem",responseFields(
//                        fieldWithPath("id").description("Subsystem name"),
//                        fieldWithPath("name").description("Subsystem name"),
//                        fieldWithPath("gender").description("Subsystem description"))));
//
//    }
//
////                        requestFields(fieldWithPath("id").description("The id of user"),
////                                fieldWithPath("name").description("The name of user"),
////                                fieldWithPath("gender").description("The gender of user")
////                                )));
//
//
////                .andDo(document("get user by id", responseFields(
////            fieldWithPath("id").type(Long.TYPE).description("The id of user.")
////                            ,fieldWithPath("name").description("The name of user.")
////                            ,fieldWithPath("gender").description("The gender of user.")
////                        )))
//}