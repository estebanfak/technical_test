package com.vortex.challenge.controller;

import com.vortex.challenge.model.Department;
import com.vortex.challenge.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


    @PostMapping()
    public Department addDepartment(@RequestParam String departmentName,
                                    @RequestParam long locationId) throws Exception{
        return departmentService.addDepartment(departmentName, locationId);
    }
}
