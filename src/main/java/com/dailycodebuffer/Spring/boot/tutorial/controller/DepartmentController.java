package com.dailycodebuffer.Spring.boot.tutorial.controller;

import com.dailycodebuffer.Spring.boot.tutorial.entry.Department;
import com.dailycodebuffer.Spring.boot.tutorial.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    private final Logger Logger = LoggerFactory.

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@Valid @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/AllDepartments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id){
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public String DeleteDepartmentById(@PathVariable("id") Long departmentId){
         departmentService.DeleteDepartmentById(departmentId);
         return departmentId+" Has been deleted successfully";
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/name/{name}")
    public Department fetchDepartmentByName(@PathVariable ("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
