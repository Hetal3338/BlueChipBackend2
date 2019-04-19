package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest
{    @Autowired
	public static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void excutedFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
	}
@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("Mobile");
		category.setCategoryDesc("Samsung");
		
		assertTrue("Problem in category Insertion:",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest() 
	{
		Category category=categoryDAO.getCategory(1);
		
		assertTrue("Problem in category Deletation:",categoryDAO.deleteCategory(category));
		
	}
	@Ignore
	@Test
	public void updatecategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		category.setCategoryDesc("All Cofiguration");
		
		assertTrue("Problem in category Updation:",categoryDAO.updateCategory(category));
	}
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.listCategory();
		
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+"::");
			System.out.print(category.getCategoryName()+"::");
			System.out.println(category.getCategoryDesc()+"::");
		}
	}
	
}
