package src.service.impl;

import src.colors.Color;
import src.shapes.Shape;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import src.service.ShapesService;

public class ShapesServiceImpl implements ShapesService {
    @Override
    public double getSquares(List<Shape> shapeList){
        double sum = 0;

        for(Shape shape : shapeList){
            sum += shape.getSquare();
        }

        return sum;
    }
    @Override
    public double getMaxPerimeters(List<Shape> shapeList){
        double maxPerimeter = -1;

        for(Shape shape : shapeList){
            maxPerimeter = Math.max(maxPerimeter, shape.getPerimeter());
        }

        return maxPerimeter;
    }

    @Override
    public Set<Color> getColors(List<Shape> shapeList){
        Set<Color> set = new HashSet<>();

        for(Shape shape : shapeList){
            set.add(shape.getColor());
        }

        return set;
    }
}
