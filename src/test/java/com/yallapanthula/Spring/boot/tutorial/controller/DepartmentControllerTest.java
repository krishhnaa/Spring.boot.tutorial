package com.yallapanthula.Spring.boot.tutorial.controller;

import com.yallapanthula.Spring.boot.tutorial.entity.Department;
import com.yallapanthula.Spring.boot.tutorial.error.DepartmentNotFoundException;
import com.yallapanthula.Spring.boot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp() {
         department = Department.builder()
                 .departmentAddress("MA")
                 .departmentCode("SC-02")
                 .departmentName("Supply Chain")
                 .departmentId(10L)
                 .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department department = Department.builder()
                .departmentAddress("MA")
                .departmentCode("SC-02")
                .departmentName("Supply Chain")
                .build();
        Mockito.when(departmentService.saveDepartment(department))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\n" +
                        "\"departmentName\":\"Supply Chain\",\n" +
                        "\"departmentAddress\":\"MA\",\n" +
                        "\"departmentCode\":\"SC-02\",\n" +
                        "}"));
    }

    @Test
    void fetchDepartmentById() throws Exception {
//       Mockito.when(departmentService.fetchDepartmentById(de))
    }
}
