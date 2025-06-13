package com.example.aidevbackendtask.controller;

import com.example.aidevbackendtask.dto.UserDTO;
import com.example.aidevbackendtask.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllUsers_shouldReturnListOfUsers() throws Exception {
        UserDTO dto = new UserDTO();
        dto.setId(1L);
        dto.setName("Valeryia");
        dto.setUsername("val");
        dto.setEmail("test@example.com");

        when(userService.getAllUsers()).thenReturn(List.of(dto));

        mockMvc.perform(get("/users")
                        .header("Authorization", "Bearer faketoken")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Valeryia"));
    }
}