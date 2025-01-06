package src.shapes;

import src.colors.Color;

import java.util.function.BiConsumer;

public class Triangle extends Shape{
    private Point pointA, pointB, pointC;

    public void setPointA(Point newPoint){
        pointA = newPoint;
    }

    public Point getPointA(){
        return pointA;
    }
    public void setPointB(Point newPoint){
        pointB = newPoint;
    }

    public Point getPointB(){
        return pointB;
    }

    public void setPointC(Point newPoint){
        pointC = newPoint;
    }

    public Point getPointC(){
        return pointC;
    }

    private void validate() throws Exception{
        if (getSquare() == 0) throw new java.lang.Exception("Точки не должны располагаться на одной прямой");
    }

    public Triangle(){}
    public Triangle(Point point1, Point point2, Point point3, Color color) throws Exception{
        pointA = point1;
        pointB = point2;
        pointC = point3;
        validate();
        setColor(color);
    }

    public Triangle(Point point1, Point point2, Point point3) throws Exception{
        pointA = point1;
        pointB = point2;
        pointC = point3;
        validate();
    }

    @Override
    public double getSquare(){
        double p = getPerimeter() / 2;
        double dist1 = Point.distance(pointA, pointB);
        double dist2 = Point.distance(pointA, pointC);
        double dist3 = Point.distance(pointB, pointC);

        return Math.sqrt(p * (p - dist1) * (p - dist2) * (p - dist3));
    }

    @Override
    public double getPerimeter(){
        double dist1 = Point.distance(pointA, pointB);
        double dist2 = Point.distance(pointA, pointC);
        double dist3 = Point.distance(pointB, pointC);

        return dist1 + dist2 + dist3;
    }

    @Override
    public void move(double moveX, double moveY){
        BiConsumer<Double, Double> func = (aDouble, aDouble2) -> {
            pointA.move(moveX, moveY);
            pointB.move(moveX, moveY);
            pointC.move(moveX, moveY);
        };
        super.move(func, moveX, moveY);
    }

    @Override
    public void draw(){
        System.out.println("Фигура: Треугольник");
        System.out.print("Вершины Треугольника: (" + pointA.getX() + ", " + pointA.getY() + "); ");
        System.out.println("(" + pointB.getX() + ", " + pointB.getY() + "); ");
        System.out.println("(" + pointC.getX() + ", " + pointC.getY() + "); ");
        System.out.println("Площадь Треугольника: " + this.getSquare());
        System.out.println("Периметр Треугольника: " + this.getPerimeter());
        System.out.println("Цвет Треугольника: " + getColor());
    }
}
