package com.example.persistence.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class EntityTest {

    @Test
    public void givenBidirRel_withJsonIgnore()
            throws JsonProcessingException {
        String name1 = "first";
        String name2 = "last";
        String dName = "test_dept";

        Address addr = Address.builder().addrId(123).city("Blore").state("KA").zip(560038).build();
        Department dept = Department.builder()
                                    .deptId(1)
                                    .name(dName)
                                    .hod("Jerry")
                                    .size(5).build();
        Employee emp = new Employee.EmployeeBuilder()
                                    .empId(11)
                                    .firstname(name1)
                                    .lastname(name2)
                                    .salary(1500)
                                    .joindate(new Date())
                                    .dept(dept)
                                    .address(addr).build();
        dept.addEmp(emp);
        String result = new ObjectMapper().writeValueAsString(emp);
        System.out.println("Json object " +result);

        assertThat(result, containsString(name1));
        assertThat(result, containsString(dName));
        assertThat(result, not(containsString("emps")));
    }
}
