package com.example.springdata.emp.controller;

import com.example.model.BaseResponse;
import com.example.model.EmpSaveResponse;
import com.example.persistence.entity.Employee;
import com.example.springdata.emp.service.EmpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(EmpController.class)
public class EmployeeControllerTest {

    @MockBean
    EmpService mockService;

    @MockBean
    BaseResponse mockResponse;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testSaveEmp() throws Exception {
        String name1 = "TEST";
        String name2 = "test_dept";
        int sal = 3333;
        int id = 123;
        Employee testReq = Employee.builder().firstname(name1).lastname(name2).salary(sal).build();
        Employee empEntity = Employee.builder().empId(id).firstname(name1).lastname(name2).salary(sal).build();
        EmpSaveResponse response = EmpSaveResponse.builder().emp(empEntity).errList(null).build();

        // Mockito calls
        Mockito.when(mockService.saveEmployee(testReq)).thenReturn(empEntity);

        //$” is the response JSON root level.
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/emp")
                        .content(new ObjectMapper().writeValueAsString(testReq))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.emp.name").value(name1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.emp.lastname").value(name2));

    }
}
