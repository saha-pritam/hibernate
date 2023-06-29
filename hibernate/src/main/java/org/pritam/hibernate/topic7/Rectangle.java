package org.pritam.hibernate.topic7;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Rectangles")
public class Rectangle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(column = @Column(name="X1"), name = "x"),
			@AttributeOverride(column = @Column(name="Y1"), name = "y")})
	private Point point1;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name="X2"), name = "x"),
		@AttributeOverride(column = @Column(name="Y2"), name = "y")})
	private Point point2;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name="X3"), name = "x"),
		@AttributeOverride(column = @Column(name="Y3"), name = "y")})
	private Point point3;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name="X4"), name = "x"),
		@AttributeOverride(column = @Column(name="Y4"), name = "y")})
	private Point point4;
	@Column(name="Length")
	private double length;
	@Column(name="Breadth")
	private double breadth;
	@Column(name="Area")
	private double area;
	@Column(name="Perimeter")
	private double perimeter;
	
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Consider the triangle as
	 * POINT1 * * * * * * * * * POINT2
	 * 		  *               *
	 * 		  *               *
	 * 		  *               *
	 * 		  *               *
	 * POINT4 * * * * * * * * * POINT3
	 * 
	 * @param point1
	 * @param point2
	 * @param point3
	 * @param point4
	 */
	public Rectangle(Point point1, Point point2, Point point3, Point point4) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.point4 = point4;
		this.length = Math.sqrt(Math.pow(point1.getX()-point2.getX(), 2)+Math.pow(point1.getY()-point2.getY(), 2));
		this.breadth = Math.sqrt(Math.pow(point1.getX()-point4.getX(), 2)+Math.pow(point1.getY()-point4.getY(), 2));
	}
	public Point getPoint1() {
		return point1;
	}
	public void setPoint1(Point point1) {
		this.point1 = point1;
	}
	public Point getPoint2() {
		return point2;
	}
	public void setPoint2(Point point2) {
		this.point2 = point2;
	}
	public Point getPoint3() {
		return point3;
	}
	public void setPoint3(Point point3) {
		this.point3 = point3;
	}
	public Point getPoint4() {
		return point4;
	}
	public void setPoint4(Point point4) {
		this.point4 = point4;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getBreadth() {
		return breadth;
	}
	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getPerimeter() {
		return perimeter;
	}
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
	
	public void calcArea() {
		this.area = this.length * this.breadth;
	}
	
	public void calcPerimeter() {
		this.perimeter = 2 * (this.length + this.breadth);
	}
	
	@Override
	public String toString() {
		return "Rectangle [point1=" + point1 + ", point2=" + point2 + ", point3=" + point3 + ", point4=" + point4
				+ ", length=" + length + ", breadth=" + breadth + ", area=" + area + ", perimeter=" + perimeter + "]";
	}	
}
