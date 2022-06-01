package Aplication;

import java.util.ArrayList;
import java.util.List;

import Model.DAO.DaoFactory;
import Model.DAO.SellerDAO;
import Model.Entities.Deparment;
import Model.Entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		System.out.println("Teste 1 == findById");
		SellerDAO sel = DaoFactory.CreateSellerDao();  
		Seller sell = sel.findById(2); 
		System.out.println(sell );
		
		
		System.out.println("\nTESTE 2 == FindByDepartment");
		Deparment dep = new Deparment  (2 , null  ); 
		List <Seller> list = sel.FindByDepartment(dep ); 
		for (Seller obj : list ) {
			System.out.println(obj);
		}
				
		System.out.println("\n Teste3 == findALL ==  ");
		
		List <Seller > list2 = new ArrayList<>();  
		list2= sel.findALL(); 
		for (Seller obj : list2 ) {
			System.out.println(obj);
			
		}
		
	}
	

}
