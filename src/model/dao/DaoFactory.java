package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	//instanciar a implementa��o de SellerDao o SellerDaoJDBC sem precisar instanciar na classe principal o SellerDaoJDBC
   //dessa forma a classe principal n�o conhecer� a implementa��o de SellerDao a SellerDaoJDBC, ou seja, fica mais pr�tico de implementar	
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}

}
