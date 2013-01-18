package com.spring.example;

import java.util.ArrayList;
import java.util.List;

public class TriangleWithListOfPoints {
	
	private List <Point> points = new ArrayList<>();

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void draw() {
		
		for(Point p : points) {
			System.out.println("Point = "+p.getX()+" , "+p.getY());
		}
	
	}

}
