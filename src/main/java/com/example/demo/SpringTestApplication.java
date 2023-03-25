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
		String Name ;
		String Address;
		int Id ;
		
		int choice;
		
		while(flag) {
			System.out.println("****************************");
			System.out.println("(1).Insert Data");
			System.out.println("(2).Show Data");
			System.out.println("(3).Delete Data");
			System.out.println("(4).Update Data");
			System.out.println("(5).Search Data");
			System.out.println("(0).Exit");
			System.out.println("****************************");
			
			System.out.print("Enter Choice :");
			choice = Integer.parseInt(scan.nextLine());
			
			switch (choice) {
			
			case 1:
				System.out.println("Fill Details ");
				
				System.out.print("Name : ");
				String name = scan.nextLine();
				
				System.out.print("Address : ");
				String address = scan.nextLine();
				
				e = new Employee(name, address);
				
				dao.save(e);
				
				System.out.println("Data Inserted Successfully");
			break;
			
			case 2:
				System.out.println("****************************");
				System.out.println("\nAll Employees \n");
				System.out.println("****************************");
				
				List<Employee> list = dao.getallEmp();
				
				for(Employee emp:list) {
					System.out.println(emp);
				}
			break;

			case 3:
				System.out.print("Enter ID to delete: ");
				int id = Integer.parseInt(scan.nextLine());
				e.setId(id);
				
				dao.delete(e);
				System.out.println("Data Deleted Successfully");
			break;

			case 4:
				System.out.print("Enter ID to update Details: ");
				int  empId = Integer.parseInt(scan.nextLine());
				
				Employee emp = dao.getById(empId);
				System.out.println(emp);
				
				System.out.println("What do you want to update ?");
				System.out.println("(1). Name");
				System.out.println("(2). Address");
				
				int key = Integer.parseInt(scan.nextLine());
				
				switch (key) {
				case 1:
					System.out.println("Enter New Name : ");
					Name = scan.nextLine();
					Address = emp.getAddress();
					Id = emp.getId();
					e = new Employee(Id, Name, Address);
					dao.update(e);
				break;
				
				case 2:
					System.out.println("Enter New Address : ");
					Address = scan.nextLine();
					Name = emp.getName();
					Id = emp.getId();
					e = new Employee(Id, Name, Address);
					dao.update(e);
				break;

				default:
					System.out.println("Invalid Choice");
				break;
				}
				
				
				System.out.println("Data Updated Successfully");
			break;
			
			case 5:
				System.out.print("Enter ID to get Details: ");
				int id1 = Integer.parseInt(scan.nextLine());
				Employee myemp = dao.getById(id1);
				System.out.println(myemp.getName());
			break;
			
			case 0:
				System.out.println("Log out successfull.");
				flag=false;
			break;

			default:
				System.out.println("INVALID INPUT");
				break;
			}
			
		}
		
	}

}
