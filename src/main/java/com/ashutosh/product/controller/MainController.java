package com.ashutosh.product.controller;

import com.ashutosh.product.dto.EmpReqDto;
import com.ashutosh.product.dto.EmpResDto;
import com.ashutosh.product.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class MainController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/check")
    public ResponseEntity<String> check(){
        return new ResponseEntity<>("Running Successfully...", HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<EmpResDto> addEmployee(@RequestBody EmpReqDto reqDto){
        EmpResDto response = employeeService.saveEmp(reqDto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/getEmployee")
    public ResponseEntity<List<EmpResDto>> getEmployeeList(){
        List<EmpResDto> resDtoList = employeeService.getAllEmp();
        return ResponseEntity.ok(resDtoList);
    }

    @GetMapping("/getEmpbyid/{id}")
    public ResponseEntity<EmpResDto> getEmpById(@PathVariable Integer id){
        EmpResDto response = employeeService.getEmpById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateEmployee/{id}")
    public ResponseEntity<EmpResDto> updateEmployee(@PathVariable Integer id,@RequestBody EmpReqDto dto) {
        EmpResDto response = employeeService.updateEmp(id, dto);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
