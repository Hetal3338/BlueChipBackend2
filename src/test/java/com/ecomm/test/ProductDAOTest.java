package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

public class ProductDAOTest 
{
	@Autowired
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	@Ignore
	@Test
	public void addProductTest()
	{
	Product product=new Product();
	
	product.setProductName("Mercury");
	product.setProductDesc("Mercury motherboard with configuration");
	product.setStock(32);
	product.setSupplierId(3);
	product.setCategoryId(4);
	product.setPrice(23000);
	
	assertTrue("Problem in Adding Category:",productDAO.addProduct(product));
	}
	
	@Test
	public void listProductTest()
	{
		List<Product> listProducts=productDAO.listProducts();
		
		
		for(Product product:listProducts)
		{
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.print(product.getProductDesc()+":::");
			System.out.print(product.getStock()+":::");
			System.out.println(product.getPrice()+":::");
		}
	}
	
}
