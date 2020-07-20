package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao dd = DaoFactory.createDepartmentDao();
		
		System.out.println("====  Test 1: department findById  ====");
		System.out.println(dd.findById(2));
		
		System.out.println("\n====  Test 2: department findAll  ====");
		dd.findAll().forEach(System.out::println);
		
		System.out.println("\n====  Test 3: department insert  ====");
		Department dp = new Department(null, "Music");
		dd.insert(dp);
		System.out.println("Generated Id: " + dp.getId());
		
		System.out.println("\n====  Test 4: department update  ====");
		dp = dd.findById(5);
		dp.setName("Fast Food");
		dd.update(dp);
		System.out.println("Updated!");
		
		System.out.println("\n====  Test 5: department delete  ====");
		System.out.print("Enter Id for delete test: ");
		dd.deleteById(sc.nextInt());	
		System.out.println("Deleted!");
		
		sc.close();
	}

}
