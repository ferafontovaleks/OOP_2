package src.shapes;

import src.colors.Color;

public class Point extends Shape{
    private double x = 0.0, y = 0.0;

    public double getX(){
        return this.x;
    }

    public void setX(double newX){
        this.x = newX;
    }

    public double getY(){
        return this.y;
    }

    public void setY(double newY){
        this.y = newY;
    }

    public Point(){}

    public Point(double x, double y, Color color){
        this.x = x;
        this.y = y;
        setColor(color);
    }

    @Override
    public double getPerimeter(){return 0.0;}

    @Override
    public double getSquare(){return 0.0;}

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(){
        System.out.println("Фигура: Точка");
        System.out.println("Координаты точки: (" + x + ", " + y + ")");
        System.out.println("Цвет точки: " + getColor());
    }

    @Override
    public void move(double moveX, double moveY){
        this.x += moveX;
        this.y += moveY;
    }

    public static double distance(Point point1, Point point2){
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }
}
