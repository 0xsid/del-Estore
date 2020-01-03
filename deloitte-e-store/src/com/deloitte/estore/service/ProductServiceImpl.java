package com.deloitte.estore.service;

import java.sql.Connection;
import java.util.List;

//import com.deloitte.estore.applicaiton.product;
import com.deloitte.estore.model.Product;
import com.deloitte.estore.repo.ProductRepo;
import com.deloitte.estore.repo.ProductRepoImpl;
import com.deloitte.estore.util.*;
public class ProductServiceImpl implements ProductService{

	
	
	public ProductServiceImpl() {
		
	}

	ProductRepo repo;
	
	@Override
	public boolean addProduct(Product product) throws Exception {
		repo = new ProductRepoImpl();
		if(product.getProductId()<=0) {
			throw new InvalidProductIdException("Product Id can't be less than or equal to zero");
		}
		
		if(product.getProductName().length()<3)
			throw new InvalidProductNameException("Product Name shouldn't be less than 3 letters");
		if(product.getPrice()<0)
			throw new InvalidProductPriceException("Product Price cannot be negative");
		boolean forReturn = repo.addProduct(product);
		return forReturn;
	}

	@Override
	public boolean deleteProduct(Product product) throws Exception {
		repo = new ProductRepoImpl();
		if(product.getProductId()<=0) {
			throw new InvalidProductIdException("Product Id can't be less than or equal to zero");
		}
		if(product.getProductName().length()<3)
			throw new InvalidProductNameException("Product Name shouldn't be less than 3 letters");
		if(product.getPrice()<0)
			throw new InvalidProductPriceException("Product Price cannot be negative");
		boolean forReturn = repo.deleteProduct(product);
		return forReturn;
	}

	@Override
	public boolean updateProduct(Product product) throws Exception {
	  
		repo = new ProductRepoImpl();
		if(product.getProductId()<=0) {
			throw new InvalidProductIdException("Product Id can't be less than or equal to zero");
		}
		if(product.getProductName().length()<3)
			throw new InvalidProductNameException("Product Name shouldn't be less than 3 letters");
		if(product.getPrice()<0)
			throw new InvalidProductPriceException("Product Price cannot be negative");
		boolean forReturn = repo.updateProduct(product);
		return forReturn;
		
	}

	@Override
	public Product getProductById(int productId) throws Exception {
		repo = new ProductRepoImpl();
		if(productId<=0) {
			throw new InvalidProductIdException("Product Id can't be less than or equal to zero");
		}
		
		Product forReturn = repo.getProductById(productId);
		return forReturn;
	}

	@Override
	public List<Product> getAllProducts() throws Exception {
		repo = new ProductRepoImpl();
		try {
		List <Product> pList = repo.getAllProducts();
		return pList;
		}
		catch(Exception e) {
		throw new Exception("Product list couldn't be fetched due to some error");
			//return null;
		}
		
		
	}

	@Override
	public Connection getDbConnection() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
