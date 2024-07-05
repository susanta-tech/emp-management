package com.jpa.EmpManagement.repos;

import com.jpa.EmpManagement.entities.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpRepository extends JpaRepository<Emp,Integer> {

    //custom methods
    public Emp findByName(String name);

    //hql query
    @Query("Select e from Emp e where e.age= :age")
    public Emp getEmpByAge(@Param("age") int age);

    //sql query
    @Query(value = "Select * from Emp e where e.salary> :minSal and e.salary< :maxSal", nativeQuery = true)
    public List<Emp> getEmpsBySalary(@Param("minSal") double minSal, @Param("maxSal") double maxSal );
}
