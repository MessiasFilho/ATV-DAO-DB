package Aplication;

import java.util.Date;

import Model.DAO.DaoFactory;
import Model.DAO.SellerDAO;
import Model.Entities.Deparment;
import Model.Entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Iserir dados  Mysql 
		
		SellerDAO sellerdao  = DaoFactory.CreateSellerDao(); 
		Deparment dep = new Deparment ( 1 , null  );  
		
		Seller sel =new  Seller (null , "Fernando Oliveira" ,"Fernando@Gmail.com ",new Date() , 3500.0, dep  ); 
		
		//sellerdao.insert(sel);
		
		
		
		
		
		System.out.println(sel.toString());
		
		
		
	}

}
