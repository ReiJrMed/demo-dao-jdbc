package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	//instanciar a implementação de SellerDao o SellerDaoJDBC sem precisar instanciar na classe principal o SellerDaoJDBC
   //dessa forma a classe principal não conhecerá a implementação de SellerDao a SellerDaoJDBC, ou seja, fica mais prático de implementar	
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}

}
