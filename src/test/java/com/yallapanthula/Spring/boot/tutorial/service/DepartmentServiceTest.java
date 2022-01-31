package com.yallapanthula.Spring.boot.tutorial.service;

import com.yallapanthula.Spring.boot.tutorial.entity.Department;
import com.yallapanthula.Spring.boot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeAll
    void setUp() {
        Department department = Department.builder()
                .departmentName("Supply Chain")
                .departmentAddress("MA")
                .departmentCode("SC-02")
                .departmentId(10L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Supply Chain"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get Data Based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){

        String departmentName = "Supply Chain";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }
}
