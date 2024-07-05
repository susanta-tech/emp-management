package com.jpa.EmpManagement.controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.jpa.EmpManagement.entities.Emp;
import com.jpa.EmpManagement.services.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpServices empServices;

    @GetMapping
    public List<Emp> getAllEmps(){
       return empServices.getAllEmps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emp> getEmpById(@PathVariable("id") int id){
        Emp emp = empServices.getEmpById(id);
        return ResponseEntity.ok(emp);
    }

    //http://localhost:8080/emp/save
    /*
    {
    "name" : "Dipu",
    "age" : 32,
    "salary" : 25000
    }
     */
    @PostMapping("/save")
    public ResponseEntity<Emp> saveEmp(@RequestBody Emp emp){
        Emp savedEmp = empServices.saveEmp(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmp);
    }

    //http://localhost:8080/emp/saveall
    /*
    [{
    "name" : "Bapu",
    "age" : 30,
    "salary" : 50000
    },
    {
    "name" : "Situ",
    "age" : 22,
    "salary" : 27000
    }]
     */
    @PostMapping("/saveall")
    public ResponseEntity<List<Emp>> saveAllEmp(@RequestBody List<Emp> listEmp){
        List<Emp> savedListEmp = empServices.saveAllEmp(listEmp);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedListEmp);
    }


    @PutMapping("/update")
    public ResponseEntity<Emp> updateEmp(@RequestBody Emp emp){
        Emp updatedEmp= empServices.updateEmp(emp);
        return ResponseEntity.ok(updatedEmp);
    }

    @DeleteMapping
    public String deleteEmp(@RequestBody Emp emp){
        empServices.deleteEmp(emp);
        return "Employee Successfully deleted";
    }

    @DeleteMapping("/{id}")
    public String deleteEmpById(@PathVariable("id") int id){
        empServices.deleteEmpById(id);
        return "Emp ID: "+id+" Successfully deleted";
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Emp> getEmpByName(@PathVariable("name") String name){
        Emp emp = empServices.getEmpByName(name);
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<Emp> getEmpByAge(@PathVariable("age") int age){
        Emp emp = empServices.getEmpByAge(age);
        return ResponseEntity.ok(emp);
    }

    //http://localhost:8080/emp/salary?minSal=23000&maxSal=40000
    @GetMapping("/salary")
    public ResponseEntity<List<Emp>> getEmpsBySalary(@RequestParam("minSal") double minSal, @RequestParam("maxSal") double maxSal){
        List<Emp> listEmp = empServices.getEmpsBySalary(minSal, maxSal);
        return ResponseEntity.ok(listEmp);
    }

}
