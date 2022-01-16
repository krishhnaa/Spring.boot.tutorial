package com.yallapanthula.Spring.boot.tutorial.controller;

import com.yallapanthula.Spring.boot.tutorial.entity.Department;
import com.yallapanthula.Spring.boot.tutorial.service.DepartmentService;
import com.yallapanthula.Spring.boot.tutorial.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);

    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @GetMapping(value = "/departments/{id}")
    public  Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping(value ="/departments/{id}" )
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully";
    }

    @DeleteMapping(value ="/departments/name/{name}" )
    public String deleteDepartmentName(@PathVariable("name") String departmentName) {
        departmentService.deleteDepartmentByName(departmentName);
        return "Department deleted Successfully";
    }

    @PutMapping(value = "/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentID,@RequestBody Department department) {
        return departmentService.updateDepartment(departmentID, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
    @GetMapping("/departments/code/{code}")
    public Department fetchDepartmentByCode(@PathVariable("code") String departmentCode) {
        return departmentService.fetchDepartmentByCode(departmentCode);
    }
}
