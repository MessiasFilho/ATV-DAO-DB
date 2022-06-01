package Model.DAO;

import DB.Conecxao;
import Model.DAO.IMP.SellerDAOJDBC;

public class DaoFactory {
	
	public static SellerDAO CreateSellerDao() {
		return new SellerDAOJDBC(Conecxao.getConnection() ) ;  
	}

	

}
