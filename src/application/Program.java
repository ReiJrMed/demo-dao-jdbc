package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SellerDao sd = DaoFactory.createSellerDao();
		
		System.out.println("====  Test 1: seller findById  ====");
		Seller seller = sd.findById(3);
		System.out.println(seller);
		
		System.out.println("\n====  Test 2: seller findByDepartment  ====");
		List<Seller> sellers = sd.findByDepartment(seller.getDepartment());
		sellers.forEach(System.out::println);
		
		System.out.println("\n====  Test 3: seller findAll  ====");
		sellers.clear();
		sellers = sd.findAll();
		sellers.forEach(System.out::println);
		
		System.out.println("\n====  Test 4: seller insert  ====");
		seller = new Seller(null, "Greg", "Greg@gmail.com", sdf.parse("23/08/2000"), 4000.0, new Department(2, "Electronics"));
		sd.insert(seller);
		System.out.println("Inserted, new Id = " + seller.getId());
		
	}

}
