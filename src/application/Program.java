package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
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
		
	}

}
