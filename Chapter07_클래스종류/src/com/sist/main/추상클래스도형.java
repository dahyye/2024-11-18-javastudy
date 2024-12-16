package com.sist.main;

abstract class Shape
{
	String type;
	Shape(String type)
	{
		this.type=type;
	}
	abstract double area();
	abstract double length();
}

class Circle extends Shape
{
	int r;
	Circle(int r)
	{
		super("원");
		this.r=r;
	}
	@Override
	double area() {
		// TODO Auto-generated method stub
		
		return r*r*Math.PI;
	}

	@Override
	double length() {
		// TODO Auto-generated method stub
		return 2*r*Math.PI;
	}
	public String toString()
	{
		return "Shape [type="+type+",r="+r+"]";
				
	}
	
}

class Rectangle extends Shape{

	int width, height;
	Rectangle(int width,int height)
	{
		super("사각형");
		this.width = width;
		this.height=height;
	}
	@Override
	double area() {
		// TODO Auto-generated method stub
		return width*height;
	}

	@Override
	double length() {
		// TODO Auto-generated method stub
		return 2*(width+height);
	}
	
	public String toString()
	{
		return "Shape [type="+type+",width"+width+",height="+height;
	}
}

public class 추상클래스도형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] shapes  = new Shape[2];
		shapes[0]= new Circle(10);
		shapes[1]= new Rectangle(5,5);
		for(Shape s:shapes)
		{
			System.out.println(s);
			System.out.println("넓이:"+s.area()+", 둘레: "+s.length());
		}
	}

}
