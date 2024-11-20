package com.ashutosh.product.serviceImp;


import com.ashutosh.product.dto.EmpReqDto;
import com.ashutosh.product.dto.EmpResDto;
import com.ashutosh.product.model.Employee;
import com.ashutosh.product.repo.EmpRepo;
import com.ashutosh.product.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImp implements EmployeeService {

    @Autowired
    EmpRepo repo;
    @Override
    public EmpResDto saveEmp(EmpReqDto dto){
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setPassword(dto.getPassword());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());

        Employee fromDB = repo.save(emp);

        EmpResDto response = new EmpResDto();
        response.setId(fromDB.getId());
        response.setName(fromDB.getName());
        response.setEmail(fromDB.getEmail());
        response.setPassword(fromDB.getPassword());
        response.setPassword(fromDB.getDepartment());
        response.setSalary(fromDB.getSalary());
        return response;
    }

    @Override
    public List<EmpResDto> getAllEmp() {
        List<Employee> emps = repo.findAll();
        List<EmpResDto> dtoList = new ArrayList<>();
        for(Employee emp:emps){
            EmpResDto dto = new EmpResDto();
            dto.setId(emp.getId());
            dto.setName(emp.getName());
            dto.setEmail(emp.getEmail());
            dto.setPassword(emp.getPassword());
            dto.setDepartment(emp.getDepartment());
            dto.setSalary(emp.getSalary());
            dtoList.add(dto);
        }
        return dtoList;
    }
    @Override
    public EmpResDto updateEmp(Integer id, EmpReqDto dto){
        Optional<Employee> emp = repo.findById(id);
        if(emp.isPresent()){
            Employee updateEmp = emp.get();
            updateEmp.setName(dto.getName());
            updateEmp.setEmail(dto.getEmail());
            updateEmp.setPassword(dto.getPassword());
            updateEmp.setDepartment(dto.getDepartment());
            updateEmp.setSalary(dto.getSalary());
            Employee emp1 = repo.save(updateEmp);
            EmpResDto response = new EmpResDto();
            response.setId(emp1.getId());
            response.setName(emp1.getName());
            response.setEmail(emp1.getEmail());
            response.setPassword(emp1.getPassword());
            response.setDepartment(emp1.getDepartment());
            response.setSalary(emp1.getSalary());
            return response;
        }
        return null;
    }
    @Override
    public EmpResDto getEmpById(Integer id){

        Optional<Employee> emp = repo.findById((id));
        if(emp.isPresent()){
            EmpResDto response = new EmpResDto();
            response.setId(emp.get().getId());
            response.setName(emp.get().getName());
            response.setEmail(emp.get().getEmail());
            response.setPassword(emp.get().getPassword());
            response.setDepartment(emp.get().getDepartment());
            response.setSalary(emp.get().getSalary());
            return response;
        }
      return null;
    }

    @Override
    public void deleteById(Integer id){
        repo.deleteById(id);
    }

}
