package com.ashutosh.product.service;

import com.ashutosh.product.dto.EmpReqDto;
import com.ashutosh.product.dto.EmpResDto;

import java.util.List;

public interface EmployeeService {
    EmpResDto saveEmp(EmpReqDto dto);

    List<EmpResDto> getAllEmp();

    EmpResDto updateEmp(Integer id, EmpReqDto dto);

    EmpResDto getEmpById(Integer id);

    void deleteById(Integer id);
}
