package com.example.fileupload.ControllerTest;


import com.example.fileupload.Controller.JobTitleController;
import com.example.fileupload.Entity.Department;
import com.example.fileupload.Service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(JobTitleController.class)
public class JobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    DepartmentService mockService;

    @Test
    void shouldReturnUserNameWhenUserExists() throws Exception {
        // Given
        List<Department> jobTitles = List.of(new Department("Accountant"), new Department("Doctor"));

        Mockito.when(mockService.saves(jobTitles)).thenReturn("John");

        // When & Then

        String payload = """
            {
              "name": "Alice"
            }
            """;
//        mockMvc.perform(post("/saves")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string("John"));
    }
}
