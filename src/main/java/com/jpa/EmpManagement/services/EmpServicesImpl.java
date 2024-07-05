package com.jpa.EmpManagement.services;

import com.jpa.EmpManagement.entities.Emp;
import com.jpa.EmpManagement.repos.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServicesImpl implements EmpServices{

    @Autowired
    private EmpRepository empRepository;

    @Override
    public List<Emp> getAllEmps() {
        return empRepository.findAll();
    }

    @Override
    public Emp getEmpById(int id) {
        Optional<Emp> optional=empRepository.findById(id);
        return optional.get();
    }

    @Override
    public Emp saveEmp(Emp emp) {
        if (emp!=null){
            return (Emp) empRepository.save(emp);
        }
        return null;
    }

    @Override
    public List<Emp> saveAllEmp(List<Emp> listEmp) {
        if (listEmp!=null){
            return (List<Emp>) empRepository.saveAll(listEmp);
        }
        return null;
    }

    @Override
    public Emp updateEmp(Emp emp) {
        if(emp!=null){
            Optional<Emp> optional=empRepository.findById(emp.getId());
            Emp orgEmp=optional.get();
            if(orgEmp!=null){
                orgEmp.setName(emp.getName());
                orgEmp.setAge(emp.getAge());
                orgEmp.setSalary(emp.getSalary());
                return (Emp) empRepository.save(orgEmp);
            }
        }
        return null;
    }

    @Override
    public void deleteEmpById(int id) {
        empRepository.deleteById(id);
    }

    @Override
    public void deleteEmp(Emp emp) {
        empRepository.delete(emp);
    }

    @Override
    public Emp getEmpByName(String name) {
        return empRepository.findByName(name);
    }

    @Override
    public Emp getEmpByAge(int age) {
        return empRepository.getEmpByAge(age);
    }

    @Override
    public List<Emp> getEmpsBySalary(double minSal, double maxSal) {
        return empRepository.getEmpsBySalary(minSal,maxSal);
    }
}
