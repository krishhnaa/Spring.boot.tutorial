package com.yallapanthula.Spring.boot.tutorial.service;

import com.yallapanthula.Spring.boot.tutorial.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

  public Department fetchDepartmentById(Long departmentId);

    public  void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentID, Department department);

    public Department fetchDepartmentByName(String departmentName);

    public Department fetchDepartmentByCode(String departmentCode);


    public void deleteDepartmentByName(String departmentName);
}
