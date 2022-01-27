package Model.DAO;

import java.util.List;

import Model.Entities.Seller;

public interface SellerDAO {

	void insert (Seller obj  ); 
	void update (Seller obj); 
	void DeletById (Integer id ); 
	Seller findById(Integer id ); 
    List <Seller> findALL  () ; 
}
