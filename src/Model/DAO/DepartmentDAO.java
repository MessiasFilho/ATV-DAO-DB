package Model.DAO;

import java.util.List;

import Model.Entities.Deparment;

public interface DepartmentDAO {

	void insert (Deparment obj  ); 
	void update (Deparment obj); 
	void DeletById (Integer id ); 
	Deparment findById(Integer id ); 
    List <Deparment> findALL  () ; 
    
}
