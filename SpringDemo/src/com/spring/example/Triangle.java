package com.spring.example;

public class Triangle {
	
	private String type;
	int height;
//Injection by constructor
	Triangle(String type) {
	  this.type = type;
	}
	
	Triangle(String type, int height) { //the height set in the blue print automatically gets converted to int !
	  this.type=type;
	  this.height = height;
	}
	//Automatic conversions could cause issue, Like what if we had:
	Triangle(int height) {
	  this.height = height;
	}
	
	public void draw() {
		System.out.println(getType()+" Drawing Trainagle! and its height = "+getHeight());
	}

	public String getType() {
		return type;
	}
	
//  Setter injection
//	public void setType(String type) {
//		this.type = type;
//	}
	
	public int getHeight() {
    return height;
  }
}
