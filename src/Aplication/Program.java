package Aplication;

import java.util.Date;

import Model.DAO.DaoFactory;
import Model.DAO.SellerDAO;
import Model.Entities.Deparment;
import Model.Entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deparment dep = new Deparment ( 2 , "Celular" ); 
		Seller sell = new Seller(1 , "Alex ", "Alex@gmail.com", new Date() , 300.0 , dep   ) ;   
		
		System.out.println(sell );
		
		
		SellerDAO SeDao = DaoFactory.CreateSellerDao();
		
				

	
	}
	

}
