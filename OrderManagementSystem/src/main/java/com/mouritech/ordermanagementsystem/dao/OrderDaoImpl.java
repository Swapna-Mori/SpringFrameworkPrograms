package com.mouritech.ordermanagementsystem.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mouritech.ordermanagementsystem.model.Order;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		Session hibSession = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = hibSession.getCriteriaBuilder();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		//select * from order
		Root<Order> root = cq.from(Order.class);
		cq.select(root);
		Query query = hibSession.createQuery(cq);
		return query.getResultList();
	}

}
