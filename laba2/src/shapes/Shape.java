package src.shapes;

import src.colors.Color;

import java.util.function.BiConsumer;

public abstract class Shape {
    private Color color = Color.TRANSPARENT;

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color newColor){
        this.color = newColor;
    }

    public abstract double getSquare();

    public abstract double getPerimeter();

    public abstract void move(double moveX, double moveY);
    public void move(BiConsumer<Double, Double> lambda, double moveX, double moveY){
        lambda.accept(moveX, moveY);
    }
    public abstract void draw();
}
