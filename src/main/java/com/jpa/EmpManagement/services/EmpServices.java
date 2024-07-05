package com.jpa.EmpManagement.services;

import com.jpa.EmpManagement.entities.Emp;

import java.util.List;

public interface EmpServices {
    public List<Emp> getAllEmps();
    public Emp getEmpById(int id);
    public Emp saveEmp(Emp emp);
    public List<Emp> saveAllEmp(List<Emp> listEmp);
    public Emp updateEmp(Emp emp);
    public void deleteEmpById(int id);
    public void deleteEmp(Emp emp);

    public Emp getEmpByName(String name);

    public Emp getEmpByAge(int age);

    public List<Emp> getEmpsBySalary(double minSal, double maxSal);
}
