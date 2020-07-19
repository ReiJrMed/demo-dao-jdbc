package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		try {
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    
			Department dp = new Department(1, "Livros");
		    
			Seller seller = new Seller(21, "Bob", "Bob@gmail.com", sdf.parse("22/08/1988"), 3000.0, dp);
		    
		    System.out.println(seller);
        
		} catch (ParseException e) {
			
			e.printStackTrace();
		}


	}

}
