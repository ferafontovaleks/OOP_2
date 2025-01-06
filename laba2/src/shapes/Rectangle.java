package src.shapes;

import src.colors.Color;

public class Rectangle extends Shape {
    private Point pointA = new Point();
    private Point pointB = new Point();

    private void validate() throws Exception{
        if (pointA.getX() == pointB.getX() || pointA.getY() == pointB.getY()) throw new java.lang.Exception("Неверные координаты точки");
    }

    public Point getPointA(){
        return pointA;
    }

    public void setPointA(Point newPoint) throws Exception {
        pointA = newPoint;
        validate();
    }

    public Rectangle(){}

    public Rectangle(Point point1, Point point2, Color color) throws Exception {
        pointA = point1;
        pointB = point2;
        validate();
        setColor(color);
    }

    public Rectangle(Point point1, Point point2) throws Exception {
        pointA = point1;
        pointB = point2;
        validate();
    }


    public Point getPointB(){
        return pointB;
    }

    public void setPointB(Point newPoint) throws Exception {
        pointB = newPoint;
        validate();
    }

    @Override
    public double getSquare(){
        return Math.abs((pointA.getX() - pointB.getX()) * (pointA.getY() - pointB.getY()));
    }

    @Override
    public double getPerimeter(){
        return 2 * (Math.abs(pointA.getX() - pointB.getX()) + Math.abs(pointA.getY() - pointB.getY()));
    }

    @Override
    public void move(double moveX, double moveY){
        pointA.move(moveX, moveY);
        pointB.move(moveX, moveY);
    }

    @Override
    public void draw(){
        System.out.println("Фигура: Прямоугольник");
        System.out.print("Противоположные вершины прямоугольника: (" + pointA.getX() + ", " + pointA.getY() + "); ");
        System.out.println("(" + pointB.getX() + ", " + pointB.getY() + ")");
        System.out.println("Площадь прямоугольника: " + this.getSquare());
        System.out.println("Периметр прямоугольника: " + this.getPerimeter());
        System.out.println("Цвет прямоугольника: " + getColor());
    }
}
