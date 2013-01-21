package com.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.dao.jdbcDaoImpl;
import com.springjdbc.model.Circle;

public class JDBCDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		jdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", jdbcDaoImpl.class);
		
		//Circle circle = new JDBCDAOImpl().getCircle(1);
		//Circle circle = dao.getCircle(1);
		//System.out.println(circle.getName());
		
		//System.out.println(dao.getCircleCount());
//		dao.insertCircle(new Circle(3,"Third Circle"));
//		System.out.println(dao.getCircleForId(1).getName());
//		System.out.println(dao.getAllCircles().size());
		
		dao.createTriangleTable();
		

	}

}
