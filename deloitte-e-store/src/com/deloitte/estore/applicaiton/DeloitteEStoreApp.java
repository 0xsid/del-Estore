package com.deloitte.estore.applicaiton;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

public class DeloitteEStoreApp {

	public static void main(String[] args){
		ProductService service = new ProductServiceImpl();

		System.out.println("Enter Choice of Operation:");
		System.out.println("1.Get Product List");
		System.out.println("2.Add Product");
		System.out.println("3.Delete Product");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice) {
		//Get all products method call
		case 1:
		System.out.println("Getting All products:\n");
       try {
		List<Product> pList = service.getAllProducts();
        Iterator<Product> itr = pList.iterator();
        Product ref;
        System.out.println("ProductId\tProductName\tProductPrice");
        while(itr.hasNext()) {
        	ref = itr.next();
        	System.out.println("  "+ref.getProductId()+"\t\t"+ref.getProductName()+"\t\t"+ref.getPrice());
        }}
       catch(Exception e) {
    	   System.out.println(e.getMessage());
    	   e.printStackTrace();
       }
        break;
        //addProduct method Call
		case 2:
            System.out.println("Enter data for product:");
            int id;
            String name;
            double price;
            
            System.out.println("Enter Product Id");
            id = input.nextInt();
            System.out.println("Enter Product Name");
            name = input.next();
            System.out.println("Enter Product Price");
            price = input.nextDouble();
			Product p =new Product(id,name,price);
	        try {
	        	if(service.addProduct(p)) {
	        	System.out.println("Product added..");	
	        	}
	        	else {
	        		System.out.println("Product Not Added..");
	        	}
	        }
			catch(Exception e) {
				e.printStackTrace();
			}
	        break;
	        
	        //Delete Product Method Call
		case 3:
			Product pDel =new Product(105,"Oneplus7Pro",800.00);
	        try {
	        	if(service.deleteProduct(pDel)) {
	        	System.out.println("Product added..");	
	        	}
	        	else {
	        		System.out.println("Product Not Added..");
	        	}
	        }
			catch(Exception e) {
				e.printStackTrace();
			}
	        break;
	       default:
	    	   System.out.println("Invalid Choice!");
		}
		
		
     }

}
