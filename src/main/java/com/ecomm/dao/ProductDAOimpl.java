package com.ecomm.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Product;
@Repository("productDAO")
@Transactional
public class ProductDAOimpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addProduct(Product product)
	{
		try
		{
		sessionFactory.getCurrentSession().save(product);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) 
	{
		try
		{
		sessionFactory.getCurrentSession().delete(product);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product)
	{
		try
		{
		sessionFactory.getCurrentSession().update(product);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}	
	}

	@Override
	public Product getProduct(int productId)
	{
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class,productId);
		session.close();
		return product;
	}

	@Override
	public List<Product> listProducts() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProducts= query.list();
		session.close();
		return listProducts;
	}

	@Override
	public List<Product> listProductsCategoryWise(int categoryId)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where categoryId=:catid ");
		List<Product> listProducts= query.list();
		session.close();
		return listProducts;
	}

}
