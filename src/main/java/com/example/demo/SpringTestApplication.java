package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDao;

@SpringBootApplication
public class SpringTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
		Scanner scan = new Scanner(System.in);
		boolean flag=true;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeDao dao = (EmployeeDao) context.getBean("EmpDao");
		Employee e=  new Employee();
		
		int choice;
		
		while(flag) {
			
			System.out.println("1.Insert Data");
			System.out.println("2.Show Data");
			System.out.println("3.Delete Data");
			System.out.println("4.Update Data");
			System.out.println("5.Search Data");
			System.out.println("0.Exit");
			
			System.out.print("Enter Choice :");
			choice = Integer.parseInt(scan.nextLine());
			
			switch (choice) {
			
			case 1:
				System.out.print("Name : ");
				String name = scan.nextLine();
				
				System.out.print("Address : ");
				String address = scan.nextLine();
				
				
				 e = new Employee(name, address);
				
				dao.save(e);
				
				System.out.println("Data Inserted Successfully");
				
			break;
			
			case 2:
				System.out.println("All Data");
				
				List<Employee> list = dao.getallEmp();
				
				for(Employee emp:list) {
					System.out.println(emp);
				}
				
			break;

			case 3:
				System.out.print("Enter ID : ");
				int id = Integer.parseInt(scan.nextLine());
				e.setId(id);
				
				dao.delete(e);
				
				System.out.println("Data Deleted Successfully");
				
			break;

			case 4:
				System.out.print("Enter ID : ");
				int roll = Integer.parseInt(scan.nextLine());
				
				System.out.print("Name : ");
				String name1 = scan.nextLine();
				
				System.out.print("Address : ");
				String address1 = scan.nextLine();
				
				e= new Employee(roll, name1, address1);
				
				dao.update(e);
				
				System.out.println("Data Updated Successfully");
			break;
			
			case 5:
				System.out.print("Enter ID : ");
				int id1 = Integer.parseInt(scan.nextLine());
				Employee emp = dao.getById(id1);
				System.out.println(emp.getName());
			break;
			
			case 0:
				System.out.println("Data Exited Successfully");
				flag=false;
			break;

			default:
				System.out.println("INVALID INPUT");
				break;
			}
			
		}
		
	}

}
