package com.jpa.EmpManagement;

import com.jpa.EmpManagement.services.EmpServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmpManagementApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(EmpManagementApplication.class, args);
		//EmpServices empServices=(EmpServices) context.getBean("empServicesImpl");
	}

}
