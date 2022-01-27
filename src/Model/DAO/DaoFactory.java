package Model.DAO;

import Model.DAO.IMP.SellerDAOJDBC;

public class DaoFactory {
	
	public static SellerDAO CreateSellerDao() {
		return new SellerDAOJDBC() ;  
	}

	

}
