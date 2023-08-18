package com.example.model;

import com.example.persistence.entity.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpSaveResponse extends BaseResponse {

    // By default, json response has node name as 'emp_simple'
    @JsonProperty("emp")
    private Employee emp;

    @Builder
    public EmpSaveResponse(List<Error> errList, Employee emp) {
        super(errList);
        this.emp = emp;
    }
}
