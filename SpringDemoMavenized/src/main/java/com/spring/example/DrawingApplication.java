package com.spring.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context= new ClassPathXmlApplicationContext("springlisttagdemo.xml"); //Bean Factory's big brother
		
		//**** Till tutorial 6***
		//Triangle triangle = (Triangle)context.getBean("triangle");
		//triangle.draw();
		
		//****Introducing injecting Objects and the list tag (For injecting objects, change to triangleWithPoints****
		TriangleWithListOfPoints triangleWithListOfPoints = (TriangleWithListOfPoints)context.getBean("triangleWithListOfPoints");
		triangleWithListOfPoints.draw();
	}

}
